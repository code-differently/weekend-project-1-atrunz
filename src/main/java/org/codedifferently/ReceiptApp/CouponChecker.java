package org.codedifferently.ReceiptApp;

public class CouponChecker {
    public boolean couponCheck(String[] acceptedCoupons, String providedCoupon){
        boolean isValidCoupon = false;
        for (int i=0; i< acceptedCoupons.length; i++){
            if(acceptedCoupons[i].equals(providedCoupon.toUpperCase())){
                isValidCoupon = true;
                //discountVal = discountVal * (i+1);
                return isValidCoupon;

            }
            //don't get a discount
        }
        return false;
    }

    public int discountRate(boolean isCoupon, String[] acceptedCoupons, String providedCoupon){
        int discountVal = 25;
        if (isCoupon){
            for (int i=0; i< acceptedCoupons.length; i++){
                if(acceptedCoupons[i].equals(providedCoupon.toUpperCase())){

                    discountVal = discountVal * (i+1);
                    return discountVal;
                }
                //don't get a discount
            }
        }
        return 0;
    }

    public double applyCoupon(boolean isValidCoupon, double subTotal, int discountVal){
        if (isValidCoupon){
            subTotal = subTotal - (subTotal*discountVal/100);
            return subTotal;
        }
        else{
            return subTotal;
        }
    }
}
