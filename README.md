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
- click the sign up button on the left of the top bar, it will naviagte to the sign up view.
- Fill in your student number, a desired username, a password, re-enter it, and enter the prefix of your uoft student email. 
- If any of them is blank, then an error message will appear.
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

<img width="1256" alt="image" src="https://github.com/user-attachments/assets/92295224-0ebd-4660-a333-7983f17879c9">


<img width="1314" alt="image" src="https://github.com/user-attachments/assets/268d2d9b-8387-4075-9733-1208a14059f9">


#### Modifying a product or posting 

To modify a product, it must not have been purchased by any other user. You do so by navigating to the "Manage Product" page as mentioned before. Click on the "Modify" button for the product you desire to modify, and you should arrive on the following page.

<img width="1339" alt="Screenshot 2024-07-21 at 18 57 28" src="https://github.com/user-attachments/assets/7db2a6a4-6480-4d6c-b4cb-d6645663f701">

Choose the field you want to edit, and enter the new value you desire. Leave the fields you don't want to change as blank. Example shown below with changing address only.

<img width="1365" alt="Screenshot 2024-07-21 at 18 59 24" src="https://github.com/user-attachments/assets/dec5a479-ebbe-4d88-a8c3-2dc6e0ec6f2b">

Click "Modify Product" at bottom left of view. You shold be prompted as shown below.

<img width="1364" alt="image" src="https://github.com/user-attachments/assets/8ec1a600-3cc6-4f4a-bd0b-f11ae01d8d83">

You should be navigated to the "Manage Product" view. Now if you click "Show Detail", we should see the address being changed to BA 3185.

<img width="1211" alt="image" src="https://github.com/user-attachments/assets/25dd8cbe-11fa-4daa-8794-8e86c6dc72d0">


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
  
  ![image](https://github.com/user-attachments/assets/00ab1b4f-9efd-44cb-a9f3-4e448bf39605)

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

#### Seller Select Schedule 

  ![image](https://github.com/user-attachments/assets/86a1164a-4132-4837-bdff-5ab02b17346c)

  ![image](https://github.com/user-attachments/assets/83688dfe-6db7-4aff-985f-c10bf664df98)


- After a buyer purchases a product from the shopping cart, the seller can find a "Schedule Meeting Times" button next to this product in the manage product page in their profile, for selecting the times they are available to meet the buyer

  ![image](https://github.com/user-attachments/assets/44d454a5-846b-4520-b6cf-3842ef93c791)

- in seller schedule selecting page, seller can use the date and hour dropdowns to choose the available times.

  ![image](https://github.com/user-attachments/assets/c0dd57b8-d4f8-44e5-8dfd-b0040fdacd20)

  
- Click the "Add" button to add the selected time to the list of scheduled times.

  ![image](https://github.com/user-attachments/assets/38153443-74d0-42b4-8473-b7a9b701fd7a)

- Select a time from the list and click the "Remove" button to remove it.
- Click the "Cancel" button to return to the Manage Product page without selecting times.

  ![image](https://github.com/user-attachments/assets/3a3cefef-0d1e-4a3c-b80b-28016ee80668)

- Once seller have added all the available times, click the "Confirm" button. The buyer will then be prompted to select a meeting time among these available times.

#### Buyer Select Schedule 

  ![image](https://github.com/user-attachments/assets/cbe8c7b6-ee8d-4561-bb0a-e16248e2600c)

- After the seller has selected the available times, the buyer can find a "Choose Schedule" button next to this product in the shopping cart.

  ![image](https://github.com/user-attachments/assets/e142b17f-0e11-46fb-af6c-14b7e73bb0e5)

- click this button to go to the buyer schedule page. Buyer can select a meeting time from the seller's available times in this page.

  ![image](https://github.com/user-attachments/assets/3d210cb0-829b-4ea3-adc3-62064a4b2172)

- Use the dropdown to choose an available time provided by the seller.

- Click the "Cancel" button to return to the shopping cart without selecting a time.
  
  ![image](https://github.com/user-attachments/assets/977e5e9b-46d3-43d3-9014-b8ea730f2a88)

- Click the "Confirm Schedule" button to confirm the selected meeting time.

  ![image](https://github.com/user-attachments/assets/5f961eac-822f-4563-80bd-12b82eab5b66)

- After confirming a meeting time, the buyer can see the scheduled meeting time in the shopping cart.

  ![image](https://github.com/user-attachments/assets/63d63c7c-438d-4916-8dd0-c4f79709f8b5)

- Seller can see the time in the Manage Product page.



