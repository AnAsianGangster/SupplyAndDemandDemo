import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Market {
    int marketPriceIndividualChange = 1;
    int numerOfTransactionMadeToday = 0;
    ArrayList<Buyer> buyerList = new ArrayList<>();
    ArrayList<Seller> sellerList = new ArrayList<>();

    ArrayList<Buyer> availBuyerList = new ArrayList<>();
    ArrayList<Seller> availSellerList = new ArrayList<>();

    // todo: some market report method
    void makeBuyer(int highestBuyingPrice, int initialDesiredBuyingPrice){
        Buyer newBuyer = new Buyer(highestBuyingPrice, initialDesiredBuyingPrice);
        buyerList.add(newBuyer);
    }

    void makeSeller(int lowersetSellingPrice, int initialDesiredSellingPrice){
        Seller newSeller = new Seller(lowersetSellingPrice, initialDesiredSellingPrice);
        sellerList.add(newSeller);
    }

    void startMarket() {
        availBuyerList.clear();
        availSellerList.clear();
        for(int i = 0; i < buyerList.size(); i++){
            availBuyerList.add(buyerList.get(i));
        }
        for(int j = 0; j < sellerList.size(); j++){
            availSellerList.add(sellerList.get(j));
        }
    }

    boolean makeOneTransaction(){
        Random rand = new Random();
        int sellerIndex = rand.nextInt(availSellerList.size());
        int buyerIndex = rand.nextInt(availBuyerList.size());

        int sellerAskPrice = availSellerList.get(sellerIndex).desiredSellingPrice;
        int buyerAskPrice = availBuyerList.get(buyerIndex).desiredBuyingPrice;

        // successful transaction
        if(sellerAskPrice <= buyerAskPrice){
//            if(availSellerList.get(sellerIndex).desiredSellingPrice > availSellerList.get(sellerIndex).lowersetSellingPrice + marketPriceIndividualChange){
            availSellerList.get(sellerIndex).desiredSellingPrice += marketPriceIndividualChange;
//            }
//            if(availBuyerList.get(buyerIndex).desiredBuyingPrice < availBuyerList.get(buyerIndex).highestBuyingPrice - marketPriceIndividualChange){
            availBuyerList.get(buyerIndex).desiredBuyingPrice -= marketPriceIndividualChange;
//            }
            availSellerList.remove(sellerIndex);
            availBuyerList.remove(buyerIndex);
            numerOfTransactionMadeToday++;
            return true;
        } else {
//            availSellerList.get(sellerIndex).desiredSellingPrice -= marketPriceIndividualChange;
//            availBuyerList.get(buyerIndex).desiredBuyingPrice += marketPriceIndividualChange;
            return false;
        }
    }

    // check market in the main loop
    boolean checkMarketDone(){
        if(availSellerList.size() == 0 || availBuyerList.size() == 0){
            return true;
        }
        int lowestSellingPrice = availSellerList.get(0).desiredSellingPrice;
        int highestBuyingPrice = availBuyerList.get(availBuyerList.size() - 1).desiredBuyingPrice;

        if(lowestSellingPrice >= highestBuyingPrice){
            return true;
        } else {
            return false;
        }
    }

    // clean up at the end of the day
    void marketCleanUp(){
        for(int i = 0; i < availSellerList.size(); i++){
            if(availSellerList.get(i).desiredSellingPrice > availSellerList.get(i).lowersetSellingPrice + marketPriceIndividualChange){
            availSellerList.get(i).desiredSellingPrice -= marketPriceIndividualChange;
            }
            
        }
        for(int j = 0; j < availBuyerList.size(); j++){
            if(availBuyerList.get(j).desiredBuyingPrice < availBuyerList.get(j).highestBuyingPrice - marketPriceIndividualChange){
            availBuyerList.get(j).desiredBuyingPrice += marketPriceIndividualChange;
            }
        }
        Collections.sort(sellerList, new sellerPriceComparator());
        Collections.sort(buyerList, new buyerPriceComparator());
    }
}

class sellerPriceComparator implements Comparator<Seller> {
    @Override
    public int compare(Seller seller, Seller t1) {
        return seller.desiredSellingPrice - t1.desiredSellingPrice;
    }
}

class buyerPriceComparator implements Comparator<Buyer> {

    @Override
    public int compare(Buyer buyer, Buyer t1) {
        return buyer.desiredBuyingPrice - t1.desiredBuyingPrice;
    }
}

