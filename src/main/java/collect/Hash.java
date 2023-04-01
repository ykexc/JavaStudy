package collect;

import java.util.*;
import java.util.function.Function;

public class Hash {

    static <T> void fill(Set<T> set, Function<Integer, T> type) {
        for (int i = 10; i >= 5; i--) {
            set.add(type.apply(i));
        }
        for (int i = 0; i < 5; i++) {
            set.add(type.apply(i));
        }
    }

    static <T> void test(Set<T> set, Function<Integer, T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        //正常工作
        test(new HashSet<>(), Two::new);
        test(new LinkedHashSet<>(), Two::new);
        test(new TreeSet<>(), Three::new);
        //非正常
        test(new HashSet<>(), One::new);
        test(new HashSet<>(), Three::new);
        test(new LinkedHashSet<>(), One::new);
        test(new LinkedHashSet<>(), Three::new);
        //抛异常
        try {
            test(new TreeSet<>(), One::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), Two::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), Four::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


class One {
    Integer x;

    One(Integer _x) {
        x = _x;
    }

    @Override
    public boolean equals(Object obj) {
        One one = (One) obj;
        return one.x.equals(this.x);
    }

    @Override
    public String toString() {
        return Integer.toString(x);
    }
}

class Two extends One {  //重写hashCode

    Two(Integer _x) {
        super(_x);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x);
    }
}

class Three extends One implements Comparable<Three> {  //实现compareTo方法
    Three(Integer _x) {
        super(_x);
    }

    @Override
    public int compareTo(Three o) {
        return Integer.compare(o.x, this.x);
    }
}

class Four extends One implements Comparator<Four> {

    Four(Integer _x) {
        super(_x);
    }

    @Override
    public int compare(Four o1, Four o2) {
        return Integer.compare(o2.x, o1.x);
    }
}
