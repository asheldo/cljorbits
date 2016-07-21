(ns cljorbits.core-test
  (:require [clojure.test :refer :all]
            [cljorbits.core :refer :all]
            [cljorbits.system :refer :all]))

;(run-tests 'vector-test 'position-test 'object-test 'world-test)

(deftest core-test
  (testing "core"
    (is (not= nil (cljorbits.core/-main [])))))
