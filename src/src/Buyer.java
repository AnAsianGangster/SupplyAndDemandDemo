public class Buyer implements Person {
    // fixed after initialization
    int BuyerID;
    int highestBuyingPrice;

    // varies per day
    int desiredBuyingPrice;
    int transactionPrice;
    boolean madeTransactionToday;
    boolean haveAnItemToSell;

    public Buyer(int buyerID, int highestBuyingPrice) {
        BuyerID = buyerID;
        this.highestBuyingPrice = highestBuyingPrice;
    }

    @Override
    public void updatePrices(boolean madeTransaction, int transactionPrice) {

    }

    @Override
    public int reportTransactionPrice() {
        return transactionPrice;
    }
}
