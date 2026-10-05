CREATE TABLE IF NOT EXISTS product (
    product_id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(200),
    product_desc VARCHAR(550),
    product_price FLOAT,
    product_stock INTEGER
);

