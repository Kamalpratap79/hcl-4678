package constructors;

public class Cons {
    //constructor is default type if we do not use public or protected and can not called by outside package
    public Cons(){
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        Cons obj = new Cons();
    }
}
