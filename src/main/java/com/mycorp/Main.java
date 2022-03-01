package com.mycorp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        IntContainer Cont = new IntContainer();
        System.out.println(Cont.getLength());
        Cont.add(-2);
        Cont.add(-7);
        System.out.println(Cont.getLength());
        System.out.println(Cont.getElem(1));
        System.out.println(Cont.toString());

        Cont.addAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addAt(5,2);
        System.out.println(Cont.toString());

        Cont.delete();
        System.out.println(Cont.toString());

        Cont.deleteFrom(2);
        System.out.println(Cont.toString());

        Cont.delete();
        System.out.println(Cont.toString());

        Cont.add(45);
        System.out.println(Cont.toString());
    }
}
