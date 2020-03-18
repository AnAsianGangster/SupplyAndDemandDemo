public class Seller implements Person {
    // fixed after initialization
    int lowersetSellingPrice;

    // varies per day
    int desiredSellingPrice;
    int transactionPrice;

    public Seller(int lowersetSellingPrice, int initialDesiredSellingPrice) {
        this.lowersetSellingPrice = lowersetSellingPrice;
        this.desiredSellingPrice = initialDesiredSellingPrice;
    }


    @Override
    public int reportTransactionPrice() {
        return transactionPrice;
    }
}
