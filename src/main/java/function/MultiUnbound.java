package function;

/**
 * 有多个参数未绑定方法，只要遵循第一个参数是this这种模式
 */

class Type {
    void two(int i, double d) {
    }

    static void three(int i, double d, String s) {
    }

    void four(int i, double d, String s, char c) {
    }
}

interface TwoArgs {
    void call2(Type athis, int i, double d);
}

interface ThreeArgs {
    void call3(int i, double d, String s);
}

interface FourArgs {
    void call4(Type athis, int i, double d, String s, char c);
}


public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = Type::two;
        ThreeArgs threeArgs = Type::three;
        FourArgs fourArgs = Type::four;
        Type type = new Type();
        twoArgs.call2(type, 1, 1.00);
        threeArgs.call3(0, 0, "h");
        fourArgs.call4(type, 1, 1.000, "w", 'L');
    }
}
