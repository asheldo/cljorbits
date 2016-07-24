(ns cljorbits.system-test
  (:require [clojure.test :refer :all]
            [cljorbits.system :refer :all]))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)
(deftest system-test
  (testing "system"
    (is (= nil (load-system nil nil)))))

(deftest make-system-test
  (testing "make-system test"
    (is (make-system
          (init-app (java.io.File. "system.opts"))
          :terrestrial-solar))))

(deftest assoc-orbits-test
  (testing "assoc-orbits"
    (let [app (init-app (java.io.File. "system.opts"))
          sys (make-system app :terrestrial-solar)
          sys-next (assoc-orbits app sys)
          mercury-orbit (get-in sys-next [:mercury :sinusoidal-orbit])
          _ (println sys-next)]
      (is (coll? mercury-orbit)))))