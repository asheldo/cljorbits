(ns cljorbits.planet)

(declare make-sinusoidal-dims)

(defn make-sinusoidal-orbit [app sys p]
  (let [period (:period-hours p)
        semi-major (:semi-major-kms p)
        semi-minor (:semi-minor-kms p)
        ecc (:eccentricity p)
        inc (:inclination-rad p)
        sinus-x-y (make-sinusoidal-dims period semi-major semi-minor)]
    [sinus-x-y]))

(defn make-sinusoidal-dims [period-hours semi-major-km semi-minor-km]
  "At 0 hour, let's do ...? major = +semi , minor = 0."
  (let [hours-per-radian (/ period-hours (* Math/PI 2.0))   ; e.g. 24h -> 3.81971
        major-sinus-fn
        (fn [hour] "Over period/2 sin goes -1:1 for rad -PI/2:PI/2; "
          (let [rads (/ hour hours-per-radian)
                sin (Math/cos rads)
                major-axis-pos (* sin semi-major-km)]
            major-axis-pos))
        minor-sinus-fn
        (fn [hour]
          (let [rads (/ hour hours-per-radian)
                sin (Math/sin rads)
                minor-axis-pos (* sin semi-minor-km)]
            minor-axis-pos))
        ]
    {:major-axis-sinus-fn major-sinus-fn :minor-axis-sinus-fn minor-sinus-fn
     :hours-per-radian hours-per-radian }))
