(ns cljorbits.system
  (:require [cljorbits.planet :as planet]))

(defn init-app [options-file]
  (atom {:opts options-file
         :ids (java.util.concurrent.atomic.AtomicInteger. 0)}))

(defn make-id [app] (.getAndIncrement (@app :ids)))

(defn load-system [app data-file]
  nil )

(defn save-system [app system]
  nil )

(defn make-system-of-type [app type sys-name]
  nil )

  ;; candidate for structure
(defn make-positions-for [app sys] "returns rect coordinates in map"
  (let [pos {:center
             (vec [0 0 0])
             }]
    pos))

(defn move-orbits [app sys pos steps]
  pos)