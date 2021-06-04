**WSU-Inc.-Wholesale-Food-Distribution-team-7**

_Importent instruction before running:
-Run the loginUsers.java page_



**WSU Inc. Wholesale Food Distribution**


WSU Inc. is a wholesale food distribution company. It buys large volumes of products from different vendors (producers) and breaks them down into smaller quantities and sells them to retail customers such as restaurants, grocery stores, convenience stores, hospitals, and schools. WSU Inc. preserves their items in a warehouse and transports them from the warehouse to the customers as the items are ordered.

Login and Logout

- Let user, administrator, and owner login and perform specific tasks for each role

Customer Profiles

- Let new users create a new profile to login with, search for accounts, ... etc

Vendor Profiles

- Let new Vendors create a new profile to login with, search for accounts, ... etc

Item Profiles

- Owner/inventory manager can create/delete/search item profiles(detailed info about items), system generates item id, system restricts adding duplicate items systems restricts invalid input, system restricts users entering past date for expirations, system allows purchaser or owner to update item profiles, item not found error, user can see list of items.


Purchase Order

* Let purchaser users create purchasing orders for the vendors.
* Receive alerts when two items go out of stock. 
* The purchase order should contain a max of five items and a min on one item. 
* Allows the purchaser user to enter a need date and a quantity number. 
* The need date can not be older than the current date and the quantity has to be more than 0. 
* The system calculates the unit price and uses that to calculate the total price. 
* The vendor balance gets updated to the total price. 
* The purchaser user can see a list of purchases by each vendor. 

Customer Order

* Missing our fourth member Steven Mason *
* Hard-coded the necessary code. 

Customer Invoice

* Let accountant users create a customer invoice. 
* Account users get alerts when more than two customer orders are available. 
* Update the value of customer balance using the invoice information. 
* Can't create the same invoice twice. 

Other Functions

* Give an alert to the owner users when the seasonal discount starts. 
* Owner users can find items given a range of dates. 
* Owner users can search for a user that had a bill overdue for 30 days. 
* Purchaser users can search for expired items. 
* Owner users can see a list of customer orders for a given customer. 
* Account users can see a list of customer invoices for a given customer. 