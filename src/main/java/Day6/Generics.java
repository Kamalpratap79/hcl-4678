package Day6;

public class Generics<T,U> {

    T ob1;
    U ob2;
    Generics(T ob1,U ob2){
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
    void m1(){
        System.out.println(ob1);
        System.out.println(ob2);
    }

    public <E> void prtArray(E[] elements){
        for(E e : elements){
            System.out.print(e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Generics<Integer , String> obj = new Generics<Integer,String>(5,"Vardhan");
        obj.m1();
        
        Integer[] ar = {1,3,4,5};
        String[] st = {"peter","parker"};

        obj.prtArray(ar);
        obj.prtArray(st);
    }
}
