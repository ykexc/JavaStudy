package object;


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Int2 implements Cloneable {
    private int i;

    Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Int2 clone() {
        try {
            return (Int2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

//继承不会移除可克隆性, 只要有一个类实现的克隆操作，那么这个类之下的所有子类都具备克隆能力
class Int3 extends Int2 {
    public int j;
    Int3(int i, int jj) {
        super(i);
        j = jj;
    }

    @Override
    public String toString() {
        return super.toString() + " " + j;
    }
}




//深拷贝ArrayList
public class AddingClone {


    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = x.clone();
        x2.increment();
        System.out.println("x = " + x + " " + "x2 = "  + x2);
        //继承出来的任何事务也是可以克隆的
        Int3 x3 = new Int3(7, 8);
        Int3 x4 = (Int3) x3.clone();
        System.out.println("x4 = " + x4);
        ArrayList<Int2> v = IntStream.range(0, 10).mapToObj(Int2::new).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("v: " + v);

        ArrayList<Int2> v2 = (ArrayList<Int2>) v.clone();
        IntStream.range(0, v.size()).forEach(i -> v2.set(i, v.get(i).clone()));
        //对v2的所有元素进行累加
        v2.forEach(Int2::increment);
        System.out.println("v2: " + v2);
        System.out.println("v: " + v);
    }
}
