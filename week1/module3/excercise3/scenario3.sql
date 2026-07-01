CREATE PROCEDURE TransferFunds
    @SourceAccountID INT,
    @DestinationAccountID INT,
    @TransferAmount DECIMAL(18, 2)
AS
BEGIN
    -- Verify the source account has enough funds
    IF (SELECT Balance FROM Accounts WHERE AccountID = @SourceAccountID) >= @TransferAmount
    BEGIN
        BEGIN TRANSACTION;

        -- Deduct from the source account
        UPDATE Accounts
        SET Balance = Balance - @TransferAmount
        WHERE AccountID = @SourceAccountID;

        -- Add to the destination account
        UPDATE Accounts
        SET Balance = Balance + @TransferAmount
        WHERE AccountID = @DestinationAccountID;

        COMMIT TRANSACTION;
    END
    ELSE
    BEGIN
        RAISERROR ('Insufficient balance for this transfer.', 16, 1);
    END
END;