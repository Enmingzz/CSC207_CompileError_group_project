## Steps to run and use this program 

## 0. Clone the project form Github to a local repository in IntelliJ 

## 1. Downloading APIs and packages and adding them to 
- go to https://javaee.github.io/javamail/ and download **javax.mail.jar**
- go to https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16 and download

- Open IntelliJ and go to File -> Project Structure -> Modules -> Dependencies. In here, click the '+' icon and select ‘JARs or directories' and add the downloaded Jar files.

- Upon completing these steps, the program should have no import errors and should be runnable. 

## 2. Running the program 
- Go to src/app/Main, and click the run button

![image](https://github.com/user-attachments/assets/9f1e2193-83fa-4a61-80df-825fa49ac415)

- In the "Run Tool Window", you should see all the views loading (this might take a few seconds). 
![image](https://github.com/user-attachments/assets/7ad98bc8-a78d-4c8c-8bb3-6c3c2b9ca7bb)
- A new window should pop up (as shown below).
![image](https://github.com/user-attachments/assets/040efdb0-4ee3-42af-b313-033462f455e3)


## 3. Exploring the Program 

### 0. Explaining the TOP bar

### 1. Profile 

#### Creating Account and Logging in 

#### Creating an Account and Logging 

#### Viewing Profile (the three branches) 

### #Modifying profile 

### 2. From a Seller's POV 

#### Creating a product or posting 

#### Modifying a product or posting 

### 3. A Buyer's POV 

#### Using the Search bar to search for products

#### Viewing specific details of a product 

#### Using the Q&A section in a product 

#### Shopping cart 


Once logged in, one should see the "Shopping Cart" button.
Once you click it, you should see a list of all products that you have added to your cart, as well as the total price.

<img width="840" alt="Screenshot 2024-07-21 at 17 49 39" src="https://github.com/user-attachments/assets/65e8965e-3169-4714-a767-0a3cef97f900">

To add a product to cart, simply click on the button below the image of a product (note, it cannot be a product you are
 currently selling). Then click "Add to shopping cart"
 
<img width="1355" alt="Screenshot 2024-07-21 at 17 47 33" src="https://github.com/user-attachments/assets/6a372637-1778-4872-9cc1-3844a1caf5d3">

Now if you check your shopping cart again, it should be added in, with the total price updated (I took the liberty to add other products).

<img width="567" alt="Screenshot 2024-07-21 at 17 52 32" src="https://github.com/user-attachments/assets/eb451f46-4df2-485a-9d5d-e08b266f0b2d">

If you attempt to add the same product again, an error message appears.

<img width="1190" alt="Screenshot 2024-07-21 at 18 02 30" src="https://github.com/user-attachments/assets/04cd8091-66ff-4e0b-9f48-11b6a4750c90">

If you want to remove an item from cart, simply click the "Remove From Cart" button (size of button is still waiting to be adjusted in phase 2).

<img width="1273" alt="Screenshot 2024-07-21 at 18 04 44" src="https://github.com/user-attachments/assets/0011660b-bb67-4adc-956b-058be6b970a0">


#### Purchasing a product 

If you want to purchase a product from your cart, simply click Buy Product. Then the seller will be prompted to select a schedule, and your display will appear as below.

<img width="681" alt="Screenshot 2024-07-21 at 18 06 15" src="https://github.com/user-attachments/assets/8a548b7a-cb2e-4680-bced-5effeaaf5e03">

### 4. Completing the trade 

#### Buyer Select Schedule 

#### Seller Select Schedule 







