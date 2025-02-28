CREATE TABLE category (
                          id BIGINT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE product (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         price FLOAT NOT NULL,
                         quantity INT NOT NULL,
                         category_id BIGINT NOT NULL,
                         CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);
