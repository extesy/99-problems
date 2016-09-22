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
    col
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

; Helper function for P09-P11
(defn combine [f col]
  (let [[result group]
        (reduce
          (fn [[result group] item] ; keep running values of result and current group
            (if (or
                  (empty? group)
                  (= (first group) item)) ; separate groups by element equality
              (list result (conj group item)) ; keep adding to the same group
              (list (conj result (f group)) (list item)))) ; append processed group to a result
          '([] nil) col)]
    (conj result (f group)))) ; process the last group

; P09
(defn pack
  "Pack consecutive duplicates of list elements into sublists"
  [col]
  (combine identity col))

; P10
(defn encode
  "Run-length encoding of a list"
  [col]
  (combine #(list (count' %1) (first %1))
           col))

; P11
(defn encode'
  "Modified run-length encoding"
  [col]
  (combine #(let [size (count' %1)
                  item (first %1)]
             (if (= size 1)
               item
               (list size item)))
           col))

; P12
(defn decode
  "Decode a run-length encoded list"
  [col]
  (flatten'
    (map #(if
           (sequential? %1)
           (repeat (first %1) (last %1))
           %1) col)))

; P13 - seems to be identical to P11 unless I misunderstand something

; P14
(defn duplicate
  "Duplicate the elements of a list"
  [col]
  (reverse'
    (reduce #(conj %1 %2 %2) '() col)))

; P15
(defn replicate'
  "Replicate the elements of a list a given number of times"
  [col n]
  (reduce #(concat %1 (repeat n %2)) '() col))

; P16
(defn drop-every
  "Drop every N'th element from a list"
  [col n]
  (flatten' (partition (dec n) n '() col)))
