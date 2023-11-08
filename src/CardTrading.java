import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class CardTrading {

    public static void main(String[] args) {
        List<Price> derivedPriceList = new ArrayList<Price>();
        Scanner sc = new Scanner(System.in);
        int profit = 0;

        //initialise no. of cards, no. card types,Combo
        //e.g. Sample Input 1:  4 cards, 3 card type lines, 2 combo needed
        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();

        //initialise array size t+1.
        //array reflect number of each type of card
        //e.g. Sample Input 1, [0,2,1,1] from 1 3 2 1
        int[] tArray = new int[t+1];

        for (int i = 0; i < n; i++) {
            int newCardType = sc.nextInt();
            tArray[newCardType] += 1;
        }

        //create arraylist for DerivedPrice
        //Sort: see Comparable
        //e.g. [3 40 30, 2 50 20, 1 0 100]
        //Case 1: 2 of same card type => buy $0, sell 2 only
        //Case 2: 1 of same card type => buy 1 max, sell 1 max
        //Case 3: 0 of same card type => buy 2 max, sell $0
        for (int i = 1; i < t+1; i++) {
            int origBuyPrice = sc.nextInt();
            int origSellPrice = sc.nextInt();
            int thisBuy = 0;
            int thisSell = 0;
            int worth = 0;

            if (tArray[i] == 0) {
                thisBuy = 2 * origBuyPrice;
                thisSell = 0;
                worth = -thisBuy;
            }
            else if (tArray[i] == 1) {
                thisBuy = origBuyPrice;
                thisSell = origSellPrice;
                worth = thisSell - thisBuy;
            }
            else if (tArray[i] == 2) {
                thisBuy = 0;
                thisSell = 2 * origSellPrice;
                worth = thisSell;
            }
            Price newPrice = new Price(i, Math.abs(worth), thisSell, thisBuy);
            derivedPriceList.add(newPrice);

        }
        Collections.sort(derivedPriceList);
        //System.out.println(derivedPriceList);


        //derived pricing accounted for each card type.
        //For number of combos (0->k), arrange buying up to k. Change situation.
        //For number of card types - combos (k -> t-k), arrange selling up to t.
        for (int i = 0; i < k; i++) {
            int loss = derivedPriceList.get(i).completionPrice;
            System.out.println(loss);
            profit -= loss;
        }

        for (int i = k; i < t; i++) {
            int gain = derivedPriceList.get(i).sellPrice;
            profit += gain;
        }

        System.out.println(profit);


    }


    public static class Price implements Comparable<Price> {
        public final int cardType;
        public final int netWorth;
        public final int sellPrice;
        public final int completionPrice;

        Price(int cardType, int netWorth, int sellPrice, int completionPrice) {
            this.cardType = cardType;
            this.netWorth = netWorth;
            this.sellPrice = sellPrice;
            this.completionPrice = completionPrice;
        }

        @Override
        //compare sort by total buy+sell, then by lower buy price first
        //first value is cheaper or has lower buy price.
        public int compareTo(Price other) {
            return other.netWorth - this.netWorth;
        }

    /*@Override
    public String toString() {
        return this.cardType + " " + this.buyDerivedWorth + " " + this.sellDerivedWorth;
    }*/

    }
}
