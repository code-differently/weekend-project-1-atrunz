package org.codedifferently.ReceiptApp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");


        //System.out.println("Please enter your username: ");
        //Scanner scanner = new Scanner(System.in);

        //String username = scanner.nextLine();

        //System.out.println("Please enter your budget: ");
        //double budget = scanner.nextDouble();

        // System.out.println("Please enter your coupon code: ");
        // String couponCode = scanner.nextLine();


        RandomGenerations randomItem = new RandomGenerations();

        //generate random item IDs
        int itemSelectionOne = randomItem.item();
        int itemSelectionTwo = randomItem.item();
        int itemSelectionThree = randomItem.item();

        //generate random items for receipt
        StoreItem item1 = new StoreItem(itemSelectionOne, randomItem.prices());
        StoreItem item2 = new StoreItem(itemSelectionTwo, randomItem.prices());
        StoreItem item3 = new StoreItem(itemSelectionThree, randomItem.prices());

        System.out.println(item1.getName() + item1.getPrice());
        System.out.println(item2.getName() + item2.getPrice());
        System.out.println(item3.getName() + item3.getPrice());
        System.out.println(0/100);

    }
}