(ns cljorbits.system
  (:require [cljorbits.planet :as planet]))

(defn init-app [options-file]
  (atom {:opts options-file
         :ids (java.util.concurrent.atomic.AtomicInteger. 0)}))

(defn make-id [app] (.getAndIncrement (@app :ids)))

(declare make-system-of-type)

(defn load-system [app data-file]
  nil )

(defn save-system [app system]
  nil )

(defn make-system-of-type [app type sys-name]
  (case [type sys-name]
    [:planetary :close-solar]
    {:id sys-name
     :center
         (planet/make-sun app (make-id app) :sun)
     :planets
         [(planet/make-planet app (make-id app) :mercury)]
     }
    [:planetary :terrestrial-solar]
    {:id sys-name
     :center
         (planet/make-sun app (make-id app) :sun)
     :planets
         [(planet/make-planet app (make-id app) :mercury)
          (planet/make-planet app (make-id app) :venus)
          (planet/make-planet app (make-id app) :earth)
          (planet/make-planet app (make-id app) :mars)]
     :planetessimals
         [(planet/make-comet app (make-id app) [:comet :shoemaker])]
     }
    ))

;; candidate for structure
(defn make-positions-for [app sys] "returns rect coordinates in map"
  (let [pos {:center
             [0 0 0]
             :planets
             (vec (planet/make-positions-for app sys :planets))
             :planetessimals
             (vec (planet/make-positions-for app sys :planetessimals))}]
    pos))

(defn move-planets [app sys pos steps]
  pos)