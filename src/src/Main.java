import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // main loop simulate number of days
        Market theMarket = new Market();

        theMarket.makeBuyer(10, 44);
        theMarket.makeBuyer(20,46);
        theMarket.makeBuyer(30, 48);
        theMarket.makeBuyer(40, 50);
        theMarket.makeBuyer(50, 52);
        theMarket.makeBuyer(60, 54);

        theMarket.makeSeller(10, 54);
        theMarket.makeSeller(20, 56);
        theMarket.makeSeller(30, 58);
        theMarket.makeSeller(40, 60);

        ArrayList<Integer> sellerDesirePrice = new ArrayList<>();
        ArrayList<Integer> buyerDesirePrice = new ArrayList<>();
        // FIXME: seller
        for(int i = 0; i < theMarket.sellerList.size(); i++){
            sellerDesirePrice.add(theMarket.sellerList.get(i).desiredSellingPrice);
        }
        System.out.println("original sellerDesirePrice = " + sellerDesirePrice);
        // FIXME: buyer
        for(int i = 0; i < theMarket.buyerList.size(); i++){
            buyerDesirePrice.add(theMarket.buyerList.get(i).desiredBuyingPrice);
        }
        System.out.println("original buyerDesirePrice = " + buyerDesirePrice + "\n");


        ////////////find sums
        int supply = 0;
        int demand = 0;
        for(int i = 0; i < theMarket.sellerList.size(); i++) {
            supply += theMarket.sellerList.get(i).lowersetSellingPrice;
        }
        for(int j = 0; j < theMarket.buyerList.size(); j++){
            demand += theMarket.buyerList.get(j).highestBuyingPrice;
        }
        System.out.println("####total supply -->"+ supply + " ####total demand -->" + demand);

        theMarket.startMarket();

        for(int x = 1; x <= 15; x++) {
            // day one
            System.out.println("day " + x);
            while (!theMarket.checkMarketDone()) {
                theMarket.makeOneTransaction();
            }

            theMarket.marketCleanUp();

            System.out.println("theMarket.numberOfTransactionMadeToday = " + theMarket.numerOfTransactionMadeToday);
            ////////////////
            sellerDesirePrice.clear();
            for (int i = 0; i < theMarket.sellerList.size(); i++) {
                sellerDesirePrice.add(theMarket.sellerList.get(i).desiredSellingPrice);
            }
            System.out.println("sellerDesirePrice = " + sellerDesirePrice);
            ///////////////
            buyerDesirePrice.clear();
            for (int i = 0; i < theMarket.buyerList.size(); i++) {
                buyerDesirePrice.add(theMarket.buyerList.get(i).desiredBuyingPrice);
            }
            System.out.println("buyerDesirePrice = " + buyerDesirePrice + "\n");
        }

        int steadySupply = 0;
        int steadyDemand = 0;
        for(int i = 0; i < theMarket.sellerList.size(); i++) {
            steadySupply += theMarket.sellerList.get(i).desiredSellingPrice;
        }
        for(int j = 0; j < theMarket.buyerList.size(); j++){
            steadyDemand += theMarket.buyerList.get(j).desiredBuyingPrice;
        }
        System.out.println("####total steady supply -->"+ steadySupply + " ####total steady demand -->" + steadyDemand);
    }
}
