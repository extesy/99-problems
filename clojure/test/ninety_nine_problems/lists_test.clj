(ns ninety-nine-problems.lists-test
  (:require [clojure.test :refer :all]
            [ninety-nine-problems.lists :refer :all]))

; P01
(deftest last'-test
  (is (= 3 (last' '(1 2 3)))))

(deftest last'-test-empty
  (is (nil? (last' '()))))

(deftest last'-test-singleton
  (is (= 1 (last' '(1)))))

; P02
(deftest butlast'-test
  (is (= 2 (butlast' '(1 2 3)))))

(deftest butlast'-test-empty
  (is (nil? (butlast' '()))))

(deftest butlast'-test-single
  (is (nil? (butlast' '(1)))))
