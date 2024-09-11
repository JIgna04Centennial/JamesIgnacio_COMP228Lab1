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

public class Singer {
     private int iID;
     private String strName;
     private String strAddress;
     private int iDOBYr;
     private int iDOBMonth;
     private int iDOBDay;
     private int iNumAlbumsPublished;

     public Singer() {
          //Empty construct does nothing
     }
     public Singer(int ID) {
          // 1. Single construct
          iID = ID;
     }
     public Singer (int ID, String Name){
          // 2. 2 Arguments construct using current object keyword for 1 construct
          this(ID);
          strName = Name;
     }
     public Singer (int ID, String Name, String Address){
          // 3. 3 Arguments construct
          this(ID, Name);
          strAddress = Address;
     }
     public Singer (int ID, String Name, String Address, int NumAlbumsPublished) {
          // 4. 4 Arguments construct
          this(ID, Name, Address);
          iNumAlbumsPublished = NumAlbumsPublished;

     }
     public Singer (int ID, String Name, String Address, int NumAlbumsPublished, int DoBYear, int DoBMonth, int DoBDay){
          // 4. 6 Arguments construct
          this(ID,Name, Address, NumAlbumsPublished);
          iDOBYr= DoBYear;
          iDOBMonth = DoBMonth;
          iDOBDay = DoBDay;
     }

     //Setters methods
     public void updateID(int ID){
          this.iID = ID;
     }
     public void updateName(String Name){
          this.strName = Name;
     }
     public void updateAddress(String Address){
          this.strAddress = Address;
     }
     public void updateDoB(int year, int month, int day){
          //Some basic input validation
          if (year > 0)
               this.iDOBYr = year;
          if (month <= 12 && month > 0)
               this.iDOBMonth = month;
          if (day > 0 && day <= 31)
               this.iDOBDay = day;
     }
     public void updateNumAlbumsPublished(int NumberOfAlbumsPublished){
          this.iNumAlbumsPublished = NumberOfAlbumsPublished;
     }

     //Getters methods
     public int getID(){
         return this.iID;
     }
     public String getName(){
          return this.strName;
     }
     public String getAddress(){
          return this.strAddress;
     }
     public int getDoBYear() {
          return this.iDOBYr;

     }
     public int getDoBMonth() {
          return this.iDOBMonth;

     }
     public int getDoBDay() {
          return this.iDOBDay;

     }
     public int getNumAlbumsPublished(){
          return this.iNumAlbumsPublished;
     }

}
