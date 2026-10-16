package inheritance;

  class B {
    void m1(){
        System.out.println("parent");
    }
}
  class C extends B{
      @Override
      void m1(){
          //super.m1();
          System.out.println("child");
      }
  }
public class A {
    public static void main(String[] args) {
        C obj = new C();
        // Reference type is Parent (B), but Object type is Child (C)
        B obj1 = new C();
        obj.m1();
        obj1.m1();

    }

}
