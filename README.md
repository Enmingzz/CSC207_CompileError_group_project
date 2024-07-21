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

#### Purchasing a product 

### 4. Completing the trade 

#### Buyer Select Schedule 

#### Seller Select Schedule 







