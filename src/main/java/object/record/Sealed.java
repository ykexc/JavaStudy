package object.record;

public abstract sealed class Sealed permits YY, ZZ {

     String name;
    Sealed(String _name) {
        name = _name;
    }

    Sealed rotate(Sealed shape, String name) {  //模式匹配
        return switch (shape) {
            case LL l -> l;
            case UU u -> u;
            default -> new ZZ(name);
        };
    }



}
