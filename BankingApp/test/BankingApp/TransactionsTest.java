package BankingApp;// same package as the other classes in your project 

// add JAR file first >> look at Unit Testing Guide for more details

import org.junit.Test;
import static org.junit.Assert.*;
public class TransactionsTest {

Transactions transaction1 = new Transactions("Savings",null, "Mike Paulson", 500,"Pending" );
Transactions transaction2 = new Transactions("Car payment", null, "Samantha Harrison", 800, "Finalised");

@Test
    public void testDisplayArray() 
    {
 
     String expectedResults = "";// create string value to hold the expected results of the test
        
        expectedResults += "Transaction Name:\t" + "Savings";
        expectedResults += "\nTransaction Number:\t" + 0;
        expectedResults += "\nTransaction ID:\t" + "Sav#0*";
        expectedResults += "\nTransaction Recipient:\t" + "Mike Paulson";
        expectedResults += "\nTransaction Amount:\t" + 500.0;
        expectedResults += "\nTransaction Status:\t" + "Pending"  + "\n\n";
        
        expectedResults += "Transaction Name:\t" + "Car payment";
        expectedResults += "\nTransaction Number:\t" + 1;
        expectedResults += "\nTransaction ID:\t" + "Car#1*";
        expectedResults += "\nTransaction Recipient:\t" + "Samantha Harrison";
        expectedResults += "\nTransaction Amount:\t" + 800.0;
        expectedResults += "\nTransaction Status:\t" + "Finalised"  + "\n\n";
     

        String actualResults = transaction1.displayArray();
        // retrieve actual results by calling method from transaction class
        assertEquals(expectedResults, actualResults);// compare the expected results to the actual results 
    }
    
    @Test
    public void testSearchTransactions() {
    
    boolean actualResult= transaction2.SearchTransactions("Savings");
     // retrieve actual results by calling method from transaction class
       
     assertTrue(actualResult);// determine if actual result is true
    }
   
    @Test
    public void testDisplayFinalisedTransactions() {
   
    String actualResults = transaction2.displayFinalisedTransactions();
     // retrieve actual results by calling method from transaction class
     
     // generate expected result from this test
        String expectedResult = "";
        expectedResult += "Transaction Name:\t" + "Car payment";
        expectedResult += "\nTransaction Number:\t" + 1;
        expectedResult += "\nTransaction ID:\t" + "Car#1*";
        expectedResult += "\nTransaction Recipient:\t" + "Samantha Harrison";
        expectedResult += "\nTransaction Amount:\t" + 800.0;
        expectedResult += "\nTransaction Status:\t" + "Finalised"  + "\n\n";
        
        assertEquals(expectedResult, actualResults);// compare the expected results to the actual results 
    }
   
    
    
    
}// end unit testing class 
