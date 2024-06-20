package BankingApp;

import javax.swing.JOptionPane;

public class Transactions {

    private String transactionName; // string variable to hold name of transaction
    private String description; // string variable to hold description of transaction
    public static int transactionNumber = -1;
// static int variable to autogenerate/ increment number of transction 
//>> set to 0 since no transactions are made when the project starts>> will keep track of transactionNumber 
    // >> static will allow the number to increase by 1 every time a transaction is added when the app runs 
//>> not reset to 0 every time a transaction is added
    private String recipient;// string variable to hold recipent of transaction
    private double transactionAmount; // double(decimal number eg. 99,99) variable to store amount of transaction >> in Rands and cents
    public static double totalAmount = 0;
// static double variable to keep track of total of transction (total amount of money transfered)
//>> set to 0 since no transactions are made when the project starts
    // >> static will allow it to accumulate/ add up for all transactions added when the app is running 
    String transactionID;// string variable to hold generated ID for transaction
    String transactionStatus;// string variable to hold status of transaction >> either pending or finalised 

    // create arrays to hold transaction values 
    static String[] arrRecipients = new String[20]; // contains the names of all the recipients
    static String[] arrTransactionNames = new String[20]; // contains the names of all the transactions
    static String[] arrTransactionIds = new String[20]; // contains the generated transaction ID's for all tasks
    static double[] arrAmounts = new double[20]; // contains the amounts of all transactions
    static String[] arrTransactionStatus = new String[20]; // contains the status of all transactions
    
    // CONSTRUCTOR METHOD
    // this method is called when an instance of this class is created 
    // >> it takes in the name, description, recipient , amount and status of the transaction as parameters
   
    public Transactions()
    {
        // empty constructor method 3
    }
    
    public Transactions(String transactionName, String description, String recipient, double transactionAmount, String transactionStatus) {
        this.transactionName = transactionName;// set transaction name to the name entered by user
        this.description = description;// set transaction description to the description entered by user
        transactionNumber++;// increment transaction number >> add 1 to the current transaction number to get the next transaction number
        this.recipient = recipient;// set transaction recipient to the recipient entered by user
        this.transactionAmount = transactionAmount;// set transaction amount to the amount entered by user
        this.transactionID = generateID();// call method >> created below >> to generate the transaction ID
        this.transactionStatus = transactionStatus;// set transaction status to the status entered by user
        totalAmount += transactionAmount; // add the amount of the current transaction to the total amount for all transactions
        populateArray();
        // call populate array method to add transaction values to different arrays 
    }// end constructor

   // create method to populate arrays with transaction cetails
public void populateArray()
{// begin populateArray method
 int position = transactionNumber; // position of transaction in the array is equal to the transaction number 
 
 arrRecipients[position] = recipient; // add recipient of this transaction to array 
 arrTransactionNames[position] = transactionName; // add name of this transaction to array 
 arrTransactionIds[position] = transactionID; // add id of this transaction to array 
 arrAmounts[position] = transactionAmount; // add amount of this transaction to array 
 arrTransactionStatus[position] = transactionStatus; // add status of this transaction to array 
 
}// end populateArray method

public String displayArray()
{
    String output ="";// string value to hold the report of all the transactions made
    
    // run a loop for all the transactions made >> using the transaction number >> 
    // since not all spaces in the array are populated 
    
    for (int i =0; i<= transactionNumber; i++)
    {
        // add the display values for the transaction to the display report 
        output += "Transaction Name:\t" + arrTransactionNames[i];
        output += "\nTransaction Number:\t" + i;
        output += "\nTransaction ID:\t" + arrTransactionIds[i];
        output += "\nTransaction Recipient:\t" + arrRecipients[i];
        output += "\nTransaction Amount:\t" + arrAmounts[i];
        output += "\nTransaction Status:\t" + arrTransactionStatus[i] + "\n\n";
 
    }
    // output the report with all transactions
    JOptionPane.showMessageDialog(null, output);
    return output;
}// end method 

public String displayFinalisedTransactions()
{
    String output ="";
    for (int i =0; i<= transactionNumber; i++)
    {
        if (arrTransactionStatus[i].equalsIgnoreCase("Finalised")){
        output += "Transaction Name:\t" + arrTransactionNames[i];
        output += "\nTransaction Number:\t" + i;
        output += "\nTransaction ID:\t" + arrTransactionIds[i];
        output += "\nTransaction Recipient:\t" + arrRecipients[i];
        output += "\nTransaction Amount:\t" + arrAmounts[i];
        output += "\nTransaction Status:\t" + arrTransactionStatus[i] + "\n\n";

        }
       
    }
    JOptionPane.showMessageDialog(null, output); 
    return output;
}// end method 

public boolean SearchTransactions(String transactionName)
{
    boolean found = false; // value to indicate if transaction was found or not 
    // run a loop for all transactions made >> sine we have to check all transactions to search for 
    
    // the transaction entered by the user
    for (int i =0; i <= transactionNumber; i++)
    {
        // if the transaction name in the array at this point matches the transaction name entered by the user 
        //>> then the transaction has been found 
        if (arrTransactionNames[i].equalsIgnoreCase(transactionName))
        {
            // display the values >> from the arrays >> for this transaction name found
        String output = "Transaction Name:\t" + arrTransactionNames[i];
        output += "\nTransaction Number:\t" + i;
        output += "\nTransaction ID:\t" + arrTransactionIds[i];
        output += "\nTransaction Recipient:\t" + arrRecipients[i];
        output += "\nTransaction Amount:\t" + arrAmounts[i];
        output += "\n\nTransaction Status:\t" + transactionStatus;
        // display output
        JOptionPane.showMessageDialog(null, output);
        found = true; // the value was found 
        }
    }
    // if value was not found >> tell the user to try again 
    if (!found){ JOptionPane.showMessageDialog(null, "Transaction not found. Please try again");}
    return found;
}// end search transactions method 

public boolean RemoveTransactions(String transactionName)
{
    String[] temparAarrRecipients = new String[transactionNumber+1]; 
    // contains the names of all the recipients not removed
    String[] tempArrTransactionNames = new String[transactionNumber+1]; 
    // contains the names of all the transactions not removed
    String[] tempArrTransactionIds = new String[transactionNumber+1]; 
    // contains the generated transaction ID's for all tasks not removed
    double[] tempArrAmounts = new double[transactionNumber+1];
    // contains the amounts of all transactions not removed
    String[] tempArrTransactionStatus = new String[transactionNumber+1]; 
    // contains the status of all transactions not removed
    
    int j= 0; 
    // variable to hold the index of the temporary transactions that were not removed 

    boolean removed = false; 
    // variable to keep track of if the transaction was removed or not 
    
   
    // run a loop for all transactions entered by the user
    for (int i =0; i <= transactionNumber; i++)
    {
        // if the transaction name of this transaction does NOT matches the transaction name 
        // entered by the user then it will not be removed >> since it is not the transaction entered by the user
        if (!(arrTransactionNames[i].equalsIgnoreCase(transactionName)))
        {
            // store each of the values for this transaction in the respective temporary arrays for 
            // later use
        tempArrAmounts[j] = arrAmounts[i];
        tempArrTransactionIds[j] = arrTransactionIds[i];
        tempArrTransactionNames[j] = arrTransactionNames[i];
        tempArrTransactionStatus[j] = arrTransactionStatus[i];
        temparAarrRecipients[j] = arrRecipients[i];
        j++; // add 1 to j since a value was added not removed 
        
        }
       // if the transaction name of this transaction matches the transaction name 
        // entered by the user then it will be removed >> it will not be added to the temp arrays 
        else { removed = true;}
    }

    // if no value was removed then ask user to try again 
    if (!removed){ 
        JOptionPane.showMessageDialog(null, "Transaction could not be removed. Please try again");
        
    }
    else { // a value was removed from the arrays 
      
        // the arrays for the transactions will not be equal to the temporary arrays 
        // since they stored all transaction values EXCEPT the transaction that was removed
      arrAmounts = tempArrAmounts;
      arrRecipients = temparAarrRecipients;
      arrTransactionIds = tempArrTransactionIds;
      arrTransactionNames = tempArrTransactionNames;
      arrTransactionStatus = tempArrTransactionStatus;
      // tell the user that the value was removed successfully 
      JOptionPane.showMessageDialog(null, "Transaction removed successfully.");
      // decrease the transaction number since one transaction was removed 
      transactionNumber--;
    }
    return removed;
}// end remove transaction method 



//SETTERS
    public void setTransactionName(String transactionName) 
    {this.transactionName = transactionName;}
// takes in the name of the transaction from the user as a parameter and assigns it to transaction name

    public void setDescription(String description) 
    {this.description = description;}
// takes in the description of the transaction from the user as a parameter and assigns it to transaction description

    public static void setTransactionNumber() 
    {transactionNumber++;}
// increments the transaction number i.e. transaction number +1 

    public static void resetTransactionNumber() 
    {transactionNumber = 0;}
    
    public void setRecipient(String recipient) 
    {this.recipient = recipient;}
// takes in the recipient of the transaction from the user as a parameter and assigns it to recipient

    public void setTransactionAmount(double transactionAmount) 
    {
        this.transactionAmount = transactionAmount;
        totalAmount += transactionAmount;
    } 
// takes in the amount of the transaction from the user as a parameter and assigns it to transaction amount
    
    public void resetTotalAmount(){
        totalAmount = 0;
    }

    public void setTransactionID() 
    {this.transactionID = generateID();}
    // calls the generateID method created to generate the transaction id

    public void setTransactionStatus(String transactionStatus) 
    {this.transactionStatus = transactionStatus;}
    // takes in the status of the transaction from the user as a parameter and assigns it to transaction status

    // this method generates the id for the transaction
    public String generateID() {
        
        // the string variable id will hold our id for now
        String id = transactionName.substring(0, 3);
        // this takes the first 3 characters of the transaction name 
        // eg. if the transaction name is RENT >> id = REN >> this took R E N from RENT (transaction name)
        id += "#" + transactionNumber + "*";
        // this adds # to the id >> then adds the transaction number to the id >> then adds * to the id
        // eg. if the transaction number is 1 >> the id will be REN#1*
        return id; // return the id created 
    }// end generate id method

    // this method compiles the output details and returns it as a string value
    public String outputDetails() {
        // create a string variable to hold the output >> String output
        String output = "Transaction Name:\t" + transactionName;
        output += "\nTransaction Number:\t" + transactionNumber;
        output += "\nTransaction ID:\t" + transactionID;
        output += "\nTransaction Recipient:\t" + recipient;
        output += "\nTransaction Amount:\t" + transactionAmount;
        output += "\nTransaction description:\t" + description;
        output += "\n\nTransaction Status:\t" + transactionStatus;
        // add the neccessary values to the output >> \t allows for a space between values 
        //>> \n allows you to go to the next line >> += allows you to add onto what is already stored in a variable
        return output;// return this output 
    }// end outputDetails method

// GETTERS 
    public String getTransactionName() 
    {return transactionName;} 
// this retrieves the transaction name from this class >> so that you can use it in other classes

    public String getDescription() 
    {return description;}
// this retrieves the transaction description from this class >> so that you can use it in other classes
    
    public static int getTransactionNumber() 
    {return transactionNumber;}
// this retrieves the transaction number from this class >> so that you can use it in other classes
    
    public String getRecipient() 
    {return recipient;}
// this retrieves the transaction recipient from this class >> so that you can use it in other classes
    
    public double getTransactionAmount() 
    {return transactionAmount;}
// this retrieves the transaction amount from this class >> so that you can use it in other classes
    
    public double getTotalAmount() 
    {return totalAmount;}
// this retrieves the total transaction amount for all transactions made by the user from this class >> so that you can use it in other classes
    
    public String getTransactionID() 
    {return transactionID;}
// this retrieves the transaction id from this class >> so that you can use it in other classes
    
    public String getTransactionStatus() 
    {return transactionStatus;}
// this retrieves the transaction status from this class >> so that you can use it in other classes

    public static void setTransactionNumber(int transactionNumber) {
        Transactions.transactionNumber = transactionNumber;
    }

    public static void setTotalAmount(double totalAmount) {
        Transactions.totalAmount = totalAmount;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public static void setArrRecipients() {
        arrRecipients = new String[20];
    }

    public static void setArrTransactionNames() {
        arrTransactionNames = new String[20];
    }

    public static void setArrTransactionIds() {
        arrTransactionIds = new String[20];
    }

    public static void setArrAmounts() {
        arrAmounts = new double[20];
    }

    public static void setArrTransactionStatus() {
        arrTransactionStatus = new String[20];
    }

    
    
    
}// end Transaction class
