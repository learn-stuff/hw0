(ns hw0.task3)

(defprotocol BookInStockSetters
  (set-field [book field value])
  (set-isbn  [book new-isbn])
  (set-price [book new-price]))

(defprotocol ValidateBook
  (validate [book]))

(defprotocol PriceAsString
  (price->string [book]))


(defrecord BookInStock [isbn price]
  ; Represents a book with
  ; - an isbn number, `isbn`,
  ; - and price of the book as a floating-point number, `price`,
  ; as attributes.

  ; The constructor should accept
  ; - the ISBN number (a string) as the first argument
  ; - and price as second argument,
  ; and should raise ArgumentError (one of Ruby's built-in exception types)
  ; if the ISBN number is the empty string
  ; or if the price is less than or equal to zero.

  ; Include the proper setters for these attributes.
  ; Include a method `price->string`
  ; that returns the price of the book
  ; with a leading dollar sign and trailing zeros,
  ; that is, a price of 20 should display as '$20.00'
  ; and a price of 33.8 should display as '$33.80'."

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
  (set-price [book new-price] (set-field book :price new-price))

  PriceAsString
  (price->string [book]
    (format "$%3.2f" (float (:price book)))))


(defn make-book [isbn price]
  (let [book (->BookInStock isbn price)]
    (validate book)
    book))
