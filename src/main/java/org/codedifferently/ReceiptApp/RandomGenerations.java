package org.codedifferently.ReceiptApp;

import java.util.Random;

public class RandomGenerations {

    //generate random ID
    public int visitIDGen() {
        Random rand = new Random();
        int ID = rand.nextInt(10001);
        return ID;
    }

    //generate random price
    public double prices() {
        Random rand = new Random();
        double price = rand.nextDouble(1001) + 700;
        return price;
    }

    //generate random item index
    public int item() {
        Random rand = new Random();
        int itemIndex = rand.nextInt(11);
        return itemIndex;
    }

    //generate random tax value
    public double tax() {
        Random rand = new Random();
        double taxRate = rand.nextDouble(31);
        return taxRate;
    }

    //generate random fee
    public double fee() {
        Random rand = new Random();
        double feeRand = rand.nextDouble(51);
        return feeRand;
    }

    //generate random discount
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

    //merge random visitID code into receiptCode
    public String receiptCode(String username, int visitID){

        String receiptCode;
        if (username.length() < 5){
            receiptCode = username.toUpperCase();
        }else{
            receiptCode = username.substring(0, 4).toUpperCase();
        }

        String fullReceiptCode = receiptCode + "-" + visitID;

        return fullReceiptCode;
    }

}