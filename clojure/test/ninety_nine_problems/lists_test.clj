(ns ninety-nine-problems.lists-test
  (:require [clojure.test :refer :all]
            [ninety-nine-problems.lists :refer :all]))

; Tests are borrowed from https://github.com/AustinRochford/99-problems-clojure/blob/master/test/ninety_nine_problems/lists_test.clj

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

; P03
(deftest take-nth'-test-one
  (is (= 1 (take-nth' '(1 2 3) 1))))

(deftest take-nth'-test-two
  (is (= 2 (take-nth' '(1 2 3) 2))))

(deftest take-nth'-test-three
  (is (= 3 (take-nth' '(1 2 3) 3))))

(deftest take-nth'-test-empty
  (is (nil? (take-nth' '() 1))))

(deftest take-nth'-test-too-small
  (is (nil? (take-nth' '(1 2) 3))))

; P04
(deftest length-test-one
  (is (= 1 (count' '(1)))))

(deftest length-test-two
  (is (= 2 (count' '(1 2)))))

(deftest length-test-empty
  (is (zero? (count' '()))))

(deftest length-test-large
  (is (= 100 (count' (range 100)))))

; P05
(deftest reverse'-test
  (is (= '(3 2 1) (reverse' '(1 2 3)))))

(deftest reverse'-test-empty
  (is (empty? (reverse' '()))))

; P06
(deftest palindrome?-test
    (is (palindrome? '(1 2 1))))

(deftest palindrome?-test-long
    (is (palindrome? '(1 2 1 3 4 3 1 2 1))))

(deftest palindrome?-test-empty
    (is (palindrome? '())))

(deftest palindrome?-test-false
    (is (not (palindrome? '(1 2 3 2)))))

; P07
(deftest flatten'-test
    (is (= '(1 2 3) (flatten' '((1) (2 (3)))))))

(deftest flatten'-test-flat
    (is (= '(1 2 3) (flatten' '(1 2 3)))))

; P08
(deftest dedupe'-test
    (is (= '(1 2 3) (dedupe' '(1 2 2 3 3 3)))))

(deftest dedupe'-test-nodups
    (is (= '(1 2 3) (dedupe' '(1 2 3)))))

(deftest dedupe'-test-repeat
    (is (= '(1 2 1) (dedupe' '(1 1 2 1 1)))))

; P09
(deftest pack-test
  (is (= '((1) (2 2) (3 3 3)) (pack '(1 2 2 3 3 3)))))

(deftest pack-test-singles
  (is (= '((1) (2) (3)) (pack '(1 2 3)))))

(deftest pack-test-repeat
  (is (= '((1 1) (2) (1 1)) (pack '(1 1 2 1 1)))))

; P10
(deftest encode-test
  (is (= '([1 1] [2 2] [3 3]) (encode '(1 2 2 3 3 3)))))

(deftest encode-test-singles
  (is (= '([1 1] [1 2] [1 3]) (encode '(1 2 3)))))

(deftest encode-test-repeat
  (is (= '([2 1] [1 2] [2 1]) (encode '(1 1 2 1 1)))))

; P11
(deftest encode'-test
  (is (= '(1 [2 2] [3 3]) (encode' '(1 2 2 3 3 3)))))

(deftest encode'-test-singles
  (is (= '(1 2 3) (encode' '(1 2 3)))))

(deftest encode'-test-repeat
  (is (= '([2 1] 2 [2 1]) (encode' '(1 1 2 1 1)))))

; P12
(deftest decode-test
  (is (= '(1 2 2 3 3 3) (decode '(1 [2 2] [3 3])))))

(deftest decode-test-singles
  (is (= '(1 2 3) (decode '(1 2 3)))))

(deftest decode-test-repeat
  (is (= '(1 1 2 1 1) (decode '([2 1] 2 [2 1])))))

; P14
(deftest duplicate-test
  (is (= '(1 1 2 2 3 3) (duplicate '(1 2 3)))))

(deftest duplicate-test-empty
  (is (= '() (duplicate '()))))

(deftest duplicate-test-duplicate
  (is (= '(1 1 1 1) (duplicate '(1 1)))))

; P15
(deftest replicate'-test
  (is (= '(1 1 1 2 2 2 3 3 3) (replicate' '(1 2 3) 3))))

(deftest replicate'-test-empty
  (is (= '() (replicate' '() 2))))

(deftest replicate'-test-zero
  (is (= '() (replicate' '(1 2 3) 0))))

(deftest replicate'-test-duplicate
  (is (= '(1 1 1 1 1 1) (replicate' '(1 1) 3))))
