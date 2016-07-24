(ns cljorbits.planet-test
  (:require [clojure.test :refer :all]
            [cljorbits.core :refer :all]
            [cljorbits.system :refer :all]
            [cljorbits.planet :refer :all]
            ))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)

(deftest make-sinusoidal-dims-test
  (testing "planet/make-sinusoidal-dims"
    (let [planet-0 { :period-hours 24
                    :semi-major-kms 1.0
                    :semi-minor-kms 1.0
                    :inclination-deg 0}
          planet-1 (assoc planet-0 :period-hours (* 365 24))]
      (is (= 6 (count (make-sinusoidal-dims planet-0))))
      (is (> 1500                                           ; between 1500 and 1000
             (:hours-per-radian (make-sinusoidal-dims planet-1))
             1000)))))

(deftest add-update-orbit-params-test
  (testing "planet/add-update-orbit-params"
    (is (coll? (add-update-orbit-params
                 cljorbits.systems.terrestrial/planets)))))

(deftest make-position-test
  (testing "planet/make-position"
    (let [planet-0 { :period-hours 24
                    :semi-major-kms 1.0
                    :semi-minor-kms 1.0
                    :inclination-deg 0}
          planet-1 (assoc planet-0 :inclination-deg 7)]
      (is (= 3 (count (make-position (make-sinusoidal-dims planet-0) 0))))
      (is (= (first (make-position (make-sinusoidal-dims planet-0) 0))
             0.))
      ; between checks:
      (is (> 1.
             (first (make-position (make-sinusoidal-dims planet-0) 1)) ; x no inclin
             0.))
      (is (> 1.
             (first (make-position (make-sinusoidal-dims planet-1) 1)) ; x, inclin
             0.))
      (is (> 1.
             (first (make-position (make-sinusoidal-dims planet-1) 12)) ; x half-period
             0.))
      (is (< -1.
             (first (make-position (make-sinusoidal-dims planet-1) 13)) ; x over half
             0.)))))
