(ns hw0.task2)

(defn- binary-numeric? [s]
  (if-let [s (seq s)]
    (let [s (if (= (first s) \-) (next s) s)
          s (drop-while #(or (= % \1) (= % \0)) s)]
      (empty? s))))


(defn hello
  "Takes a string representing a name
  and returns the string \"Hello, \"
  concatenated with the name."
  [name]
  (str "Hello, " name))


(defn starts-with-vowel?
  "Takes a string
  and returns true if it starts with a vowel
  and false otherwise.
  (For our purposes, a vowel is any of the A, E, I, O, U)
  NOTE: be sure it works for both upper and lower case and for nonletters!"
  [s]
  (let [vowels #{\a \e \i \o \u}
        s (clojure.string/lower-case s)]
    (contains? vowels (first s))))


(defn binary-multiple-of-4?
  "Takes a string
  and returns true if the string represents a binary number
  that is a multiple of 4.
  NOTE: be sure it returns false if the string is not a valid binary number!"
  [s]
  (and
    (binary-numeric? s)
    (= 0 (mod (Integer/parseInt s 2) 4))))
