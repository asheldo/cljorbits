(ns cljorbits.planet)

(declare make-sinusoidal-dims)

(defn make-sinusoidal-orbit [app sys p]
  (let [period (:period-hours p)
        semi-major (:semi-major-kms p)
        semi-minor (:semi-minor-kms p)
        ecc (:eccentricity p)
        inclin (:inclination-deg p)
        sinus-x-y-z (make-sinusoidal-dims period semi-major semi-minor inclin)]
    [sinus-x-y-z]))

(defn make-sinusoidal-dims [period-hr semi-major-km semi-minor-km inclination-deg]
  "At 0 hour, let's do ...? major = +semi , minor = 0."
  (let [hours-per-rad (/ period-hr (* Math/PI 2.0))   ; e.g. 24h -> 3.81971
        inclin-rad (/ inclination-deg (/ 180 Math/PI))      ; e.g. 7deg -> 7/57
        semi-major-part (if (zero? inclin-rad) 1. (Math/cos inclin-rad)) ; merc = 99%
        semi-inclin-part (if (zero? inclin-rad) 0 (Math/sin inclin-rad)) ; merc = 12%
        sinus-fn (fn [is-sin multiplier time-hour] "Over period/2 sin goes -1:1 for rad -PI/2:PI/2; "
                   (let [rads (/ time-hour hours-per-rad)
                         axis-pos (* multiplier
                                     (if is-sin (Math/sin rads) (Math/cos rads)))]
                     axis-pos))]
    {:major-axis-sinus-fn (partial sinus-fn false semi-major-km)
     :minor-axis-sinus-fn (partial sinus-fn true semi-minor-km)
     :semi-major-part semi-major-part
     :semi-inclin-part semi-inclin-part
     :hours-per-radian hours-per-rad
     :inclination-radians inclin-rad }))
