(ns hw0.task3)

(defprotocol BookInStockSetters
  (set-field [book field value])
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
  (set-field [book field value]
    (let [new-book (assoc book field value)]
      (validate new-book)
      new-book))
  (set-isbn [book new-isbn] (set-field book :isbn new-isbn))
  (set-price [book new-price] (set-field book :price new-price)))

(defn make-book [isbn price]
  (let [book (->BookInStock isbn price)]
    (validate book)
    book))
