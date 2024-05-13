# BankingApp

**Application Overview:**
This is a simple banking application written in Java. It allows users to log in with an account ID and password, then perform various banking transactions like making transactions and viewing bank reports.

![image](https://github.com/TanyaGov/PROG5212-BankingApp/assets/105000800/46e408bc-1488-407c-acf2-d889efea9d58)

**Features:**

1. **Login Functionality:**
    - Users are prompted to enter their account ID and password.
    - The app verifies the entered credentials.
    - If the credentials are correct, the user is granted access to the banking features.
    - If the credentials are incorrect, the user is prompted to try again.

2. **Transaction Management:**
    - Users can make transactions by entering transaction details such as name, description, recipient, amount, and status.
    - Transactions can be pending or finalized.
    - The app keeps track of the total amount transacted.

3. **Option Selection:**
    - Users can select various banking options from a menu.
    - Options include making transactions, viewing bank reports, and exiting the application.

**Usage:**
1. **Login:**
    - Run the application.
    - Enter your account ID and password.
    - If the login is successful, you will be welcomed to the banking app.
    - If the login fails, you will be prompted to try again.

2. **Transaction Management:**
    - After logging in, select the "Make Transaction" option.
    - Enter the details of the transaction such as name, description, recipient, amount, and status.
    - Repeat the process for multiple transactions if needed.

3. **Bank Reports:**
    - This feature is not yet implemented in the current version of the application.

4. **Exit:**
    - To exit the application, select the "Exit" option.

**Notes:**
- The application uses JOptionPane for user interaction, providing a simple GUI interface.
- Transactions are stored and managed using the Transactions class, which handles transaction details and IDs.
- Passwords must contain at least one digit and one space.
- Account IDs must contain both a "$" and a "*".

**Future Enhancements:**
- Implement bank report generation functionality.
- Improve security features such as encryption for passwords.
- Add support for multiple user accounts and database integration for data persistence.
