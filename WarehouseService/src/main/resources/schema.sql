CREATE TABLE IF NOT EXISTS DELIVERY(
    id INT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(100) NOT NULL,
    supplier VARCHAR(100) NOT NULL,
    quantity bigint NOT NULL,
    expected_date datetime NOT NULL,
    expected_warehouse VARCHAR(100) NOT NULL,
    is_received BOOL
);