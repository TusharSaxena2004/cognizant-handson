DECLARE
    -- Cursor to fetch loans due within the next 30 days
    CURSOR c_due_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    -- Enable console output
    DBMS_OUTPUT.ENABLE;

    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || r_loan.customer_name || 
            ', your loan (' || r_loan.loan_id || 
            ') is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD')
        );
    END LOOP;
END;
/