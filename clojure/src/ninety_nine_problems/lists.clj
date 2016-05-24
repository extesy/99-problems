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
