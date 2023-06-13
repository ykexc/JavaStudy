package object.record;

public non-sealed class YY extends Sealed{
    YY(String _name) {
        super(_name);
    }
}


sealed class ZZ extends Sealed permits UU {

    ZZ(String _name) {
        super(_name);
    }
}

final class UU extends ZZ implements OO {

    UU(String _name) {
        super(_name);
    }


    @Override
    public void fun() {

    }
}

class LL extends YY {

    LL(String _name) {
        super(_name);
    }
}

sealed interface OO permits UU, TT {
    void fun();
}

record TT () implements OO{

    @Override
    public void fun() {
        System.out.println("TT");
    }
}

