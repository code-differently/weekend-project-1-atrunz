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

        String fullReceiptCode = receiptCode + visitID;



        if (isValidCoupon){
            finalTotal = finalTotal - (finalTotal*discountVal/100);
        }
        System.out.println(item2.getName() + item2.getPrice());
        System.out.println(item3.getName() + item3.getPrice());

        System.out.println(finalTotal);

        System.out.println("Thank You For Shopping At Alex's Electronics");
        System.out.println("Your visit ID is: " + visitID);
        System.out.println("Your receipt code is: " + fullReceiptCode);
        System.out.println("Your first item is: " + item1.getName() + "\nThe price is: $" + item1.getPrice());
        System.out.println("Your second item is: " + item2.getName() + "\nThe price is: $" + item2.getPrice());
        System.out.println("Your third item is: " + item3.getName() + "\nThe price is: $" + item3.getPrice());
        System.out.println("Your subtotal is: $" + subTotal);
        if(isDiscount){
            System.out.println("You received a random discount! Congratulations!");
            System.out.println("Your discount is: " + discountRate + "%");
            subTotal = calculatePrice.extraValues(subTotal, true, 0, discountRate);
            System.out.println("Your new subtotal is: $" + subTotal);
            //System.out.println("You will receive: " + subTotal*(discountRate/100) + " off");

        }else{
            System.out.println("We have placed a small processing fee on your order of: " + "$" + fee);
            subTotal =  calculatePrice.extraValues(subTotal, false, fee, 0);
            System.out.println("Your new subtotal is: $" + subTotal);
        }
        if(isValidCoupon){
            System.out.println("Your coupon code has been accepted!");
            System.out.println("Your discount is: " + discountVal + "%");
            subTotal = calculatePrice.extraValues(subTotal, true, 0, discountVal);
            System.out.println("Your new subtotal is: $" + subTotal);
            //System.out.println("Your will receive: " + subTotal*(discountVal/100) + " off");
        }
        System.out.println("Your tax rate is: " + taxRate +"%");
        System.out.println("Your total charge is: $" + finalTotal);
        if(budget - finalTotal >= 0){
            System.out.println("You have $" + (budget-finalTotal) + " remaining in your budget");
        }else{
            System.out.println("You need $" + Math.abs(budget-finalTotal) + " more in your budget to complete this purchase");
        }
        //whether user can afford with their budget or if they are short


    }
}