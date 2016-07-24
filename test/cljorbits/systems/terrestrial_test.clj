(ns cljorbits.systems.terrestrial-test
  (:require [clojure.test :refer :all]
            [cljorbits.systems.terrestrial :refer :all]
            [cljorbits.system :refer :all]))

(deftest planets-test
  (testing "system s"
    (is (let [planets (:planets cljorbits.systems.terrestrial/planets)
              planets-by-name (reduce #(assoc %1 (:name %2) %2) {} planets)
              mercury (:mercury planets-by-name)
              _ (println mercury)]
          mercury))
    ))