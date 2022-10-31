CREATE TABLE IF NOT EXISTS sales (
    id SERIAL PRIMARY KEY NOT NULL,
    final_price DECIMAL NOT NULL,
    price_modifier DECIMAL NOT NULL,
    points INT NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    datetime TIMESTAMP NOT NULL
);