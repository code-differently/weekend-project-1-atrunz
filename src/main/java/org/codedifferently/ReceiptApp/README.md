**Java Random Receipt Printer**

**How It Works:**

The programs uses sout and scanner to prompt the user for inputs 
and collect those inputs. They are stored in variables to access later.

Objects are instantiated in main for each of the classes created,
the purpose of this is so that we can use the methods in each class in main.

isDiscount is assigned a random bool using the discount method from the RandomGenerations class. 
In this class, the Random class from java is leveraged to generate random values (bools, ints, etc.). 

Methods are called from this class to generate values for fee, taxRate and discountRate.

Similarly, a method is called from this class to generate a random int between 1-10

This random int is used to generate items to be used on the receipt. A "StoreItem" class was 
created, where each StoreItem has a name, a price and an itemID.

ItemID is tied to the name of the item, as inside the class a switch statement assigns item name based on ID.
The rand int is passed in for itemID in order to make this assignment and generate random items.

Additionally, a random price generated from our RandomGenerations class is passed to these storeitem objects.

The new item prices are stored in an array of doubles, that allows us to
call the subtotal method from PriceCalculations, which uses a for loop to sum the contents of the array.

Next the finalTotal() method is used, passing in the subtotal, and values for taxes, fees, discounts, etc.
to compute the new total after considering our randomly generated values. 

A visit ID is randomly generated similarly.

A full receipt code is returned by concatenating up to the first 4 letters of the user inputted user name
with the randomly generated visit ID. 

One more discount check is completed. The method isValidCoupon checks if the coupon code
provided exists in an array of pre-defined coupon codes.

If it does, the value of that discount is computed by a pre-determined formula based on the codes position in the array.

After considering this, the coupon is applied to update the final total. If the coupon doesn't exist, the total will not update.

Lastly, a method is called to handle all of the printing to console. All the variables just described are passed in as parameters so they can be referenced where needed. 


**Sample output:**

Please enter your username:

Coolloosh

Please enter your budget:

5000

Please enter your coupon code:

25off

--------- Welcome to Alex's Electronics ---------

Visit ID: 5120

Receipt Code: COOL-5120

iPhone: \$875.29

Macbook: \$1125.86

Meta Glasses: \$1120.44

Subtotal: \$3121.59

Sales Tax: 14.39%

--------- A small processing fee was added to your order---------

Processing Fee: \$43.38

New Subtotal: \$3164.97

---------- Coupon Code \*25OFF* Accepted ----------

Discount: 25.0%

New Subtotal: \$2373.73

Final Total + Tax: \$2715.32

You have $2284.68 remaining in your budget


**Java Concepts Used:**

* Classes/Objects/Methods

* Conditionals/Switch/If-else

* Math/String/Random Methods

* Scanner and taking user input

* Data handling + processing 

* Class and method design/software design principles





