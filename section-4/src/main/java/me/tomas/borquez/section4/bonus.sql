SELECT
    c.id AS customer_id,
    c.name AS customer_name,
    c.email AS customer_email,
    COUNT(o.id) AS total_orders,
    SUM(o.totalAmount) AS total_amount_spent
FROM
    Customer c
        LEFT JOIN
    Order o ON c.id = o.customer_id
WHERE
    c.id = :customerId
GROUP BY
    c.id, c.name, c.email