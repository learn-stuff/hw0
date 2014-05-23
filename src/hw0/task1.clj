(ns hw0.task1)

(defn- all-pairs [sq] (for [i sq j sq] [i j]))

(defn- disj-min
  [[x y z]]
  (cond (and (< x y) (< x z)) (list y z)
        (and (< y x) (< y z)) (list x z)
        :else (list x y)))

(defn- safe+
  [& coll]
  (apply + (remove nil? coll)))


(defn sum
  "Takes an array of integers as an argument
  and returns the sum of its elements.
  For an empty array it should return zero."
  [arr]
  (reduce + arr))


(defn max2-sum
  "Takes an array of integers as an argument
  and returns the sum of its two largest elements.
  For an empty array it should return zero.
  For an array with just one element,
  it should return that element."
  [[x y & rest]]
  (if (nil? rest)
    (safe+ x y)
    (loop [max-values (list x y)
           [k & rest] rest]
      (if (nil? k)
        (apply + max-values)
        (recur (disj-min (conj max-values k)) rest)))))


(defn sum-to-n?
  "DIFFICULT
  Takes an array of integers
  and an additional integer, n, as arguments
  and returns true
  if any two elements in the array of integers sum to n.
  An empty array should sum to zero by definition."
  [arr n]
  (cond (= (count arr) 1) (= (first arr) n)
        (= (count arr) 0) (= n 0)
        :else
          (some (fn [[x y]] (= (+ x y) n))
                (all-pairs arr))))
