package object.equalsAndhashcode;
import org.junit.Test;

import java.util.Arrays;
//class A{
//    int i, j;
//
//    A(int _i, int _j) {
//        i = _i;
//        j = _j;
//    }
//
//    public static void main(String[] args) {
//        A a = new A(1, 2);
//        A b = new A(1, 2);
//        System.out.println(a.equals(b));
//        System.out.println(a == b);
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        String a = "ABc";
//        String b = "ABc";
//        String c = "" + a;
//        System.out.print(a == b + " ");
//        System.out.print(a.equals(b) + " ");
//        System.out.println(c == a);
//        a.toLowerCase();
//        System.out.println(a.equals(b));
//    }
//}



class A {
    static {
        System.out.print("beginA ");
    }

    int i;

    A() {
    }

    A(int _i) {
        i = _i;
        System.out.print("f ");
    }

    void func1() {
        System.out.print("hello-world ");
    }
}

interface C {
    int k = 1;
    void compute();
    default void func2() {
        System.out.println(k);
    }
}


class B extends A implements C {
    static {
        System.out.print("beginB ");
    }
    int j;
    B() {}
    B(int _i, int _j) {
        super(_i);
        j = _j;
    }

    @Override
    void func1() {
        System.out.print("HelloWorld ");
    }
    @Override
    public void compute() {
        System.out.println(1 + 1);
    }
}

public class MainTest {


    static class Node {
        int x;
        Node(int _x) {
            x = _x;
        }

        @Override
        public String toString() {
            return String.valueOf(x);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1), node2 = new Node(2);
        String s1 = "abc", s2 = "def";
        Integer[] arr1 = {1, 2}, arr2 = {3, 4};
        Integer i1 = 1, i2 = 2;
        node1 = node2;
        //swap(node1, node2);
//        swap(arr1, arr2);
//        swap(i1, i2);
//        swap(s1, s2);
        System.out.println(node1 + " " + node2);
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2));
        System.out.println(i1 + " " + i2);
        System.out.println(s1 + " " + s2);
    }
    static  void swap(Node s1, Node s2){
        s1 = s2;
    }


    @Test
    public void test1() throws Exception {
        C c = () -> System.out.println(1 + 1);
        c.compute();
    }

    @Test
    public void test2() {
//        C c = new C() {
//            @Override
//            public void compute() throws Exception {
//                System.out.println(1 + 1);
//            }
//        };
//        c.compute();
    }

    @Test
    public void test3() {
        A a = new B(1, 2);
        a.func1();
    }

    @Test
    public void test4() {
        B b = new B();
        b.func2();
    }
}