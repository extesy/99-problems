(ns ninety-nine-problems.lists)

; Solutions for http://www.ic.unicamp.br/~meidanis/courses/mc336/2006s2/funcional/L-99_Ninety-Nine_Lisp_Problems.html

; P01
(defn last'
  "Find the last box of a list"
  [col]
  (let [[head & tail] col]
    (if (empty? tail)
      head
      (recur tail))))

; P02
(defn butlast'
  "Find the last but one box of a list"
  [col]
  (let [[head1 head2 & tail] col]
    (if (empty? tail)
      (if (nil? head2)
        nil
        head1)
      (recur (conj tail head2)))))

; P03
(defn take-nth'
  "Find the K'th element of a list"
  [col k]
  (let [[head & tail] col]
    (if (<= k 1)
      head
      (recur tail (dec k)))))

; P04
(defn count'
  "Find the number of elements of a list"
  [col]
  (if (empty? col)
    0
    (reduce (fn [a b] (+ a 1)) 0 col)))

; P05
(defn reverse'
  "Reverse a list"
  [col]
  (if (empty? col)
    nil
    (reduce conj nil col)))

; P06
(defn palindrome?
  "Find out whether a list is a palindrome"
  [col]
  (= col (reverse col)))

; P07
(defn flatten'
  "Flatten a nested list structure"
  [col]
  (if (empty? col)
    nil
    (let [[head & tail] col]
      (if (seq? head)
        (concat (flatten' head) (flatten' tail))
        (conj (flatten' tail) head)))))

; P08
(defn dedupe'
  "Eliminate consecutive duplicates of list elements"
  [col]
  (reverse'
    (reduce
      (fn [col item]
        (if (= (first col) item)
          col
          (conj col item)))
      nil col)))
