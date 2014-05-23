(ns hw0.task3)

(defprotocol BookInStockSetters
  (set-isbn  [book new-isbn])
  (set-price [book new-price]))

(defprotocol ValidateBook
  (validate [book]))

(defrecord BookInStock [isbn price]
  ValidateBook
  (validate [{isbn :isbn price :price}]
    (cond (empty? isbn) (throw (IllegalArgumentException. "isbn should be a string"))
        (nil? price) (throw (IllegalArgumentException. "price should not be empty"))
        (<= price 0) (throw (IllegalArgumentException. "price should be greater than 0"))))

  BookInStockSetters
  (set-isbn [book new-isbn]
    (let [new-book (assoc book :isbn new-isbn)]
      (validate new-book)
      new-book))
  (set-price [book new-price]
    (let [new-book (assoc book :price new-price)]
      (validate new-book)
      new-book)))

(defn make-book [isbn price]
  (let [book (->BookInStock isbn price)]
    (validate book)
    book))
