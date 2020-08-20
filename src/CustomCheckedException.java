import java.util.Scanner;

// when you create exceptions by extending Exception, they are always checked exceptions.
// Because the only way to use custom exception is create its object and throw it. see below example

class NotProperNameException extends Exception {
    NotProperNameException(String msg){
        super(msg);
    }
}
public class CustomCheckedException{
    private String name;
    private int age;
    public static boolean containsAlphabet(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }
    public CustomCheckedException(String name, int age){
        if(name==null || !containsAlphabet(name)) {
            String msg = "Improper name (Should contain only characters between a to z (all small))";
            NotProperNameException exName = new NotProperNameException(msg);
            try {
                throw exName;   // if you do not surround it with try catch or throw it from method signature, it will give compile time error. So it is checked.
            } catch (NotProperNameException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name of the Student: "+this.name );
        System.out.println("Age of the Student: "+this.age );
    }
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name of the person: ");
        String name = sc.next();
        System.out.println("Enter the age of the person: ");
        int age = sc.nextInt();
        CustomCheckedException obj = new CustomCheckedException(name, age);
        obj.display();

        //un checked example
        //try {
            throw new NotProperNameExceptionUnchecked("Failed runtime"); // here if you notice though I am throwing an exception
            // compiler doesn't enforce me to surround by try catch or throw from method signature.
        /*} catch(Exception e){
            e.printStackTrace();
        }*/
        //Un checked exception can be handled to run program normally. Only difference in checked and unchecked
        // is checked exception are compulsory(enforced by compiler) to handle and unchecked are not.
    }
}

//If you create an exception by extending RuntimeException it is an un checked exception, though you throw it you
// need not necessarily catch it.

class NotProperNameExceptionUnchecked extends RuntimeException {
    NotProperNameExceptionUnchecked(String msg){
        super(msg);
    }
}


