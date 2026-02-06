package org.codedifferently.ReceiptApp;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        String[] couponCodes = {"25OFF", "50OFF", "75OFF", "100OFF"};
        System.out.println("Please enter your username: ");
        Scanner scanner = new Scanner(System.in);

        String username = scanner.next();

        System.out.println("Please enter your budget: ");
        double budget = scanner.nextDouble();

        System.out.println("Please enter your coupon code: ");
        String couponCode = scanner.next();

        boolean isValidCoupon = false;
        int discountVal = 25;
        for (int i=0; i< couponCodes.length; i++){
            if(couponCodes[i].equals(couponCode.toUpperCase())){
                isValidCoupon = true;
                discountVal = discountVal * (i+1);
                break;
            }
            //don't get a discount
        }


        RandomGenerations randomItem = new RandomGenerations();
        PriceCalculations calculatePrice = new PriceCalculations();

        //generate random item IDs
        int itemSelectionOne = randomItem.item();
        int itemSelectionTwo = randomItem.item();
        int itemSelectionThree = randomItem.item();

        boolean isDiscount = randomItem.discount();
        double fee = randomItem.fee();
        double taxRate = randomItem.tax();
        double discountRate = randomItem.tax();

        //generate random items for receipt
        StoreItem item1 = new StoreItem(itemSelectionOne, randomItem.prices());
        StoreItem item2 = new StoreItem(itemSelectionTwo, randomItem.prices());
        StoreItem item3 = new StoreItem(itemSelectionThree, randomItem.prices());

        double[] itemPrices = {item1.getPrice(), item2.getPrice(), item3.getPrice()};

        double subTotal = calculatePrice.subtotal(itemPrices);

        double finalTotal = calculatePrice.finalTotal(subTotal, isDiscount, fee, taxRate, discountRate);

        String receiptCode;
        if (username.length() < 5){
            receiptCode = username.toUpperCase();
        }else{
            receiptCode = username.substring(0, 4).toUpperCase();
        }

        int visitID = randomItem.visitIDGen();

        String fullReceiptCode = receiptCode + "-" + visitID;



        if (isValidCoupon){
            finalTotal = finalTotal - (finalTotal*discountVal/100);
        }


        System.out.println("--------- Welcome to Alex's Electronics ----------");
        System.out.println("Visit ID: " + visitID);
        System.out.println("Receipt Code: " + fullReceiptCode);
        //System.out.println(item1.getName() + ": $" + item1.getPrice());
        System.out.println(item1.getName() + ": $" + Math.round(item1.getPrice() * 100.0) / 100.0);
       // System.out.println(item2.getName() + ": $" + item2.getPrice());
        System.out.println(item2.getName() + ": $" + Math.round(item2.getPrice() * 100.0) / 100.0);
        //System.out.println(item3.getName() + ": $" + item3.getPrice());
        System.out.println(item3.getName() + ": $" + Math.round(item3.getPrice() * 100.0) / 100.0);
        //System.out.println("Subtotal: $" + subTotal);
        System.out.println("Subtotal: $" + Math.round(subTotal * 100.0) / 100.0);
        //System.out.println("Sales Tax: " + taxRate +"%");
        System.out.println("Sales Tax: " + Math.round(taxRate * 100.0) / 100.0 + "%");


        if(isDiscount){
            System.out.println("--------- You received a lucky discount! ---------");
            //System.out.println("Lucky Discount: " + discountRate + "%");
            System.out.println("Lucky Discount: " + (Math.round(discountRate * 100.0)/100.0) + "%");

            subTotal = calculatePrice.extraValues(subTotal, true, 0, discountRate);
            //System.out.println("New Subtotal: $" + subTotal);
            System.out.println("New Subtotal: $" + (Math.round(subTotal*100.0)/100.0));

            //System.out.println("You will receive: " + subTotal*(discountRate/100) + " off");

        }else{
            System.out.println("--------- A small processing fee was added to your order---------");
            //System.out.println("Processing Fee: " + "$" + fee);
            System.out.println("Processing Fee: " + "$" + (Math.round(fee * 100.0)/100.0));

            subTotal =  calculatePrice.extraValues(subTotal, false, fee, 0);
            //System.out.println("New Subtotal: $" + subTotal);
            System.out.println("New Subtotal: $" + (Math.round(subTotal*100.0)/100.0));

        }
        if(isValidCoupon){
            System.out.println("---------- Coupon Code *" + couponCode.toUpperCase() + "* Accepted ----------");
            //System.out.println("Discount: " + discountVal + "%");
            System.out.println("Discount: " + (Math.round(discountVal * 100.0)/100.0) + "%");

            subTotal = calculatePrice.extraValues(subTotal, true, 0, discountVal);
            //System.out.println("New Subtotal: $" + subTotal);
            System.out.println("New Subtotal: $" + (Math.round(subTotal*100.0)/100.0));

            //System.out.println("Your will receive: " + subTotal*(discountVal/100) + " off");
        }
        System.out.println("Final Total: $" + finalTotal);
        if(budget - finalTotal >= 0){
            System.out.println("You have $" + (budget-finalTotal) + " remaining in your budget");
        }else{
            System.out.println("You need $" + Math.abs(budget-finalTotal) + " more in your budget to complete this transaction");
        }
        //whether user can afford with their budget or if they are short


    }
}