# D287 – JAVA FRAMEWORKS P.A.

<strong>
The following notes describe where in the code to find the changes I made for each of part C to J. Each note includes the prompt, file name, line number, and change.
</strong>

## Notes:  
C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.  
<i>
Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.
</i>

<pre>
- demo.css
    (ALL lines) create CSS file to customize mainscreen.html web page
- mainscreen.html
    (Line 15) add: &lt;link rel="stylesheet" href="/css/demo.css"&gt;
    (Line 17) change to: &lt;title&gt;Eli's Guitar Shop&lt;/title&gt;
    (Line 22) change to: &lt;h1&gt;Eli's Guitar Shop&lt;/h1&gt;
</pre>
---
D. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.  

<pre>
- about.html
    (ALL lines) create HTML file for the "About" page
- AboutController.java
    (ALL lines) create java file for handling navigation between the "About" page and the main screen
- mainscreen.html
    (Lines 22 - 35) add a navbar to include navigation to and from "About" page and the main screen
    &lt;nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;"&gt;
        &lt;div class="container-fluid"&gt;
            &lt;div class="collapse navbar-collapse" id="navbarNav"&gt;
                &lt;ul class="navbar-nav"&gt;
                    &lt;li class="nav-item"&gt;
                        &lt;a class="nav-link active" aria-current="page" th:href="@{mainscreen}"&gt;Home&lt;/a&gt;
                    &lt;/li&gt;
                    &lt;li class="nav-item"&gt;
                        &lt;a class="nav-link" th:href="@{about}"&gt;About&lt;/a&gt;
                    &lt;/li&gt;
                &lt;/ul&gt;
            &lt;/div&gt;
        &lt;/div&gt;
    &lt;/nav&gt;
</pre>
---
E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.  
<i>
Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
</i>

<pre>
- BootStrapData.java
    (Lines 43 - 45) call delete all to clear existing parts and products (comments to use only when necessary)
    (Lines 46 - 90) add 5 inhouse/outsourced parts for sample inventory only when there are none existing
    (Lines 93 - 105) add 5 products for sample inventory only when there are none existing
</pre>
---
F. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
- The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.

<pre>
- BuyNowController.java
    (ALL lines) create java file to handle logic for purchasing a product
- buynowerror.html
    (ALL lines) create HTML file for displaying purchase error message
- confirmationbuynow.html
    (ALL lines) create HTML file for displaying successful purchase message
- mainscreen.html
    (Lines 102 - 103) add "Buy Now" button next to the buttons that update and delete products
</pre>
---
G. Modify the parts to track maximum and minimum inventory by doing the following:
- Add additional fields to the part entity for maximum and minimum inventory.
- Modify the sample inventory to include the maximum and minimum fields.
- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
- Rename the file the persistent storage is saved to.
- Modify the code to enforce that the inventory is between or at the minimum and maximum value.

<pre>
- Part.java
    (Line 33 - 38, 92 - 107) add additional fields to the part entity for maximum and minimum inventory
- BootStrapData.java
    (Lines 53, 54, 61, 62, 69, 70, 77, 78, 90, 91, 98, 99) modify the sample inventory to include the maximum and minimum fields
- InhousePartForm.html
    (Lines 26 - 31) add to the InhousePartForm form additional text inputs for the inventory so the user can set the maximum and minimum values
- OutsourcedPartForm.html
    (Lines 27 - 32) add to the OutsourcedPartForm form additional text inputs for the inventory so the user can set the maximum and minimum values
- application.properties
    (Line 6) rename the file the persistent storage is saved to
- mainscreen.html
    (Lines 55, 56, 65, 66) add columns to mainscreen table for minimum/maximum inventory
- AddInhousePartController.java
    (Lines 42 - 50) add if statements to handle error messages if part inventory is less than minimum or greater than maximum
- AddOutsourcedPartController.java
    (Lines 43 - 51) add if statements to handle error messages if part inventory is less than minimum or greater than maximum
</pre>
---
H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
- Display error messages when adding and updating parts if the inventory is greater than the maximum.

<pre>
- InventoryValidator.java
    (ALL lines) create java file for checking if inventory is within minimum/maximum
- ValidInventory.java
    (ALL lines) create java file for validator resolution
- AddInhousePartController.java
    (Lines 42 - 50) add if statements to handle error messages if part inventory is less than minimum or greater than maximum
- AddOutsourcedPartController.java
    (Lines 43 - 51) add if statements to handle error messages if part inventory is less than minimum or greater than maximum
- Product.java
    (Lines 4 & 23) add validation annotation to java class
</pre>
---
I. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

<pre>
- PartTest.java
    (Lines 104 - 121) add two unit tests for the maximum/minimum fields to the PartTest class in the test package
</pre>
---
J. Remove the class files for any unused validators in order to clean your code.

<pre>
- DeletePartValidator.java
    (ALL lines) remove file for unused validator
- ValidDeletePart.java
    (ALL lines) remove file for unused validator
</pre>