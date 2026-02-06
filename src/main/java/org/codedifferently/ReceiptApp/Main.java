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

        String username = scanner.nextLine();

        System.out.println("Please enter your budget: ");
        double budget = scanner.nextDouble();

        System.out.println("Please enter your coupon code: ");
        String couponCode = scanner.nextLine().toUpperCase();

        for (int i=0; i< couponCodes.length; i++){
            if(couponCodes[i].equals(couponCode)){
                //get a discount
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

        System.out.println(item1.getName() + item1.getPrice());
        System.out.println(item2.getName() + item2.getPrice());
        System.out.println(item3.getName() + item3.getPrice());
        System.out.println(0/100);

    }
}