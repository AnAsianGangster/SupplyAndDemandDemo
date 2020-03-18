public class Buyer implements Person {
    // fixed after initialization
    int highestBuyingPrice;

    // varies per day
    int desiredBuyingPrice;
    int transactionPrice;
    boolean hasAnItemToBuy;

    public Buyer(int highestBuyingPrice, int initialDesiredBuyingPrice) {
        this.highestBuyingPrice = highestBuyingPrice;
        this.desiredBuyingPrice = initialDesiredBuyingPrice;
    }

    @Override
    public int reportTransactionPrice() {
        return transactionPrice;
    }
}
