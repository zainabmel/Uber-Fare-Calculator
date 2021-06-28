/*
 * Name: Zainab Melaibari
 * Email: zainabmel1421@gmail.com
 * Course number: CCCS121
 * Title: Uber Fare Calculator
 * Date: 12\3\2020 
 */

package uberfarecalculator;

/**
 *
 * @author zainab
 */

import java.util.Scanner;

public class UberFareCalculator {

    //Declare the input scanner as a global variable
    static Scanner input = new Scanner(System.in);
    
    
    //Define "welcomeTable" method that will display the main menu and get user's choice
    public static int welcomeTable(){
        
        System.out.println("----------------------------------------------------\n"
                        + "###       Welcome to Uber Fare Calculator       ###\n"
                        + "----------------------------------------------------\n"
                        + "| 1  : Get fare information about available rides  |\n"
                        + "| 2  : Get a fare Estimate for your Journey        |\n"
                        + "| 3  : Submit Rating of your Ride                  |\n"
                        + "| 4  : Exit and display summary                    |\n"
                        + "----------------------------------------------------");
        System.out.print(" > Plaese enter your choice...(1-4): ");
        int welcomeTableChoice=input.nextInt();
        System.out.println("");//To organize the output
        return welcomeTableChoice;
        
    }//End method
    
    
    //Define "ridesTable" method that will display the rides menu and get user's choice
    public static char ridesTable(){
        
        System.out.println("-------------------------------------\n"
                        + "***             RIDES             ***\n"
                        + "-------------------------------------\n"
                        + "| X or x  : UberX                   |\n"
                        + "| L or l  : UberXL                  |\n"
                        + "| B or b  : UberBlack               |\n"
                        + "| R or r  : Return to main menu     |\n"
                        + "-------------------------------------");
        System.out.print(" > Plaese enter your choice...");
        char ridesChoice=input.next().charAt(0);
        System.out.println("");//To organize the output
        return ridesChoice;
        
    }//End method
    
    
    //Define "optionsTable" method that will display the options menu and get user's choice
    public static char optionsTable(){
        
        System.out.println("-------------------------------------\n"
                         + "***            OPTIONS            ***\n"
                         + "-------------------------------------\n"
                         + "| B or b:   Base fare               |\n"
                         + "| M or m:   Cost Per minute         |\n"
                         + "| K or k:   Cost Per Km             |\n"
                         + "| S or s:   Service fee             |\n"
                         + "| C or c:   Cancellation fee        |\n"
                         + "| F or f:   Minimum fee             |\n"
                         + "| R or r:   Previous Menu           |\n"
                         + "-------------------------------------");
        System.out.print(" > Please enter your choice...");
        char optionsChoice=input.next().charAt(0);
        System.out.println("");//To organize the output
        return optionsChoice;
        
    }//End method
    
    
    //Define "ratingTable" method that will display the rating menu and get user's choice
    public static int ratingTable(){
        
        System.out.println("-------------------------------------\n"
                        + "***            RATING            ***\n"
                        + "-------------------------------------\n"
                        + "| 1 Poor                            |\n"
                        + "| 2 Borderline                      |\n"
                        + "| 3 Satisfactory                    |\n"
                        + "| 4 Good                            |\n"
                        + "| 5 Outstanding                     |\n"
                        + "-------------------------------------");
        System.out.print(" > Please enter your choice... ");
        int ratingChoice=input.nextInt();
        System.out.println("");//To organize the output
        return ratingChoice;
        
    }//End method
    
    
    //Define "journeyInformation" method that will calculate the total fare
    public static void journeyInformation(double minutCost,double distanceCost,double baseFare){
        
        System.out.print("Please provide the information about your journey: \n"
                        + "------------------------------------------------------\n"
                        + "Ride time in minutes: ");
        double rideTime=input.nextDouble();//Get ride time of user's journey
        //Validate the entry until the user enters a valid value
        while (rideTime<0){
            System.out.println("\nInvalid Input!! Please Try again\n");
            System.out.print("Ride time in minutes: ");
            rideTime=input.nextDouble();//Get ride time of user's journey again
        }
        System.out.println("");//To organize the output
        System.out.print("Ride distance in KM(s): ");
        double rideDistance=input.nextDouble();//Get ride distance of user's journey
        //Validate the entry until the user enters a valid value
        while (rideDistance<0){
            System.out.println("\nInvalid Input!! Please Try again\n");
            System.out.print("Ride distance in KM(s): ");
            rideDistance=input.nextDouble();//Get ride distance of user's journey again
        }
        //Calculate "rideFare" the total fare of user's journey
        double rideFare=((rideTime*minutCost)+(rideDistance*distanceCost));
        /*If the total fare is greater than the base fare of ride type, then print 
          calculated total fare. Otherwise, print the base fare of ride type*/
        if (rideFare>baseFare){
            System.out.printf("%s%n%s%.2f%s%n","~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                            ," > Expected ride fare: ",rideFare,"SR  <");
        }
        else if (rideFare<baseFare){
            System.out.printf("%s%n%s%.2f%s%n","~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                            ," > Expected ride fare: ",baseFare,"SR  <");
        }
        
    }//End method
    
    
    //Define "summary" method that will display the summary table of counted user activities in the program
    public static void summary(int XInfoCount,int XEstCount, int XRatingCount,int XLInfoCount,int XLEstCount, int XLRatingCount, int XBInfoCount,int XBEstCount, int XBRatingCount){
      
        System.out.print("------------------------------------------------------------------------\n"
                        + "###                             SUMMARY                              ###\n"
                        + "------------------------------------------------------------------------\n"
                        + "| Ride          | # of Fare Info. | # Fare Est. | of Submitted Ratings |\n"
                        + "------------------------------------------------------------------------\n");
        System.out.printf("%S%16d%S%12d%s%21d%s%n%S%16d%S%12d%s%21d%s%n%S%16d%S%12d%s%21d%s%n%s%n%s%n"
                        ,"| UberX         |",XInfoCount," |",XEstCount," |",XRatingCount," |"
                        , "| UberXL        |",XLInfoCount," |",XLEstCount," |",XLRatingCount," |"
                        , "| UberXBlack    |",XBInfoCount," |",XBEstCount," |",XBRatingCount," |"
                        ,"------------------------------------------------------------------------"
                        ," Thank you for using Uber Fare Calculation System!");
        
    }//End method
    
    
    //Define "main" method, the main path for program flow
    public static void main(String[] args) {
        
        //Define types of some essential variables
        double baseFare=0, minutCost=0, distanceCost=0, cancelFee=0, minFee=0;//Constant values that will vary for each ride type
        int XInfoCount=0,XEstCount=0,XRatingCount=0;//Counting variables for uberX activities
        int XLInfoCount=0,XLEstCount=0,XLRatingCount=0;//Counting variables for uberXL activities
        int XBInfoCount=0,XBEstCount=0,XBRatingCount=0;//Counting variables for uberBlack activities
        int welcomeTableChoice;//User choice of welcome menu
        char ridesChoice,optionsChoice;//User choice of rides and options menu
        String rideType="",serviceFee="N/A";

        do{
            //Display welcome menu and get user choice
            welcomeTableChoice=welcomeTable();
            //Validate the entry until the user enters a valid value
            while ((welcomeTableChoice!=1)&(welcomeTableChoice!=2)&(welcomeTableChoice!=3)&(welcomeTableChoice!=4)){
                System.out.println("Invalid Choice!! Please Try Again...");
                System.out.println("");//To organize the output
                welcomeTableChoice=welcomeTable();
            }//End while loop
            
            if(welcomeTableChoice!=4){//If the user didn't choose to end the program   

                do{
                    //Display rides menu and get user choice
                    ridesChoice=ridesTable();
                    //Validate the entry until the user enters a valid value
                    while ((ridesChoice!='r')&(ridesChoice!='R')&(ridesChoice!='x')&(ridesChoice!='X')&(ridesChoice!='l')&(ridesChoice!='L')&(ridesChoice!='b')&(ridesChoice!='B')){
                        System.out.println("Invalid Choice!! Please Try again");
                        System.out.println("");//To organize the output
                        ridesChoice=ridesTable();
                    }//End while loop
                    
                    switch(ridesChoice){
                        //In case the user choose uberX, define these constant values
                        case 'x':
                        case 'X':    
                            rideType="UberX";
                            baseFare=3.2;
                            minutCost=0.25;
                            distanceCost=0.9;
                            cancelFee=8;
                            minFee=8;
                            break;
                        //In case the user choose uberXL, define these constant values    
                        case 'l':
                        case 'L':    
                            rideType="UberXL";
                            baseFare=5.5;
                            minutCost=0.4;
                            distanceCost=1.25;
                            cancelFee=12;
                            minFee=12;
                            break;
                        //In case the user choose uberBlack, define these constant values    
                        case 'b':
                        case 'B':    
                            rideType="UberBlack";
                            baseFare=9.5;
                            minutCost=0.85;
                            distanceCost=1.8;
                            cancelFee=20;
                            minFee=20; 
                            break;
                    }//End switch
                    
                    //If the user choose to get fare information about specific ride type
                    if ((welcomeTableChoice==1)&((ridesChoice!='r')&(ridesChoice!='R'))){
                        
                        //Increase the counter of the chosen ride type
                        switch(rideType){
                            case "UberX":
                                XInfoCount++;
                                break;
                            case "UberXL":
                                XLInfoCount++;
                                break;
                            case "UberBlack":
                                XBInfoCount++;
                                break;    
                        }//End switch
                        
                        //Display options menu and get user choice
                        optionsChoice=optionsTable();
                        //Validate the entry until the user enters a valid value
                        while(((optionsChoice!='r')&(optionsChoice!='R')&(optionsChoice!='b')&(optionsChoice!='B')&(optionsChoice!='k')&(optionsChoice!='K')&(optionsChoice!='m')&(optionsChoice!='M')&(optionsChoice!='f')&(optionsChoice!='F')&(optionsChoice!='s')&(optionsChoice!='S')&(optionsChoice!='c')&(optionsChoice!='C'))){
                            System.out.println("Invalid Choice!! Please Try again");
                            System.out.println("");//To organize the output
                            optionsChoice=optionsTable();
                            }//End while loop
                        
                        //While the user didn't choose to return to the previous menu
                        while((optionsChoice!='r')&(optionsChoice!='R')){

                            switch(optionsChoice){
                                //In case the user asked about base fase information
                                case 'b':
                                case 'B':    
                                    System.out.println("Base fare for "+rideType+" is "+baseFare+"SR");
                                    break;
                                //In case the user asked about the cost per km    
                                case 'k':
                                case 'K':    
                                    System.out.println("Cost per km for "+rideType+" is "+distanceCost+"SR");
                                    break;
                                //In case the user asked about the cost per minute     
                                case 'm':
                                case 'M':    
                                    System.out.println("Cost per minute for "+rideType+" is "+minutCost+"SR");
                                    break;
                                //In case the user asked about the minimum fee   
                                case 'f':
                                case 'F':    
                                    System.out.println("Minimum fee for "+rideType+" is "+minFee+"SR");
                                    break;
                                //In case the user asked about the service fee  
                                case 's':
                                case 'S':    
                                    System.out.println("Service fee for "+rideType+" is: "+serviceFee);
                                    break;
                                //In case the user asked about the cancellation fee      
                                case 'c':
                                case 'C':   
                                    System.out.println("Cancellation fee for "+rideType+" is "+cancelFee+"SR");
                                    break;
                            }//End switch
                            
                            System.out.println("");//To organize the output
                            //Display options menu and get user choice again
                            optionsChoice=optionsTable();
                            //Validate the entry until the user enters a valid value
                            while(((optionsChoice!='r')&(optionsChoice!='R')&(optionsChoice!='b')&(optionsChoice!='B')&(optionsChoice!='k')&(optionsChoice!='K')&(optionsChoice!='m')&(optionsChoice!='M')&(optionsChoice!='f')&(optionsChoice!='F')&(optionsChoice!='s')&(optionsChoice!='S')&(optionsChoice!='c')&(optionsChoice!='C'))){
                                System.out.println("Invalid Choice!! Please Try again");
                                System.out.println("");//To organize the output
                                optionsChoice=optionsTable();
                            }//End while loop
                            
                        }//End while loop 
                        
                    }//End if statement
                    
                    //If the user choose to get a fare estimate for his/her journey
                    if ((welcomeTableChoice==2)&((ridesChoice!='r')&(ridesChoice!='R'))){
                        
                        //Call "journeyInformation" method to calculate the fare
                        journeyInformation(minutCost,distanceCost,baseFare);
                        System.out.println("");//To organize the output
                        
                        //Increase the counter of the chosen ride type
                        switch(rideType){
                            case "UberX":
                                XEstCount++;
                                break;
                            case "UberXL":
                                XLEstCount++;
                                break;
                            case "UberBlack":
                                XBEstCount++;
                                break;    
                        }//End switch
                        
                    }//End if statement
                    
                    //If the user choose to submit rating of his/her ride
                    if ((welcomeTableChoice==3)&((ridesChoice!='r')&(ridesChoice!='R'))){
                        
                        //Call "ratingTable" method and get rating choice
                        int ratingChoice=ratingTable();
                        
                        //Validate the entry until the user enters a valid value
                        while ((ratingChoice!=1)&(ratingChoice!=2)&(ratingChoice!=3)&(ratingChoice!=4)&(ratingChoice!=5)){
                                System.out.println("Invalid Choice!! Please Try again");
                                System.out.println("");//To organize the output
                                ratingChoice=ratingTable();
                        }//End loop
                        
                        System.out.println("\nThank you for your rating!\n"
                            + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                            + " you give rating > "+ratingChoice+" <\n"
                            + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
                        
                        //Increase the counter of the chosen ride type
                        switch(rideType){
                            case "UberX":
                                XRatingCount++;
                                break;
                            case "UberXL":
                                XLRatingCount++;
                                break;
                            case "UberBlack":
                                XBRatingCount++;
                                break;    
                        }//End switch
                        
                    }//End if statement
                    
                }while((ridesChoice!='r')&(ridesChoice!='R'));//While the user didn't choose to return to main menu 
                
            }//End if statement
            
        }while (welcomeTableChoice!=4);//While the user didn't choose to exit the program
        
        //Call summary method, then end the program
        summary(XInfoCount,XEstCount,XRatingCount,XLInfoCount,XLEstCount,XLRatingCount,XBInfoCount,XBEstCount,XBRatingCount);
        System.out.println("");//To organize the output
        
    }//End main method
    
}//End class