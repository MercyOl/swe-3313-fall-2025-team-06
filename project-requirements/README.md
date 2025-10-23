# **Version #1 — Must Have**

### **Epic: T6E-1 – User Registration and Login**

- **T6S-1: Allow users to self-register**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The user must be able to self-register by creating a unique username and a password that is no less than 6 characters long.  

- **T6S-2: Log in as a registered user**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The user must be able to log in with their unique credentials. Upon validated login, the system must direct the user to the inventory screen.  

---

### **Epic: T6E-2 – Admin Account Creation**

- **T6S-3: Create admin user type**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must include a more powerful user type called Admin that can run sales reports.  

- **T6S-4: Convert registered user to admin**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The admin must be created by converting a previously registered user.  

---

### **Epic: T6E-3 – Inventory Catalog**

- **T6S-5: Display only unsold items**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must display only items that have not been purchased.  

- **T6S-6: Sort inventory by price**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must sort all items from highest to lowest price.  

- **T6S-7: Enable inventory search**  
  - **Priority:** Must Have  
  - **Effort:** 1.5 days  
  - **Type:** Functional  
  - **Description:** The user must be able to search for items using keywords from their name or description.  

---

### **Epic: T6E-4 – Product Display and Pricing**

- **T6S-8: Show item details and add-to-cart button**  
  - **Priority:** Must Have  
  - **Effort:** 1.5 days  
  - **Type:** Functional  
  - **Description:** The system must display each inventory item’s name, price, description, and an add-to-cart button.  

- **T6S-9: Display formatted pricing**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must show all prices in U.S. dollars formatted with a $ sign, commas, and two decimal points (e.g., $1,200.00).  

- **T6S-10: Store prices in decimal currency**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Non-Functional  
  - **Description:** Prices must be stored in decimal (base-10) currency format to prevent rounding errors.  

---

### **Epic: T6E-5 – Shopping Cart Management**

- **T6S-11: Add multiple items to cart**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The user must be able to add multiple items to the shopping cart.  

- **T6S-12: Begin checkout**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The user must click the Checkout button to begin the payment process.  

- **T6S-13: Disable checkout when empty**  
  - **Priority:** Must Have  
  - **Effort:** 0.25 day  
  - **Type:** Functional  
  - **Description:** The system must disable the Checkout button when the cart is empty.  

- **T6S-14: Display cart summary and subtotal**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must show all items in the cart and the subtotal in U.S. dollars after the user clicks Checkout.  

- **T6S-15: Remove items from cart**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The user must be able to remove items from the shopping cart.  

- **T6S-16: Return to main screen when empty**  
  - **Priority:** Must Have  
  - **Effort:** 0.25 day  
  - **Type:** Functional  
  - **Description:** The system must automatically return the user to the main catalog screen if all items are removed from the cart.  

---

### **Epic: T6E-6 – Checkout Process**

- **T6S-17: Guide user through checkout flow**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must guide users through payment and shipping entry before confirming the order.  

- **T6S-18: Start checkout with Pay Now**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The user must click Pay Now from the cart page to start checkout or choose to continue shopping.  

- **T6S-19: Collect payment and shipping details**  
  - **Priority:** Must Have  
  - **Effort:** 2 days  
  - **Type:** Functional  
  - **Description:** The user must enter their shipping address, phone number, credit card number, expiration month and year, CVV, and choose a shipping option.  

- **T6S-20: Validate required fields**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must ensure all checkout fields are filled before the user can continue.  

- **T6S-21: Offer shipping options**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must provide three shipping options: Overnight ($29), 3-Day ($19), and Ground (Free).  

- **T6S-22: Confirm order completion**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The user must click Confirm Order to continue once all information is entered.  

---

### **Epic: T6E-7 – Order Calculation and Confirmation**

- **T6S-23: Calculate totals**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must calculate subtotal, 6% tax, and shipping cost to display the grand total. (subtotal + (subtotal × 0.06) + shipping cost = grand total)

- **T6S-24: Display confirmation details**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must display item names, prices, subtotal, tax, shipping cost, and grand total on the Confirm Order page.  

---

### **Epic: T6E-8 – Order Completion and Receipt**

- **T6S-25: Display receipt after purchase**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must show the user a receipt listing item details, subtotal, tax, shipping, grand total, shipping address, and the last four digits of the credit card.  

- **T6S-26: Allow navigation before finalizing**  
  - **Priority:** Must Have  
  - **Effort:** 0.25 day  
  - **Type:** Functional  
  - **Description:** The user must be able to return to the checkout page or main catalog before finalizing the order.  

- **T6S-27: Clear cart and hide purchased items**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must clear the cart and remove purchased items from the catalog and search results once the user clicks OK on the receipt screen.  

---

### **Epic: T6E-9 – Sales Reporting**

- **T6S-28: Display sales report**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The admin must be able to view a report of all completed sales.  

- **T6S-29: Include item and buyer info**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must include each purchased item and buyer information in the report.  

- **T6S-30: Update report after purchase**  
  - **Priority:** Must Have  
  - **Effort:** 0.25 day  
  - **Type:** Functional  
  - **Description:** The system must update the sales report automatically once a purchase is completed.  

---

### **Epic: T6E-10 – Inventory Entry**

- **T6S-31: Add new inventory items**  
  - **Priority:** Must Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The admin must be able to manually add new inventory items to the database.  

- **T6S-32: Provide admin documentation**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Non-Functional  
  - **Description:** Must provide a simple, documented process for admins with limited technical skills to add inventory items.  

---

### **Epic: T6E-11 – High-Fidelity UI Mockup**

- **T6S-33: Create detailed mockups**  
  - **Priority:** Must Have  
  - **Effort:** 1.5 days  
  - **Type:** Non-Functional  
  - **Description:** The development team must create detailed mockups of all screens.  

- **T6S-34: Review and approve mockups**  
  - **Priority:** Must Have  
  - **Effort:** 0.5 day  
  - **Type:** Non-Functional  
  - **Description:** The client must review and approve all mockups before development begins.  

---

# **Version #2 — Needs/Wants**

### **Epic: T6E-1 – Admin Role Management UI**

- **T6S-35: Provide admin role management interface**  
  - **Priority:** Needs to Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The admin must be able to access an interface to promote registered users to the admin role.  

---

### **Epic: T6E-2 – Email Receipt Delivery**

- **T6S-36: Send purchase receipts automatically**  
  - **Priority:** Needs to Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must automatically send a receipt to the user after each purchase.  

- **T6S-37: Match email content to on-screen receipt**  
  - **Priority:** Needs to Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must ensure that the email content matches the on-screen receipt displayed during checkout.  

- **T6S-38: Simulate or integrate email delivery**  
  - **Priority:** Wants to Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The system must either simulate email delivery in-browser or integrate with a third-party service to send real emails.  

---

### **Epic: T6E-3 – Sales Report Receipt Access**

- **T6S-39: View receipt from sales report**  
  - **Priority:** Needs to Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The admin must be able to click on any sold item in the sales report to open and view its detailed receipt.  

---

### **Epic: T6E-4 – Sales Report Export**

- **T6S-40: Export report as CSV**  
  - **Priority:** Needs to Have  
  - **Effort:** 1 day  
  - **Type:** Functional  
  - **Description:** The admin must be able to export the sales report as a CSV file.

---

### **Epic: T6E-5 – Inventory Management Interface**

- **T6S-41: Add new items via admin interface**  
  - **Priority:** Needs to Have  
  - **Effort:** 1.5 days  
  - **Type:** Functional  
  - **Description:** The admin must be able to use an interface to add new items, including name, description, price, and image upload.  

- **T6S-42: Display new items in the catalog**  
  - **Priority:** Needs to Have  
  - **Effort:** 0.5 day  
  - **Type:** Functional  
  - **Description:** The system must automatically display new items in the catalog once they are submitted through the admin interface.  
