CREATE TABLE purchase (
    id SERIAL,
    customer_id INT NOT NULL,
    nfe VARCHAR(255),
    price DECIMAL(15,2) NOT NULL,
    create_at DATE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE purchase_book (
    purchase_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY(purchase_id, book_id),
    FOREIGN KEY (purchase_id) REFERENCES purchase (id),
    FOREIGN KEY (book_id) REFERENCES book (id)
);