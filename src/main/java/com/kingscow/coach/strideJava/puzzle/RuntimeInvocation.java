package com.kingscow.coach.strideJava.puzzle;

class Base {
    protected int i;

    Base() {
        add(1);
    }

    int add(int v) {
        System.out.print("Base: "+i+" v:"+v);
        i += v;
        System.out.println(" -> "+i);
        return i;
    }

}

class Extension extends Base {
    Extension() {
        add(1);
    }

    int add(int v) {
        System.out.print("Extension: i:"+i+" v:"+v);
        i += v*2;
        System.out.println(" -> i:"+i);
        return i;
    }
}

public class RuntimeInvocation {
    public static void main(String[] args) {
        System.out.println(" " + bogo(new Extension()));
    }

    static int bogo(Base b) {
        return b.add(8);
    }
}
