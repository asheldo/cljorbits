(ns cljorbits.system-test
  (:require [clojure.test :refer :all]
            [cljorbits.system :refer :all]))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)
(deftest system-test
  (testing "system"
    (is (= nil (cljorbits.system/load-system nil nil)))))
