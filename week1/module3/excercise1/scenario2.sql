DECLARE
    -- Cursor to fetch high-balance customers
    CURSOR c_vip_customers IS
        SELECT customer_id 
        FROM customers 
        WHERE balance > 10000;
BEGIN
    FOR r_cust IN c_vip_customers LOOP
        UPDATE customers
        SET is_vip = 'TRUE' 
        WHERE customer_id = r_cust.customer_id;
    END LOOP;
    
    COMMIT;
END;
/