package BankingApp;

public class Transactions {

    private String transactionName; // string variable to hold name of transaction
    private String description; // string variable to hold description of transaction
    public static int transactionNumber = 0;
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

    // CONSTRUCTOR METHOD
    // this method is called when an instance of this class is created 
    // >> it takes in the name, description, recipient , amount and status of the transaction as parameters
    
    public Transactions(String transactionName, String description, String recipient, double transactionAmount, String transactionStatus) {
        this.transactionName = transactionName;// set transaction name to the name entered by user
        this.description = description;// set transaction description to the description entered by user
        transactionNumber++;// increment transaction number >> add 1 to the current transaction number to get the next transaction number
        this.recipient = recipient;// set transaction recipient to the recipient entered by user
        this.transactionAmount = transactionAmount;// set transaction amount to the amount entered by user
        this.transactionID = generateID();// call method >> created below >> to generate the transaction ID
        this.transactionStatus = transactionStatus;// set transaction status to the status entered by user
        totalAmount += transactionAmount; // add the amount of the current transaction to the total amount for all transactions
    }// end constructor

   
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
}// end Transaction class
