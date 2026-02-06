package org.codedifferently.ReceiptApp;

public class PriceCalculations {
    public double subtotal(double[] prices){
        double subtotal = 0.0;
        for (int i=0; i<prices.length; i++){
            subtotal = subtotal + prices[i];
        }
        return subtotal;
    }
    public double tax(double billPrice, double taxPercent){
        return billPrice*(taxPercent/100);
    }
    public double extraValues(double subTotal, boolean discount, double fee, double discountPercent){

        if (discount){
            return subTotal - (subTotal* discountPercent/100) ;
        }else{
            return subTotal + fee;
        }

    }
    public double finalTotal(double subtotal, boolean discount, double fee, double taxPercent, double discountPercent){
        //round
        double subtotalPostFee = extraValues(subtotal, discount, fee, discountPercent);

        double taxValue = tax(subtotalPostFee, taxPercent);

        //multiply value of math.round by 100.0, then divide by 100.0 to get rounded value at 2 decimals
        return Math.round((subtotalPostFee + taxValue) * 100.0) / 100.0;
    }

}
