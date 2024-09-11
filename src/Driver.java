/*
Student Name: James Ignacio
Student Number: 822865945
Class: Java Programming (SEC. 409)
Lab: Lab1

Description:
Write a Java application that creates a Java console application to keep records of singers and displays stored record. Follow the following instructions to develop the application:

Create a class named *Singers* with the following specifications:
 - *5 instance variables* that would store the following singer data (Use recommended variable naming conventions and appropriate data type for each instance variable):
    - Singer’s id
    - Singer’s name
    - Singer’s address
    - Date of birth
    - Number of albums published
    - *Several constructors* that would allow you to construct Singer object with no arguments, 1 argument, 2 arguments, 3 arguments, 4 arguments, and 5 arguments.

- Create *Setters* and *getters* for all the instance variables of class Singer. Make sure to have several setters that would allow you to set the values of individual instance variables of the singer object. Also create one setter that would allow you to set all the values of the instance variables at once. Create several getters that would allow you to get the current individual values of each instance variables of the Singer object.

- Create the *driver* class that would create 1 Singer (singer1) object with the help of the no argument constructor. *Display the default values* of the instance variables of this object singer1.

*Set the values of each instance variables with the help of setters*. *Display the values.*
 */
//import classes
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void PromptStart() {

        //instantiate Singer object with default construct
        Singer objSinger = new Singer();

        //Start DisplayProcedure
        System.out.println("========================================");
        System.out.println("= Welcome to LAB1: Singer Records Demo =");

        //Capture User input
        int [] selections;

        //control block to create a new object or just performs updates
        boolean proceedtoUpdate = false;

        Scanner in;
        //Instantiate Singer object
        do {
            try {
                //Display Singer Info
                DisplayCurrentSingerInfo(objSinger);

                //Prepare input capture
                in = new Scanner(System.in);
                selections = CommandOptions(objSinger);
                for (int i = 0; i < selections.length;i++){
                    //Go through all the options
                    switch (selections[i]) {
                        case 1: {
                            System.out.print("Enter Singer ID:");
                            objSinger = new Singer(in.nextInt());
                            break;
                        }
                        case 2: {
                            System.out.print("Enter Singer Name:");
                            objSinger = new Singer(objSinger.getID(),in.next());
                            break;
                        }
                        case 3:{
                            System.out.print("Enter Address:");
                            objSinger = new Singer(objSinger.getID(),objSinger.getName(), in.next());
                            break;
                        }
                        case 4:{
                            //Special handling for instantiation
                            objSinger = PromptDoBHandler(objSinger);
                            break;
                        }
                        case 5:{
                            System.out.print("Enter Number of Albums Published:");
                            objSinger = new Singer(objSinger.getID(),objSinger.getName(),objSinger.getAddress(), in.nextInt(), objSinger.getDoBYear(), objSinger.getDoBMonth(), objSinger.getDoBDay());
                            break;
                        }
                    }
                }
                //System.out.println("CREATE MODE");
                proceedtoUpdate = true;

            } catch (Exception ex) {
                ShowLastErrorMsg(ex.toString());
                proceedtoUpdate = false;
            }
        } while (!proceedtoUpdate);



        System.out.println("========== RECORD UPDATED! =============");

        //Any updates from this point will be using Updates(Setters) methods instead. /////
        boolean continueRun = true;

        do {
                try
                {
                    //Display Singer Info
                    DisplayCurrentSingerInfo(objSinger);

                    //Prepare input capture
                    in = new Scanner(System.in);
                    selections = CommandOptions(objSinger);

                    for (int i = 0; i < selections.length;i++) {
                        //Go through all the options
                        switch (selections[i]) {
                            case 1: {
                                System.out.print("Enter Singer ID:");
                                objSinger.updateID(in.nextInt());
                                break;
                            }
                            case 2: {
                                System.out.print("Enter Singer Name:");
                                objSinger.updateName(in.next());
                                break;
                            }
                            case 3: {
                                System.out.print("Enter Address:");
                                objSinger.updateAddress(in.next());
                                break;
                            }
                            case 4: {
                                //Special handling for instantiation
                                objSinger = UpdateDoBHandler(objSinger);
                                break;
                            }
                            case 5: {
                                System.out.print("Enter Number of Albums Published:");
                                objSinger.updateNumAlbumsPublished(in.nextInt());
                                break;
                            }

                        }
                    }
                    System.out.println("========== RECORD UPDATED! =============");
                    System.out.println("UPDATE MODE");
                } catch (Exception ex){
                    ShowLastErrorMsg(ex.toString());
                }
        } while (continueRun);


    }

    //Handler for checking DoB format
    private static Singer PromptDoBHandler(Singer obj){
        int year = 0, month =0, day = 1;

        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter DoB Year[>0]: ");
                year = in.nextInt();
                System.out.print("Enter DoB Month [1-12]: ");
                month = in.nextInt();
                System.out.print("Enter Date of Birth Date [1-31]: ");
                day = in.nextInt();

                if(!isDoBValid(year,month,day))
                    ShowLastErrorMsg("Date of birth format not accepted. Try again please.");
            }
            catch (Exception ex)
            {
                ShowLastErrorMsg("Date of birth format not accepted. Try again please.");
            }
        } while(!isDoBValid(year,month,day));

        return new Singer(obj.getID(), obj.getName(), obj.getAddress(),obj.getNumAlbumsPublished(),year,month,day);
    }

    //Handler for checking DoB format
    private static Singer UpdateDoBHandler(Singer obj){
        int year = 0, month =0, day = 1;
        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter DoB Year[>0]: ");
                year = in.nextInt();
                System.out.print("Enter DoB Month [1-12]: ");
                month = in.nextInt();
                System.out.print("Enter Date of Birth Date [1-31]: ");
                day = in.nextInt();

                if(!isDoBValid(year,month,day))
                    ShowLastErrorMsg("Date of birth format not accepted. Try again please.");
            }
            catch (Exception ex)
            {
                ShowLastErrorMsg("Date of birth format not accepted. Try again please.");
            }
        } while(!isDoBValid(year,month,day));

        obj.updateDoB(year,month,day);

        //Return updated value
        return obj;
    }


    private static boolean isDoBValid(int year, int month, int day){
        //Some basic input validation
        if (year > 0 && month <= 12 && month > 0 && day > 0 && day <= 31)
            return true;
        else
            return false;
    }

    //Console aesthetics functions
    private static void ClearScreenConsole() {

    }

    private static void DisplayCurrentSingerInfo(Singer obj){
        //Start DisplayProcedure
        System.out.println("========================================");
        System.out.println("= 1. Singer ID: " + DisplayDefaultLabel(obj.getID()));
        System.out.println("= 2. Name: " + DisplayDefaultLabel(obj.getName()));
        System.out.println("= 3. Address: " + DisplayDefaultLabel(obj.getAddress()));
        System.out.println("= 4. Date of Birth: " + DisplayDefaultLabel(obj.getDoBYear(), obj.getDoBMonth(), obj.getDoBDay()));
        System.out.println("= 5. Number of Albums: " + DisplayDefaultLabel(obj.getNumAlbumsPublished()));
        System.out.println("========================================");
    }

    //Display label when value is empty (String type)
    private static String DisplayDefaultLabel(String obj){
        if (obj == null)
            return "<Not Set>";

        //Cast object to string incase it is a diff type
        return obj;
    }
    //Display label when value is empty (Int type)
    private static String DisplayDefaultLabel(int obj){
        if (obj == 0)
            return "<Not Set>";

        //Cast object to string incase it is a diff type
        return Integer.toString(obj);
    }
    //Display label when value is empty (Int type) for DOB
    private static String DisplayDefaultLabel(int year, int month, int day){

        //Check if all DoB are set correctly
        if(year == 0 || month == 0 || day == 0)
            return "<Not Set>";

        //Cast object to string incase it is a diff type
        return Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);
    }

    private static int [] CommandOptions(Singer obj){

        //Input scanner object to capture user response
        Scanner in;
        int [] selections = new int[5];
        String selectionpattern;

        //Input validation
        boolean continueprompt = true;
        do {
            try
            {
                in = new Scanner(System.in);
                //User input selections
                System.out.println(" ");
                System.out.println("You can do single record or in combinations i.e. 1-5 or just 1,2,3");
                System.out.print("Enter info to change/add <1-5>: ");
                // Determine if it is a valid selection
                selectionpattern = in.nextLine();

                //Try to parse the selection (very simple algo)
                //As range 1-5
                if(selectionpattern.contains("-") || selectionpattern.contains(",")) {
                    String [] lSelections = new String[5];

                    //Array of selections for "-"
                    boolean isRange = false;
                    if(selectionpattern.contains("-")) {
                        lSelections = selectionpattern.split("-");
                        isRange = true;
                    }

                    //check to try to assume it maybe "," separated
                    if(selectionpattern.contains(","))
                        lSelections = selectionpattern.split(",");

                    //Capture and store
                    int maxLoopRange = selections.length; //default iterator
                    if(isRange){
                        //change mxLoop control
                        maxLoopRange = Integer.parseInt(lSelections[1]); // get the last part of as max
                    }
                    for (int i = 0; i < maxLoopRange; i++) {
                        //store the selections with only matching value
                        if(isRange)
                        {
                            //select the matching values only by looping through the store values in the selections array
                            int minvalueToMatch = Integer.parseInt(lSelections[0]);
                            int maxvalueToMatch = Integer.parseInt(lSelections[lSelections.length -1]);

                            // if the value matches or in between ranges store it as selection
                            // with offset since array storage starts with 0 instead of 1
                            if(i >= minvalueToMatch -1 && i <= maxvalueToMatch)
                                selections[i] = i+1;
                        }
                        else
                            if(i < lSelections.length)
                                selections[i] = Integer.parseInt(lSelections[i]); //Get the actual values from the comma separated input instead
                    }
                }
                else
                {
                    // Assume single selection
                    selections[0] = Integer.parseInt(selectionpattern);
                }

                //Input validation check, there should be atleast one valid values
                boolean gotError = false;
                for (int i = 0; i < selections.length; i++) {
                    if(selections[i] < 0 || selections[i] > selections.length + 1) {
                        continueprompt = true;
                        gotError = true;
                        break;
                    }
                    continueprompt = false;

                }

                // Determine if it has an error to say, coming out of the for loop above. Doing this to prevent multiple error messages from the for loop displayed to the user
                if(gotError) {
                    DisplayCurrentSingerInfo(obj);
                    ShowLastErrorMsg("Invalid selection(s)/value(s). Check number.");
                    continueprompt = true;
                }
            }
            catch (Exception ex) {
                DisplayCurrentSingerInfo(obj);
                ShowLastErrorMsg(ex.toString());
                in = new Scanner(System.in);
            }
        }
        while (continueprompt);

        //Return selections sorted already
        Arrays.sort(selections);
        return selections;
    }

    private static void ShowLastErrorMsg(String iMsg)
    {
        System.out.println("Last Error: " + iMsg);
    }


}