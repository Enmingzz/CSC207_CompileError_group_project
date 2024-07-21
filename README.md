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
- The sign-up view allows new users to create an account by entering necessary details.
- The sign-up view Page provides fields for users to enter their details:
  - Enter student number: Input field for the student number.
  - Choose username: Input field for the username.
  - Choose password: Input field for the password.
  - Enter password again: Input field to confirm the password.
  - Enter email: Input field for the email (domain @mail.utoronto.ca is preset).
  - Enter verification code: Input field for the verification code.
- Button:
  - Sign Up: Registers the user and creates a new account.
  - Send: send the code to your utoronto email.

- ![image](https://github.com/user-attachments/assets/822192e7-c16c-483d-9d41-000ca4cc1263)
- If the student number already has a account then the error message will show up as:
  - ![image](https://github.com/user-attachments/assets/0ea4e1db-8888-495e-b7f2-03207728dba4)
 
- If the Password dose not match then the error message will show up as:
  - ![image](https://github.com/user-attachments/assets/e86aa12d-4446-4037-a7ef-fb0aa463bd75)



#### Creating an Account and Logging 
- After Sign Up the Login Page will show up.
- The login view allows users to authenticate by entering their student number and password.
- The login view Page provides fields for users to enter their credentials:
  - Enter your student number: Input field for the student number.
  - Enter password: Input field for the password.
- Button:
 - Log in: Authenticates the user and grants access to the application.

- ![image](https://github.com/user-attachments/assets/852ed544-e0b4-4012-b560-358eb0eb8333)

- If the password does not match the sign up password.
- A Error message will show up as following:
 - ![image](https://github.com/user-attachments/assets/19d9bf36-2f21-4e66-98b3-77095a39e124)


#### Viewing Profile (the three branches) 
- After log in, the View Profile Page will show up.
- The profile viewing section provides a detailed view of the user's profile, displaying essential information such as:
- ![image](https://github.com/user-attachments/assets/102e42a1-8c75-4859-8324-f04d631f785e)

### #Modifying profile 
- The modify profile Page provides fields for users to enter and update their profile information:
  - Enter Name: Input field to update the user's name.
  - Enter Password: Input field to update the user's password.
- Buttons:
  - Confirm: Saves the updated information.
  - Back: Returns to the Viewing Profile screen.
    
- ![image](https://github.com/user-attachments/assets/fb33fdef-e2b2-47a2-a461-9e6887e80f0d)

- If the user didn't change anything, a Error message will show up as following:
  - ![image](https://github.com/user-attachments/assets/0484a562-6d6c-4254-a67f-bd10356d535e)


### #Manage products 
- The manage products Page displays a list of products with details and options to:
  - Show Detail: View detailed information about the product.
  - Modify: Edit the product's information.
  - Delete Product: Remove the product from the list.
  - Add Product: Add a new product to the list.
- Each product entry includes:
  - Title
  - State (e.g., being sold, need to scheduling meeting times)
  - Rating
  - Price
  - Image

- ![image](https://github.com/user-attachments/assets/3e5c7745-cdb2-48f1-a8ca-a8563d36d524)

### 2. From a Seller's POV 

#### Creating a product or posting 

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







