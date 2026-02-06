package org.codedifferently.ReceiptApp;

public class ConsolePrint {
    public void printResults(int visitID, String fullReceiptCode, StoreItem item1, StoreItem item2, StoreItem item3, double subTotal, double taxRate, boolean isDiscount, double discountRate, double fee, boolean isValidCoupon, String couponCode, int discountVal, double finalTotal, double budget){

        //instantiate object for price calculation methods
        PriceCalculations calculatePrice = new PriceCalculations();

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
        System.out.println("Final Total + Tax: $" + finalTotal);
        if(budget - finalTotal >= 0){
            System.out.println("You have $" + (budget-finalTotal) + " remaining in your budget");
        }else{
            System.out.println("You need $" + Math.abs(budget-finalTotal) + " more in your budget to complete this transaction");
        }
        //whether user can afford with their budget or if they are short

    }
}
