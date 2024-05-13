package BankingApp; // package >> should be the same for all classes (pages/ forms) in this project
import javax.swing.JOptionPane;// import Joption pane library to use
public class BankingApp {

    // MAIN method
    public static void main(String[] args) {
       
        boolean loggedIn = false;// create a boolean (true or false) variable to hold the login state of the user 
        //>> if user login is successful then loggedIn is true >> else loggedIn is false >> user cant access features
        
        while (!loggedIn) { // create a while loop
        //>> this will allow the user to keep trying to login while loggedIn is false >> !(not) true
        // >> once the user is logged in the while loop will end >> loggedIn = true
        
            String accountID = JOptionPane.showInputDialog(null, "Plese enter your accountID");
            String password = JOptionPane.showInputDialog(null, "Plese enter the your password");
            // ask user for accountID and password using JOption pane
            
            // call the checkPassword method to check that the password is correct
            // call the chckAccountID method to check that the accountID is correct
            // if both are correct (&&) then the user can login and access features
            if (checkPassword(password) && checkAccountID(accountID))
            {
                JOptionPane.showMessageDialog(null, "Welcome to The Banking App");
                // call the options method to display all the features to the user
                options();
                // successful login >> loggedIn = true so the application will no longer ask to login
                loggedIn = true;
            }
            
            // Password or accountID incorrect >> loggedIn still false >> ask the user to try again
            else
            { JOptionPane.showMessageDialog(null, "Invalid details please try again");}
            
        }// end while loop >> loop will run until loggedIn = true >> until password and accountID are correct
        
    }// end main method
    
    // this method takes in the accountID from the user as a parameter and returns a bollean value (true or false)
    public static boolean checkAccountID(String accountID)
    {
        boolean containsSign = false;
        // boolean variable to check if accountID contains a $ >> set to false
        boolean containsAstras = false;
        // boolean variable to check if accountID contains a * >> set to false
        
        // check if the accountID contains a * 
        //>> if it contains a * then set containsAstras to true >> since there is an * in the ID
        if (accountID.contains("*"))
        {containsAstras = true;}
        
        // check if the accountID contains a $ 
        //>> if it contains a $ then set containsSign to true >> since there is an $ in the ID
        if (accountID.contains("$"))
        {containsSign = true;}
        
        // if the accountID has both a $ and a * then the ID is correct >> return true 
        if (containsAstras && containsSign)
        { return  true;}
        
        // the accountID doesnt meet the requirements >> so return false
        else
        {return false;}
    }// end checkAccountID methos
    
     // this method takes in the password from the user as a parameter and returns a bollean value (true or false)
    public static boolean checkPassword(String password)
    {
        boolean containsDigits = false;
         // boolean variable to check if the password contains a digit >> set to false
        boolean containsSpace = false;
         // boolean variable to check if the password contains a space >> " " >> set to false
         
        int passwordLength = password.length();
        // create an integer(number) variable to hold the length of the password >> the .length() methods returns the length of the string/word 
        //>> e.g EXAMPLE.length() = 7 >> since there are 7 letters in EXAMPLE
        
        // for loop >> runs for the length of the password >> to check each character in the password
        for (int i = 0; i < passwordLength; i++) { 
            char character = password.charAt(i);
            // create a char (single character eg. A) variable to hold one character in password at a time
            
            // if this character in the password at this index is a whitespace >> then change containsSpace to true
            if (Character.isWhitespace(character))
            { containsSpace = true;}
             // if this character in the password at this index is a digit >> then change containsDigit to true
            if (Character.isDigit(character))
            { containsDigits = true;}
        }
        
        // if password containd a digit and a space >> then return true
        if (containsDigits && containsSpace)
        { return true;}
        // else the password doesnt meet the requirements >> return false
        else{ return false;}
    }// end checkPassword
    
    // this method provides the user with a list of options and allows then to select a feature to use
    public static void options()
    {
        int option =0;// declare a variable to hold the users choice 
        
        // run this loop >> ask the user to select a feature>> while the option selected is not equal to 3 >> exit
        while (option != 3) {
            
            String tasks = JOptionPane.showInputDialog(null, "Plese select one of the following options:(enter the number of your selection)\n"
                    + "1: Make Transaction\n2: Bank report\n3: Exit");
            // ask the user to select an option >> choose a feature
            option = Integer.parseInt(tasks);
            // convert this user input from string to int
            
            // switch case for different options 
            // >> displays different features based on option entered by user
            switch (option) {
                // if option = 1  >> add tasks
                case 1:
                   String transactions = JOptionPane.showInputDialog(null, "Plese enter the number of transactions you want to make");
                   // ask the user to enter the total number of transactions they want to enter
                   int numTransactions = Integer.parseInt(transactions); 
                   // conver the number of transactions from string to int (words to number)
                   double totalAmount = createTransaction(numTransactions);
                   // call method to create transactions >> returns the total amount for all transactions 
                   // assign this total amount to a new variable 
                   JOptionPane.showMessageDialog(null,"Total amount of transactions: R"+ totalAmount);
                   // display the total amount for the transactions to the user
                break;// end option 1
                
                // if option = 2 >> display that the feature is coming soon
                case 2:
                    JOptionPane.showMessageDialog(null,"Implemented in future");
                    // display the message to the user
                break;// end option 2
                
                // if option = 3 >> display goodbye message and exit application
                case 3:
                    JOptionPane.showMessageDialog(null,"Goodbye :)");
                    // display goodbye message to the user
                    System.exit(0);
                    // exit the application
                break;// end option 3
        }// end switch case
        }// end while loop >> once option = 3 >> user chose to exit
        
    }// end option method
    
    // this method gets the neccessary information for the transactions from the user 
    // >> it takes in the number of transactions as a paramete >> it then creates an instance of the transaction 
    // >> it return the total amount for all these transactions
    public static double createTransaction(int numTransactions)
    {
        double total=0;
        // create a variable to hold the total amount for all transactions
        
        // for loop >> runs for the number of transactions needed by the user
        for (int i=0; i< numTransactions; i++)
        {
            // ask the user for the neccessary information for this transaction
            String transactionName = JOptionPane.showInputDialog(null, "Plese enter the NAME of transactions" + (i+1));
            String description = JOptionPane.showInputDialog(null, "Plese enter the DESCRIPTION of transactions" + (i+1)); 
            String recipient = JOptionPane.showInputDialog(null, "Plese enter the RECIPIENT of transactions" + (i+1));
            String amount = JOptionPane.showInputDialog(null, "Plese enter the AMOUNT of transactions" + (i+1));
            int transactionAmount = Integer.parseInt(amount); // convert from string to int
            String status = JOptionPane.showInputDialog(null, "Plese select the STATUS of transactions" + (i+1) 
                    +"\n1: Pending\n2:Finalised");// get the status from the user
            int option = Integer.parseInt(status);// convert from string to int
            
            String transactionStatus = retrieveStatus(option);
            // call method to get value for status option
            
            Transactions transaction = new Transactions(transactionName, description, recipient, transactionAmount, transactionStatus);
            // create a new transaction object using the information entered by the user
            String output = transaction.outputDetails();
            // call method >> from transaction class (.outputDetails) >> to display info to user
            JOptionPane.showMessageDialog(null, output);
            // display this info to the user
            total = transaction.getTotalAmount();
            //get the total amount for all transactions so far
        }// end for loop
 
        return total;
        // return the total amount for all transactions
            
    }// end createTransaction method
    
    // this methods determines the status of a transaction >> it takes in the option selected by the user as a parameter
    //>> it returns the status as a string (word)
    public static String retrieveStatus(int option)
    { 
        String transactionStatus = "";
              switch (option) {
                case 1:
                   transactionStatus = "Pending"; // set status to pending
                break;
                case 2:
                    transactionStatus = "Finalised"; // set status to finalised
                break;
    }// end switch 
              return  transactionStatus;// return status
    }
    
}// end bankingApp class
