/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usernames;

import java.util.Scanner;
import java.util.regex.*;

public class UserNames {
    static String LoginFromUser;
    static char ch;
    static boolean numberFlag = false;
    static boolean uppercaseFlag = false;
    static boolean lowercaseFlag = false;
    static boolean specialFlag = false;
    static boolean lengthFlag = false;
    static boolean crapcharFlag = true;
    
    static boolean usernameValid = false;
    
    static String repeat = "";
    
    
    static Scanner repeaty = new Scanner(System.in);
    
    //public String usernamepattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.[!@#$])(?=\\S+$).{5,}";
    /*static Pattern pattern;
    static Matcher matcher;*/
    
                

    
    //String LoginFromUser = "";
	public static void greetUser() {
		//System.out.println("greetUser");
		System.out.println("Please enter a username:");
	}
	public static String readUser() {
		//String LoginFromUser = "readUser";
		//System.out.println(LoginFromUser);
		Scanner userinput = new Scanner(System.in);
		LoginFromUser = userinput.nextLine();
		System.out.println("You have entered: " + LoginFromUser);
                return LoginFromUser;
	}
        //public static final String EXAMPLE_TEST = LoginFromUser;
	
        public static void checkCase() {
                //System.out.println("CHECKCASEYO!");
                String line = LoginFromUser;
                String lowerpattern = "[a-z]";
                String upperpattern = "[A-Z]";
                String numberpattern = "[0-9]";
                String specialpattern = "[!@#$]";
                String badpattern = "[^A-Za-z0-9!@#$]";
                
                //Find if there's a lowercase character
                Pattern lower = Pattern.compile(lowerpattern);
                Matcher mlower = lower.matcher(line);
                if (mlower.find()) {
                    //System.out.println("Found value: " + mlower.group(0));
                    lowercaseFlag = true;
                    System.out.println("The flag for lowercase is set to true:" + lowercaseFlag);
                }else {
                    System.out.println("There is no lowercase character.");
                }
                
                //Find if there's an uppercase character
                Pattern upper = Pattern.compile(upperpattern);
                Matcher mupper = upper.matcher(line);
                if (mupper.find()) {
                    //System.out.println("Found value: " + mupper.group(0));
                    uppercaseFlag = true;
                    //System.out.println("The flag for uppercase is set to true:" + uppercaseFlag);
                }else {
                    System.out.println("There was no uppercase character.");
                }
                
                //Find if there's a number
                Pattern number = Pattern.compile(numberpattern);
                Matcher mnumber = number.matcher(line);
                if (mnumber.find()) {
                    //System.out.println("Found value: " + mnumber.group(0));
                    numberFlag = true;
                    //System.out.println("The flag for number is set to true:" + numberFlag);
                }else {
                    System.out.println("There was no number.");
                }
                
                //Find if there's a special character
                Pattern special = Pattern.compile(specialpattern);
                Matcher mspecial = special.matcher(line);
                if (mspecial.find()) {
                    //System.out.println("Found value: " + mspecial.group(0));
                    specialFlag = true;
                    //System.out.println("The flag for special is set to true:" + specialFlag);
                }else {
                    System.out.println("There was no special character (!@#$)");
                }
                
                //Find if any wonky characters were used
                Pattern bad = Pattern.compile(badpattern);
                Matcher mbad = bad.matcher(line);
                if (mbad.find()) {
                    //System.out.println("Found value: " + mbad.group(0));
                    System.out.println("You can only use characters A-Z, a-z, 0-9 and !@#$");
                    crapcharFlag = false;
                    //System.out.println("The flag for crapchar is set to false:" + crapcharFlag);
                }else {
                    //System.out.println("No funny input was attempted");
                }
               
                
                
                //System.out.println(EXAMPLE_TEST.matches("[a-z]"));
                //String uppercaseFlag = "(?=.[A-Z])";
                //pattern = Pattern.compile(uppercaseFlag);
                
		//System.out.println("checkCase");
                //System.out.println(LoginFromUser + " this is the string");
                /*for(int i=0; i < LoginFromUser.length(); i++) {
                    if(ch >= 48 && ch <= 57) {
                        numberFlag = true;
                    }
                 System.out.println("has number:" + LoginFromUser.charAt(i) + " pos: " + i + " test:" + numberFlag);
                 System.out.println(numberFlag);*/
                //return LoginFromUser.matches("[A-Z]");
                /*if(LoginFromUser.matches("[A-Z]")) {
                    uppercaseFlag = true;
                } */
                //String blah = "J28843A!a";
                /*Pattern expression = Pattern.compile(pattern);
                Matcher m = expression.matcher(LoginFromUser);
                if (m.find())
                       return true;
                return false;*/
                //System.out.println(LoginFromUser.matches(pattern));
                //pattern = Pattern.compile(usernamepattern);
	}
	public static void checkLength() {
		//System.out.println("checkLength");
                String linelength = LoginFromUser;
                int length = linelength.length();
                
                if (length >= 5) {
                    //System.out.println("The length is: " + length);
                    lengthFlag = true;
                }else {
                    System.out.println("You need to enter at least 5 characters for your username.");
                }
	}
	public static void checkValidity() {
                /*matcher = pattern.matcher(LoginFromUser);
                return matcher.matches();*/
		//System.out.println("checkValidity");
                if (numberFlag == true && lowercaseFlag == true && uppercaseFlag == true && specialFlag == true && crapcharFlag == true && lengthFlag == true) {
                    System.out.println("That username works!");
                    usernameValid = true;
                }else {
                    System.out.println("That username does not meet the requirements.");
                }
	}
	
        //I don't see the benefit of breaking up checkValidity() into two methods.
        /*public static void printUser() {
		boolean LoginValidity = false;
		System.out.println(LoginValidity);
	}*/
	public static void addToReport() {
            if (usernameValid == true) {
		System.out.println("addToReport - the username worked");
	} else {
                System.out.println("addtoReport - the username did not work");
            }
        }
        
        public static void tryAgain() {
            System.out.println("Do you want to try another username? Type 'y' if you do.");
            repeat = repeaty.next();
        }
	public static void printReport() {
		System.out.println("printReport");
}
	
	public static void main(String[] argvs) {
            do {
                greetUser();
		readUser();
		checkCase();
		checkLength();
		checkValidity();
		//printUser();
		addToReport();
                tryAgain();
                }
            while(repeat.equalsIgnoreCase("y"));
            printReport();
}
}
	

