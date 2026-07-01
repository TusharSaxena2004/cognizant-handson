DECLARE
    -- Cursor to fetch loans for customers over 60
    CURSOR c_elderly_loans IS
        SELECT l.loan_id
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
BEGIN
    FOR r_loan IN c_elderly_loans LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1.0
        WHERE loan_id = r_loan.loan_id;
    END LOOP;
    
    COMMIT;
END;
/