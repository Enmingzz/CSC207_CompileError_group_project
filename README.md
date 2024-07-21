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

When on a main page, and you want to create a product for posting, navigate by clicking on the github icon (to the right of the "Log Out" button").
You should arrive on the page as displayed below.

<img width="1357" alt="Screenshot 2024-07-21 at 18 25 01" src="https://github.com/user-attachments/assets/16583982-c1c7-4d2d-ba6d-7800245f99d6">

Then, click on "Manage Product" on the left. You should arrive on the page displayed below.

<img width="1350" alt="Screenshot 2024-07-21 at 18 26 14" src="https://github.com/user-attachments/assets/9d265921-267d-4f5b-becd-4255dacb2a5e">

Click on the "Add product" button on the right. You should arrive on the page displayed as below.

<img width="1357" alt="Screenshot 2024-07-21 at 18 27 24" src="https://github.com/user-attachments/assets/cce5a6b8-14c5-4204-b5c0-392a0dfefa32">

Fill in "Product Title", "Product Description", "Product Price" (This should be a float of at most 2 decimal places), "Product eTransfer Email", "Product Pickup Address", and select one of the 3 tags (hold command/ctrl depending on mac/windows respectively to select multiple). Then click on "Upload Image" at the bottom of the page. You should see a popup page as shown below.

<img width="1350" alt="Screenshot 2024-07-21 at 18 32 04" src="https://github.com/user-attachments/assets/fce1003a-4772-432b-b528-53285a20991c">

Once image has been uploaded, a popup should appear prompting image has been added, then you should see the image uploaded below as shown.

<img width="1335" alt="Screenshot 2024-07-21 at 18 33 17" src="https://github.com/user-attachments/assets/c2c3c077-0c7b-4edf-aea4-c82550311130">

if a field is empty, an error message is prompted as shown below.

<img width="1297" alt="image" src="https://github.com/user-attachments/assets/5dafe051-0b96-43c1-a8fe-1f981c619154">

If all fields are valid, then the product will be created successfully. You should now see it in your "Manage Product" page and "Main Page", as shown below (Don't mind the formatting, this will be fixed in Phase 2).

<img width="1297" alt="image" src="https://github.com/user-attachments/assets/590d77be-3c6b-43f7-8e64-2260322f922b">

<img width="216" alt="image" src="https://github.com/user-attachments/assets/139817a0-d5d6-49e0-b25c-3e7721319018">

#### Modifying a product or posting 

### 3. A Buyer's POV 

#### Using the Search bar to search for products

  ![image](https://github.com/user-attachments/assets/3b98d419-dc5f-40cc-81b2-bc3e2603aac4)

- Both unlogged and logged users can access the search page to search for products.
- The search page consists of three parts:
  - Top Bar.
  - Search Bar: Allows users to enter search criteria by name or by selecting tags.
  - Products Displayed: Shows the products based on the search criteria or initial display.
- Initially, all products that are on sale will be displayed on the search page.

- **Search By Name**
  
  ![image](https://github.com/user-attachments/assets/970395d9-4e59-40b4-b7c7-bfa072d3b4fc)

  - Enter the text in the search text box. Note that the search is case-sensitive.
  - Click the search button.
  
  ![image](https://github.com/user-attachments/assets/fd22fda2-9750-4e1f-95cb-93ad9d2f3a9a)

  - The search results will display products whose names (titles) contain the entered search text. Products with names that exactly match the search text will be displayed first, followed by products with partial matches.
 
- **Search By Tag**
  
  ![image](https://github.com/user-attachments/assets/d7e6e79d-7109-4c35-84da-0c89e46d69de)

  - Below are the buttons for every tag that products can have.
  - Click the button corresponding to the tag you want to search by.
 
    ![image](https://github.com/user-attachments/assets/e1fb9527-67ee-474c-bb5f-2532e0a016db)

  - The search results will display products that have the selected tag.

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







