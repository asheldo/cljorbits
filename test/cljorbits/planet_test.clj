(ns cljorbits.planet-test
  (:require [clojure.test :refer :all]
            [cljorbits.core :refer :all]
            [cljorbits.system :refer :all]
            [cljorbits.planet :refer :all]
            ))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)

(deftest make-sinusoidal-dims-test
  (testing "planet/make-sinusoidal-dims"
    (is (= 6 (count (make-sinusoidal-dims 24 1.0 1.0 0))))
    (is (> 1500
           (:hours-per-radian (make-sinusoidal-dims (* 24 365) 63e7 63e7 0))
           1000))))

(deftest make-position-test
  (testing "planet/make-position"
    (is (= 3 (count (make-position (make-sinusoidal-dims 24 1.0 1.0 0) 0))))
    (is (= (first (make-position (make-sinusoidal-dims 24 1.0 1.0 0) 0))
           0.))
    ; between checks:
    (is (> 1.
           (first (make-position (make-sinusoidal-dims 24 1.0 1.0 0) 1)) ; x no inclin
           0.))
    (is (> 1.
           (first (make-position (make-sinusoidal-dims 24 1.0 1.0 7) 1)) ; x, inclin
           0.))
    (is (> 1.
           (first (make-position (make-sinusoidal-dims 24 1.0 1.0 7) 12)) ; x half-period
           0.))
    (is (< -1.
           (first (make-position (make-sinusoidal-dims 24 1.0 1.0 7) 13)) ; x over half
           0.))
    ))
