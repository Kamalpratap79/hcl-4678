package Day6.Exceptions;

import java.io.IOException;

class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        super(msg);
        System.out.println("Age is not valid");
    }
}
public class CustomException {
    public void fun(String st) throws IOException {

    }
    public static void main(String[] args) {
        int age = 9;
        try{
            if(age < 18){
                throw new InvalidAgeException("Under age");
            }
        }
        catch (InvalidAgeException e){
            System.out.println("not eligible " + e.getMessage());
        }
    }

}
