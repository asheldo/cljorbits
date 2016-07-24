(ns cljorbits.system
  (:require [cljorbits.planet :as planet]
            [cljorbits.systems.terrestrial :as terrestrial]))

(defn init-app [options-file]
  (atom {:opts options-file
         :ids (java.util.concurrent.atomic.AtomicInteger. 0)}))

(defn make-id [app] (.getAndIncrement (@app :ids)))

(defn make-system [app type] "Take vector of planets, make name-mapped"
  (case type
    :terrestrial-solar
    (let [planets-vec (planet/add-update-orbit-params (:planets-vec terrestrial/planets))
          planets-by-name (reduce #(assoc %1 (:name %2) %2)
                                  {}
                                  planets-vec)]
      planets-by-name)))

  ;; candidate for structure

(defn assoc-orbits [app sys] "map"
  (let [next-planets (reduce #(assoc %1
                               (key %2)
                               (planet/assoc-sinusoidal-orbit
                                 app sys (val %2)) )
                             {}
                             sys)]
    next-planets))


(defn make-positions [app sys hour]
  nil)

(defn move-orbits [app sys pos steps]
  pos)


(defn load-system [app data-file]
  nil )

(defn save-system [app system]
  nil )
