package function;


interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) {
        System.out.println("hello" + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;
        c.call("call()");

        c = MethodReferences::hello;//普通类调静态方法, 只要方法签名相同，就可以进行方法的传递?
        c.call("""
                bob""");
        c = new Description("valuable")::help;//静态内部类调用非静态方法
        c.call("information");

        c = Helper::assist;//静态内部类调静态方法
        c.call("Help!");
    }

}
