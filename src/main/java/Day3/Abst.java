package Day3;

abstract class A{
    abstract void m1();
    void m2(){
        System.out.println("hello");
    }
}

class B extends A{
    @Override void m1(){
        System.out.println("hiiii");
    }
}

public class Abst {
    public static void main(String[] args) {
        A ob = new B();
        ob.m1();
        ob.m2();
    }
}
