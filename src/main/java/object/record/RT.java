package object.record;

public record RT (Integer id, String name) {

    public RT {
        System.out.println("""
                ykexc
                """);
    }

    public static RT singleton() {
        return new RT(1, "yyyy");
    }
    public static void main(String[] args) {
        RT rt = new RT(1, "ykexc");
        System.out.println(rt.name() + "\n" + rt.id());
        RT singleton = RT.singleton();
        System.out.println(singleton.name());
    }
}

