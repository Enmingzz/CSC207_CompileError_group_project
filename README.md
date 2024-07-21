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
The top bar exists on almost every page of our program. 
- if you didn't login, it will be like:

  ![image](https://github.com/user-attachments/assets/eefda7e2-2ed6-4f0f-b3e3-ae8dd1381182)

- if you are logged in, it will be like:

  
  ![image](https://github.com/user-attachments/assets/5fa50470-6cca-4ff7-b903-98e37e40a28e)

by clicking on the buttons, you can jump to the related page. the button with image of github cat will send you to your user profile page. it can be the user profile image in the future extension.

### 1. Profile 

#### Creating Account and Logging in 

#### Creating an Account and Logging 

#### Viewing Profile (the three branches) 

#### Modifying profile 

### 2. From a Seller's POV 

#### Creating a product or posting 

#### Modifying a product or posting 

#### Replying a question
- As a seller of a product, you can reply any questions displayed in the Q&A panel


![image](https://github.com/user-attachments/assets/ea53aa96-4f33-4874-a818-537d4e113cfa)

- By clicking on the reply button.

  ![image](https://github.com/user-attachments/assets/61830996-a718-478e-8f47-a3607f70fbbb)

- then you can view the answers you just replyed.(but for now, the when you go back to the view product detail page, the button covers your answer and so there is a ui problem. To view the following page, please first go to another page and then go back. )
![image](https://github.com/user-attachments/assets/8d99b434-05ed-4a45-9814-f9b597eae364)



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
- Unlogged in buyer:
  -click on the button under the product and you can view the product details, but when click on the add to cart button, you will jump to the login page.
- Already logged in buyer:
  - click on the button under the product and you can view the product details:

  <img width="748" alt="unlogged_in butter_fly" src="https://github.com/user-attachments/assets/1d92ba30-0797-4deb-84a7-8ecb1f57129e">  

#### Using the Q&A section in a product 
- Unlogged in buyer:
  you can only see the question on the right side, but you cannot ask questions.

  ![image](https://github.com/user-attachments/assets/bedb2bdc-fac6-4cb8-a439-5f8bd8431a0d)

- Already logged in buyer: you can see the Q&A panel on the right side of the page.

  - To publish a new question:
    you enter the new question at the bottom of the page press the publish button.
  
    <img width="792" alt="login_ask_question" src="https://github.com/user-attachments/assets/9589c37b-bc7b-4605-b4b3-77df1b1ee801">
  -then you will see the newly added quesiton

  
    <img width="755" alt="successfullyaskedaquestion" src="https://github.com/user-attachments/assets/553faa2b-18f9-4489-bae6-4301405ba7a3">

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







