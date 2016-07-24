(ns cljorbits.core
  (:require [cljorbits.system :as sys])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [app (sys/init-app "solar.system")
        ss (sys/make-system app :terrestrial-solar)
        pos nil
        ; TODO
        ; (sys/make-positions app ss 0)
        steps 1
        next-pos []
        ; (sys/move-orbits app ss pos steps)
        ]
    (println "Hello, World: " (:id ss))
    (println "You're at " (str next-pos))
    next-pos)
)
