class SqlBuilder {

    /* Basic Select with Conditions
    SELECT id, name, email
    FROM users
    WHERE age > 25 AND status = 'active'
    ORDER BY created_at DESC
    LIMIT 10 OFFSET 5;
     */

    /* inner join
    SELECT u.id, u.name, o.total_amount
    FROM users u
    INNER JOIN orders o ON u.id = o.user_id
    WHERE o.status = 'completed';
     */

    /* left join
    SELECT u.id, u.name, o.total_amount
    FROM users u
    LEFT JOIN orders o ON u.id = o.user_id
    WHERE o.id IS NULL;
     */

    /* right join
    SELECT u.id, u.name, o.total_amount
    FROM users u
    RIGHT JOIN orders o ON u.id = o.user_id;
     */

    /* subquery in select
    SELECT id, name, (SELECT COUNT(*) FROM orders WHERE user_id = users.id) as order_count
    FROM users;
     */

    /* subquery in where
    SELECT id, name
    FROM users
    WHERE id IN (SELECT user_id FROM orders WHERE total_amount > 100);
     */

    /* aggregate functions
    SELECT department, COUNT(*) as employee_count, AVG(salary) as avg_salary
    FROM employees
    GROUP BY department
    HAVING AVG(salary) > 50000;
     */

    /* insert
    INSERT INTO users (name, email, age)
   VALUES ('John Doe', 'john@example.com', 30),
   ('Jane Doe', 'jane@example.com', 25);
     */

    /* update
    UPDATE users
SET status = 'inactive'
FROM orders
WHERE users.id = orders.user_id AND orders.status = 'cancelled';
     */

    /* delete with subquery
    DELETE FROM users
WHERE id IN (SELECT user_id FROM orders WHERE status = 'returned');
     */

    /* CTE
    WITH RecentOrders AS (
    SELECT user_id, MAX(order_date) as last_order_date
    FROM orders
    GROUP BY user_id
    )
    SELECT u.id, u.name, r.last_order_date
    FROM users u
    JOIN RecentOrders r ON u.id = r.user_id
    WHERE r.last_order_date > '2025-01-01';
     */

    /* union
    SELECT id, name FROM users WHERE status = 'active'
    UNION
    SELECT id, name FROM admins WHERE status = 'active';
   */


}