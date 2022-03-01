package com.mycorp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        IntContainer Cont = new IntContainer();
        System.out.println(Cont.getLength());
        Cont.addElemToEnd(-2);
        System.out.println(Cont.getLength());
        System.out.println(Cont.getElem(1));
        System.out.println(Cont.toString());

        Cont.addElemAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addElemAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addElemAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addElemAt(-3,2);
        System.out.println(Cont.toString());

        Cont.addElemAt(5,2);
        System.out.println(Cont.toString());

        Cont.deleteElemFromEnd();
        System.out.println(Cont.toString());

        Cont.deleteElemFrom(2);
        System.out.println(Cont.toString());

        Cont.deleteElemFromEnd();
        System.out.println(Cont.toString());

        Cont.addElemToEnd(45);
        System.out.println(Cont.toString());
    }
}
