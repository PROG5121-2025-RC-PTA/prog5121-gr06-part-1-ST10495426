/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logins;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Logins {

//Default constructor
    public Logins(){
}
    public static boolean checkUserName(String username){
        if(username.contains("_") && username.length() <=5) {
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkPasswordComplexity(String password){
        String Capital = ".*[A-Z].*";//checks capital letters
        String small = ".*[a-z].*";//checks small letters
        String special = ".*[!@#$%^&*(),.?\":{}|<>].*";//Check special charecters
        String digit = ".*\\d.*";//check digit charecters
        if(password.length()>=8 && password.matches(Capital)&& password.matches(small)&& password.matches(digit)&& password.matches(special)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkCellPhoneNumber(String phone){
        String saCode = "+27";
        String firstThreeCharacters =phone.substring(0,3);//Gets characters ffrom index 0 to 2 (inclusive)
        int fourthDigit = Character.getNumericValue(phone.charAt(3));//gets and convert fourth digit
        if(phone.length()<= 12 && firstThreeCharacters.equals(saCode)&& fourthDigit>=6 && fourthDigit<=8){
            return true;
        }else{
            return false;
        }
    }
    
    public static String registerUser(String Username,String Password, String Phone){
        boolean validatePhone=checkCellPhoneNumber (Phone);
        boolean validateUsername = checkUserName (Username);
        boolean validatePassword = checkPasswordComplexity(Password);
        if(validateUsername ==true && validatePhone ==true && validatePassword ==true){
            return "Successful User registration";
        }else{
            return "Failed User registration";
        }
            
    }
    
    public static boolean loginUser(String username,String password){
        boolean validUsername = checkUserName(username);
        boolean validPassword = checkPasswordComplexity(password);
        if(validUsername == true&&validPassword ==true){
            return true;
        }else{
            return false;
        }
    }
    
    public static String returnLoginStatus(String username,String password){
        boolean status= loginUser(username,password);
        if(status==true){
        return "A successful login";
        }else{
            return "A failed login";
        }
    }


    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);//Create and instantiate scanner object
        String username, password, phone;//declare user inputs
        // prompt and recieve user inputs
        System.out.print("Enter username:");
        username = input.nextLine();
        System.out.print("Enter Password:");
        password = input.nextLine();
        System.out.print("Enter Phone Number (stating with South African international code (+27)):");
        phone = input.nextLine();
        
        //Create and instantiate Login object
        boolean validatePhone = checkCellPhoneNumber(phone);
        boolean validateUsername = checkUserName(username);
        boolean validatePassword = checkPasswordComplexity(password);
        boolean logUser = loginUser(username, password);
        String status = returnLoginStatus( username, password);
        //Checks and validate usrname
        if(validateUsername == true){
            System.out.println("Username successfully captured.");
        }else{
            System.out.println("Username is not correctly formatted, please ensure that your username"+"contains an underscore and is no more than five characters in length.");
         }
        //checks and validate phone number
        if(validatePhone==true){
        System.out.println("Cell phonenumber successful added.");
        }else{
            System.out.println("Cell phone number incorrectly formatted or does not contain onternational code.");
        }
        //Check and validate password
        if(validatePassword ==true){
            System.out.println("password successfully captured.");
        }else{
            System.out.println("Password is not corrctly formayyed;please ensure that the password"+"contains at least eight characters,a capital and small letter, a number, and a special character");
        }
        
        if(logUser){
            System.out.println(status);
        }
        else{
            System.out.println(status);
        }
    }
    
}
