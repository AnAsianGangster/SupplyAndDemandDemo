import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // main loop simulate number of days
        Market theMarket = new Market();

        // theMarket.makeBuyer(55, 45);
        // theMarket.makeBuyer(65, 55);
        theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);

        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60, 40);
        // theMarket.makeBuyer(60,46);
        // theMarket.makeBuyer(60, 48);
        // theMarket.makeBuyer(60, 50);
        // theMarket.makeBuyer(60, 60);
        // theMarket.makeBuyer(60, 60);
        // theMarket.makeBuyer(60,46);
        // theMarket.makeBuyer(60, 48);
        // theMarket.makeBuyer(60, 50);
        // theMarket.makeBuyer(60, 60);
        // theMarket.makeBuyer(60, 60);
        // theMarket.makeBuyer(60,46);
        // theMarket.makeBuyer(60, 48);
        // theMarket.makeBuyer(60, 50);
        // theMarket.makeBuyer(60, 60);
        // theMarket.makeBuyer(60, 60);

        // theMarket.makeSeller(45, 55);
        // theMarket.makeSeller(55, 65);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        theMarket.makeSeller(40, 60);
        // theMarket.makeSeller(20, 30);

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
        System.out.println("----average supply -->" + supply / theMarket.sellerList.size() + "---average demand -->" + demand / theMarket.buyerList.size());

        theMarket.startMarket();

        for(int x = 1; x <= 22; x++) {
            // one day
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
        System.out.println("####total steady supply -->" + steadySupply + " ####total steady demand -->" + steadyDemand);
        System.out.println("----average steady supply -->" + steadySupply / theMarket.sellerList.size() + "---average steady demand -->" + steadyDemand / theMarket.buyerList.size());
    }
}
