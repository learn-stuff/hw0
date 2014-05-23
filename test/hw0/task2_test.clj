(ns hw0.task2-test
  (:use clojure.test
        hw0.task2))


(deftest hello-test
  (testing "Hello works"
    (is (= "Hello, Batman" (hello "Batman")))
    (is (= "Hello, Robin" (hello "Robin")))))


(deftest starts-with-vowel-test
  (testing "Starts with vowel works"
    (not (starts-with-vowel? "Batman"))
    (not (starts-with-vowel? "batman"))
    (is (starts-with-vowel? "Ivy"))
    (is (starts-with-vowel? "ivy")))

  (testing "Starts with vowel works with no letters"
    (not (starts-with-vowel? ""))
    (not (starts-with-vowel? "123aaa"))
    (not (starts-with-vowel? "!aaa"))))


(deftest binary-multiple-of-4
  (testing "Test binary multiple of 4 for empty string"
    (not (binary-multiple-of-4? "")))

  (testing "Test binary multiple of 4 for non alpha string"
    (not (binary-multiple-of-4? "Batman")))

  (testing "Test binary multiple of 4 for non binaries"
    (not (binary-multiple-of-4? "11112")))

  (testing "Test binary multiple of 4 for binaries non multiple of 4"
    (not (binary-multiple-of-4? "11111")))

  (testing "Test binary multiple of 4 for binaries non multiple of 4"
    (is (binary-multiple-of-4? "10000"))))
