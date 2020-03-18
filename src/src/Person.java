public interface Person {
    boolean madeTransactionToday = false;
    void updatePrices(boolean madeTransaction, int transactionPrice);
    int reportTransactionPrice();
}
