<!DOCTYPE html>
<html lang="en">

# BankingApp

## 🟢 Application Overview

This is a simple banking application written in Java. It allows users to log in with an account ID and password, then perform various banking transactions like making transactions and viewing bank reports.

![image](https://github.com/TanyaGov/PROG5212-BankingApp/assets/105000800/4e4f8f8c-c8f5-40c7-b5b7-a04e038b7f7d)


#### The application uses JOptionPane for user interaction, providing a simple GUI interface.
#### Transactions are stored and managed using the Transactions class, which handles transaction details.
#### Users are able to view Transactions that they have made

### Features:

1. **Login Functionality:**
    - Users are prompted to enter their account ID and password.
    - The app checks that the account ID contains a dollar sign and an astras.
    - The app checks that the password contains a digit and white space.
    - If the these conditions are met , the user is granted access to the banking features.
    - If the credentials are incorrect, the user is prompted to try again.

2. **Option Selection:**
    - Users can select various banking options from a menu.
    - Options include making transactions, viewing bank reports, and exiting the application.
      
 3. **Making Transactions:**
    - Users can make transactions by entering transaction details such as name, description, recipient, amount, and status.
    - Transactions can be pending or finalized.
    - The app keeps track of the total amount of transactions.
  
 4. **Banking Report:**
    - The application stores all the transactions made by a user in arrays.
    - The application displays a report of all the transactions made by the user.
    - The application allows a user to search for a transaction by transaction name.
    - The user is able to remove any transaction by entering the transaction name.

 5. **Exit Application**
    - Allows the user to exit the application and displays a goodbye message.




