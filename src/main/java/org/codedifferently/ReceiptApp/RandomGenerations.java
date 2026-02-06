package org.codedifferently.ReceiptApp;

import java.util.Random;

public class RandomGenerations {
    public int visitIDGen() {
        Random rand = new Random();
        int ID = rand.nextInt(10001);
        return ID;
    }

    public double prices() {
        Random rand = new Random();
        double price = rand.nextDouble(1001) + 700;
        return price;
    }

    public int item() {
        Random rand = new Random();
        int itemIndex = rand.nextInt(11);
        return itemIndex;
    }

    public double tax() {
        Random rand = new Random();
        double taxRate = rand.nextDouble(31);
        return taxRate;
    }

    public double fee() {
        Random rand = new Random();
        double feeRand = rand.nextDouble(51);
        return feeRand;
    }

    public boolean discount() {
        Random rand = new Random();
        //generate a pseudo ID
        int idCheck = visitIDGen();
        int discountBottomThresh = rand.nextInt(5000);
        int discountTopThreshold = rand.nextInt(5001) + 5000;

        if (idCheck >= discountBottomThresh && idCheck <= discountTopThreshold) {
            return true;
        } else {
            return false;
        }

    }
}