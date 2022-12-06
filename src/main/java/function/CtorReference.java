package function;

/**
 * 构造方法引用
 */
public class CtorReference {

    public static void main(String[] args) {
        NoArgs noArgs = Dog::new;
        OneArgs oneArgs = Dog::new;
    }

}

class Dog {
    String name;
    String species;

    Dog() {
        name = "xiugou";
    }

    Dog(String species) {
        this.species = species;
    }
}

interface NoArgs {
    Dog noArgs();
}

interface OneArgs {
    Dog oneArgs(String species);
}
