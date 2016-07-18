(ns cljorbits.planet
  (:require
    [cljorbits.systems.solar.sun :as sun]
    [cljorbits.systems.solar.mercury :as mercury]
    [cljorbits.systems.solar.venus :as venus]
    [cljorbits.systems.solar.earth :as earth]
    [cljorbits.systems.solar.mars :as mars]
    [cljorbits.systems.solar.jupiter :as jupiter]
    [cljorbits.systems.solar.saturn :as saturn]
    [cljorbits.systems.solar.neptune :as neptune]
    [cljorbits.systems.solar.uranus :as uranus]
    [cljorbits.systems.solar.comet :as comet]
    ))

(defn make-planet [app id name]
  {:type :planet
   :name name :id id
   :curr-pos (atom [0, 0, 0] )
   :props (atom {})}
  )

(defn make-sun [app id name]
  {:type :sun
   :name name :id id
   :curr-pos (atom [0, 0, 0] )
   :props (atom {})}
  )

(defn make-comet [app id name]
  {:type :planetessimal
   :class :comet
   :name name :id id
   :curr-pos (atom [0, 0, 0] )
   :props (atom {})}
  )

; TODO refactor for different "type" of system?
(defn make-position-for [app sys type make-for]
  (let [name (make-for :name)]
    (case name
      ; center
      :sun (sun/make-position app sys)

      ; terrestrial
      :mercury (mercury/make-position app sys)
      :venus (venus/make-position app sys)
      :earth (earth/make-position app sys)
      :mars (mars/make-position app sys)

      ; giant
      :jupiter (jupiter/make-position app sys)
      :saturn (saturn/make-position app sys)
      :neptune (neptune/make-position app sys)
      :pluto (uranus/make-position app sys)

      ; default e.g. [:comet :xyz] = class + name
      (comet/make-position app sys name)
      )))

(defn make-positions-for [app sys type]
  (let [make-for-coll (sys type)]
    (map #(make-position-for app sys type %) make-for-coll))
  )

; :planetessimals (planet/make-positions-for app sys :planetessimals)}
