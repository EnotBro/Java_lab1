package com.mycorp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntContainerTest {

    @Test
    void addElemToEnd() {
        IntContainer test = new IntContainer();
        test.addElemToEnd(3);

        String actual = test.toString();
        String expected = "IntContainer{capacity=5, length=1, numberOfExtraCells=5, elements=[3, 0, 0, 0, 0]}";
        assertEquals(expected,actual);
    }

    @Test
    void addElemToEnd_NewExtraMemory() {
        IntContainer test = new IntContainer(3);
        test.addElemToEnd(3);
        test.addElemToEnd(4);
        test.addElemToEnd(5);
        test.addElemToEnd(6);

        String actual = test.toString();
        String expected = "IntContainer{capacity=7, length=4, numberOfExtraCells=3, elements=[3, 4, 5, 6, 0, 0, 0]}";
        assertEquals(expected,actual);
    }

    @Test
    void addElemAt() {
        IntContainer test = new IntContainer();
        test.addElemToEnd(3);
        test.addElemAt(5,0);

        String actual = test.toString();
        String expected = "IntContainer{capacity=5, length=2, numberOfExtraCells=5, elements=[5, 3, 0, 0, 0]}";
        assertEquals(expected,actual);
    }

    @Test
    void getElem() {
        IntContainer test = new IntContainer();
        test.addElemToEnd(3);
        test.addElemAt(5,0);

        int actual = test.getElem(1);
        int expected = 3;
        assertEquals(expected,actual);
    }

    @Test
    void deleteElemFromEnd() {
        IntContainer test = new IntContainer();
        test.addElemToEnd(3);
        test.addElemAt(5,0);
        test.deleteElemFromEnd();

        String actual = test.toString();
        String expected = "IntContainer{capacity=5, length=1, numberOfExtraCells=5, elements=[5, 3, 0, 0, 0]}";
        assertEquals(expected,actual);
    }

    @Test
    void deleteElemFromEnd_RemovingExtraCells() {
        IntContainer test = new IntContainer(2);
        test.addElemToEnd(3);
        test.addElemToEnd(4);
        test.addElemToEnd(5);
        test.addElemToEnd(6);
        test.addElemToEnd(7);
        test.addElemToEnd(8);
        test.deleteElemFromEnd();
        test.deleteElemFromEnd();
        test.deleteElemFromEnd();

        String actual = test.toString();
        String expected = "IntContainer{capacity=5, length=3, numberOfExtraCells=2, elements=[3, 4, 5, 0, 0]}";
        assertEquals(expected,actual);
    }

    @Test
    void deleteElemFrom() {
        IntContainer test = new IntContainer();
        test.addElemToEnd(3);
        test.addElemAt(5,0);
        test.deleteElemFrom(0);

        String actual = test.toString();
        String expected = "IntContainer{capacity=5, length=1, numberOfExtraCells=5, elements=[3, 3, 0, 0, 0]}";
        assertEquals(expected,actual);
    }
}