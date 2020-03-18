public class Seller implements Person {
    // fixed after initialization
    int SellerID;
    int lowersetSellingPrice;

    // varies per day
    int desiredSellingPrice;
    int transactionPrice;
    boolean madeTransactionToday;
    boolean haveBroughtAnItem;

    public Seller(int sellerID, int lowersetSellingPrice) {
        SellerID = sellerID;
        this.lowersetSellingPrice = lowersetSellingPrice;
    }

    @Override
    public void updatePrices(boolean madeTransaction, int transactionPrice) {

    }

    @Override
    public int reportTransactionPrice() {
        return transactionPrice;
    }
}
