(ns cljorbits.planet-test
  (:require [clojure.test :refer :all]
            [cljorbits.core :refer :all]
            [cljorbits.system :refer :all]
            [cljorbits.planet :refer :all]
            ))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)

(deftest make-sinusoidal-dims-test
  (testing "planet/make-sinusoidal-dims"
    (is (= 3 (count (make-sinusoidal-dims 24 1.0 1.0))))
    (is (> 1500
           (:hours-per-radian (make-sinusoidal-dims (* 24 365) 63e7 63e7))
           1000))))

