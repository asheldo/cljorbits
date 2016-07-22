(ns cljorbits.core
  (:require [cljorbits.system :as sys])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [app (sys/init-app "solar.system")
        ss (sys/make-system-of-type app :planetary :terrestrial-solar)
        pos (sys/make-positions-for app ss)
        steps 1
        next-pos (sys/move-orbits app ss pos steps)]
    (println "Hello, World: " (:id ss))
    (println "You're at " (str next-pos))
    next-pos)
)
