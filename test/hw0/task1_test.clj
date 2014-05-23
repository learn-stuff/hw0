(ns hw0.task1-test
  (:use clojure.test
        hw0.task1))


(deftest sum-test
  (testing "Empty array sums to zero"
    (is (= 0 (sum '()))))

  (testing "One element array sums to it"
    (is (= 10 (sum '(10)))))

  (testing "Sum general case"
    (is (= 60 (sum '(10, 20, 30))))))


(deftest max2-sum-test
  (testing "Empty array results in zero"
    (is (= 0 (max2-sum '()))))

  (testing "One element array results in element"
    (is (= 10 (max2-sum '(10)))))

  (testing "Max 2 sum general case"
    (is (= 80 (max2-sum '(50, 10, 20, 30))))))


(deftest sum-to-n-test
  (testing "Empty array only sums to zero"
    (is (sum-to-n? '() 0))
    (not (sum-to-n? '() 10)))

  (testing "One element array only sums to it"
    (is (sum-to-n? '(10) 10))
    (not (sum-to-n? '(10) 20)))

  (testing "Sum to n general case"
    (is (sum-to-n? '(50 -5 10 20 30) 40))
    (is (sum-to-n? '(50 -5 10 20 30) 25))
    (not (sum-to-n? '(50 -5 10 20 30) 100))))
