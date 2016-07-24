(ns cljorbits.planet)

(declare make-sinusoidal-dims)

(defn assoc-sinusoidal-orbit [app sys planet] "add orbit to planet once"
  (if (:sinusoidal-orbit planet)
    planet                                                  ; <- then
    (assoc planet                                           ; <- else
      :sinusoidal-orbit
      (make-sinusoidal-dims planet))))

(defn make-sinusoidal-dims [planet]
  "At 0 hour, let's do ...? major = +semi , minor = 0."
  (let [period-hr (:period-hours planet)
        semi-major-km (:semi-major-kms planet)
        semi-minor-km (:semi-minor-kms planet)
        inclination-deg (:inclination-deg planet)
        hours-per-rad (/ period-hr (* Math/PI 2.0))   ; e.g. 24h -> 3.81971
        inclin-rad (/ inclination-deg (/ 180 Math/PI))      ; e.g. 180 deg -> 3.14~ rad see Math/toRadians
        semi-major-part (if (zero? inclin-rad)
                          1. (Math/cos inclin-rad)) ; merc = 99%
        semi-inclin-part (if (zero? inclin-rad)
                           0 (Math/sin inclin-rad)) ; merc = 12%
        sinus-fn (fn [is-sin multiplier time-hour]
                   "Over period/2 sin goes -1:1 for rad -PI/2:PI/2; "
                   (let [rads (/ time-hour hours-per-rad)
                         value (if is-sin (Math/sin rads)
                                          (Math/cos rads))]
                     (* multiplier value)))]
    {:major-axis-sinus-fn (fn y-z [t] "call closure with last (time) argument"
                            (apply sinus-fn false semi-major-km [t])) ; partial
     :minor-axis-sinus-fn (fn x [t]
                            (apply sinus-fn true semi-minor-km [t])) ; partial
     :semi-major-part semi-major-part
     :semi-inclin-part semi-inclin-part
     :hours-per-radian hours-per-rad
     :inclination-radians inclin-rad }))

(defn make-position [planet time-hour]
  (let [y-z-fn (:major-axis-sinus-fn planet)
        y-z (y-z-fn time-hour)
        y (* y-z (:semi-major-part planet))
        z (* y-z (:semi-inclin-part planet))
        x-fn (:minor-axis-sinus-fn planet)
        x (x-fn time-hour)]
    [x y z]))

(defn add-update-orbit-params [planets-vec]
  "for now promote year 0 orbit to top-level; also assoc b = a * roundness"
  (for [planet planets-vec]
    (let [planet-orbit (get-in planet
                               [:orbits-mya 0.0])
          e-sqr (Math/pow (:eccentricity planet-orbit) 2)
          roundness (Math/sqrt (- 1 e-sqr))
          planet-parameterized (merge planet planet-orbit)]                ; = (1-ecc^2)^0.5
      (assoc planet-parameterized
        :semi-minor-axis-km (* (:semi-major-axis-km planet-orbit)
                               roundness)
        :roundness roundness))))