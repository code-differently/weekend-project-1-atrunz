package org.codedifferently.ReceiptApp;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //these are the accepted coupon codes
        String[] couponCodes = {"25OFF", "50OFF", "75OFF", "100OFF"};

        //get username
        System.out.println("Please enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        //get budget
        System.out.println("Please enter your budget: ");
        double budget = scanner.nextDouble();

        //get coupon code
        System.out.println("Please enter your coupon code: ");
        String couponCode = scanner.next();

        //instantiate objects so we can use class methods
        RandomGenerations randomItem = new RandomGenerations();
        PriceCalculations calculatePrice = new PriceCalculations();
        CouponChecker coupon = new CouponChecker();
        ConsolePrint output = new ConsolePrint();


        //generate random values for discount, fee and rates
        boolean isDiscount = randomItem.discount();
        double fee = randomItem.fee();
        double taxRate = randomItem.tax();
        double discountRate = randomItem.tax();

        //generate random item IDs
        int itemSelectionOne = randomItem.item();
        int itemSelectionTwo = randomItem.item();
        int itemSelectionThree = randomItem.item();

        //generate random items for receipt mapped from ID's
        StoreItem item1 = new StoreItem(itemSelectionOne, randomItem.prices());
        StoreItem item2 = new StoreItem(itemSelectionTwo, randomItem.prices());
        StoreItem item3 = new StoreItem(itemSelectionThree, randomItem.prices());

        //store item prices in an array to use with subtotal method
        double[] itemPrices = {item1.getPrice(), item2.getPrice(), item3.getPrice()};

        double subTotal = calculatePrice.subtotal(itemPrices);

        double subFinalTotal = calculatePrice.finalTotal(subTotal, isDiscount, fee, taxRate, discountRate);


        int visitID = randomItem.visitIDGen();

        String fullReceiptCode = randomItem.receiptCode(username, visitID);

        boolean isValidCoupon = coupon.couponCheck(couponCodes, couponCode);

        //should compute the discount value
        int discountVal = coupon.discountRate(isValidCoupon, couponCodes, couponCode);


        double finalTotal = coupon.applyCoupon(isValidCoupon, subFinalTotal, discountVal);

        //moved all print statements and print logic into a class called console print
        //method print results takes all of these values we found and prints formatted info to console
        output.printResults(visitID, fullReceiptCode, item1, item2,
                item3, subTotal, taxRate, isDiscount, discountRate,
                fee, isValidCoupon, couponCode, discountVal, finalTotal, budget);

    }
}