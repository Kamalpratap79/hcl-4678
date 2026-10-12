package Day5.Lamda;

import Day2.Cons;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaFunction  {

    public static void main(String[] args) {
        Calculator c3 = new Calculator() {
            @Override
            public int Calculate(int a, int b) {
                return a+b;
            }
        };
        Calculator c1 = (a,b) -> (a+b);
        System.out.println((c1.Calculate(3,4)));
        Calculator c2 = (a,b) -> (a*b);
        System.out.println(c2.Calculate(3,4));

        Predicate<Integer> p = (n) -> (n%2 == 0);
        System.out.println(p.test(9));

        Consumer<Integer> c = a -> System.out.println(9);
        c.accept(4);

        Function<Integer,Integer> fp = a -> (a*a);
        System.out.println(fp.apply(5));

        Supplier<Integer> sp = () ->(8);
        System.out.println(sp.get());


    }
}
