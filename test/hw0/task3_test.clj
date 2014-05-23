(ns hw0.task3-test
  (:use clojure.test
        hw0.task3))

(deftest book-in-stock-constructor-test
  (testing "Make book"
    (let [book (make-book "2-266-11156-6" 149.95)]
      (is (= "2-266-11156-6" (:isbn book)))
      (is (= 149.95 (:price book)))))

  (testing "Invalid isbn"
    (is (thrown? IllegalArgumentException (make-book nil 149.95)))
    (is (thrown? IllegalArgumentException (make-book "" 149.95))))

  (testing "Invalid price"
    (is (thrown? IllegalArgumentException (make-book "2-266-11156-6" nil)))
    (is (thrown? IllegalArgumentException (make-book "2-266-11156-6" 0.0)))
    (is (thrown? IllegalArgumentException (make-book "2-266-11156-6" -149.95)))))


(deftest book-in-stock-setters-test
  (let [book (make-book "2-266-11156-6" 149.95)]
    (testing "ISBN setter"
      (let [book (set-isbn book "6-65111-662-2")]
        (is (= "6-65111-662-2" (:isbn book)))))

    (testing "Price setter"
      (let [book (set-price book 150.00)]
        (is (= 150.00 (:price book)))))

    (testing "Set invalid data"
      (is (thrown? IllegalArgumentException (set-price book nil))))))
