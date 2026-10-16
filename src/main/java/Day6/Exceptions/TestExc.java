package Day6.Exceptions;

public class TestExc {

    public static void Checkage(int age){
        if(age < 0){
            throw new IllegalArgumentException("age can't be negative");
        }
        System.out.println("Age is:"+ age);
    }
    public static void main(String[] args) {
        int[] ar = {4,5,6,7};

        try {
            //System.out.println(ar[5]);

            //int res = 10/0;
            Checkage(-6);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught");
        }
        catch (ArithmeticException e){
            System.out.println("cannot divide by zero");
        }
        catch (IllegalArgumentException e){
            System.out.println("invalid age: "+ e.getMessage());
        }
        finally {
            System.out.println("finally executed");
        }
    }
}
