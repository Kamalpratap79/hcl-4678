package Abstraction;

public interface interf {

    void m1();
}

class C implements interf{
    public void m1(){
        System.out.println("hi i am advantage");
    }

    public static void main(String[] args) {
        interf obj = new C();
        obj.m1();
    }
}
