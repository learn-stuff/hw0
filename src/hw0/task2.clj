(ns hw0.task2)

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
