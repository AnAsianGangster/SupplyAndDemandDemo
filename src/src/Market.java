import java.util.ArrayList;

public class Market {
    int numerOfTransactionMadeToday;
    ArrayList<Buyer> buyerList;
    ArrayList<Seller> sellerList;

    // todo: some market report method

    void makeBuyer(int BuyerID, int highestBuyingPrice){
        Buyer newBuyer = new Buyer(BuyerID, highestBuyingPrice);
        buyerList.add(newBuyer);
    }

    void makeSeller(int SellerID, int lowersetSellingPrice){
        Seller newSeller = new Seller(SellerID, lowersetSellingPrice);

    }


}
