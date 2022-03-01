package com.mycorp;

import java.util.Arrays;

/**
 * Class-container of integers
 */
public class IntContainer {
    /**
     * Number of all cells which can be used in container (actual memory)
     */
    private int capacity;

    /**
     * Number of elements which container contains (visible part of container from 0 to "length")
     */
    private int length;

    /**
     * Number of empty extra cells for optimization scaling of container
     */
    private int numberOfExtraCells;

    /**
     * Actual place of storing elements
     */
    private int[] elements;

    /**
     * Making an object of IntContainer class
     * @param sizeOfContainer Number of empty cells on start
     * @param countOfExtraCells Number of empty extra cells for optimization scaling of container
     */
    IntContainer(int sizeOfContainer, int countOfExtraCells)
    {
        //if (sizeOfContainer<0) throw new Exception("Size of container can't be less or equal 0");
        //if (countOfExtraCells<0) throw new Exception("Container can't have negative number of extra cells");
        length=0;
        numberOfExtraCells=countOfExtraCells;
        capacity=sizeOfContainer+numberOfExtraCells;
        elements = new int[capacity];
    }

    /**
     * Making an object of IntContainer class
     * @param sizeOfContainer Number of empty cells on start
     */
    IntContainer(int sizeOfContainer)
    {
        this(sizeOfContainer,5);
    }

    /**
     * Making an object of IntContainer class
     */
    IntContainer()
    {
        this(0,5);
    }

    /**
     * Adding a new elem to the end of container
     * @param elem  a new elem
     */
    void addElemToEnd(int elem)
    {
        if(length == capacity)
        {
            capacity+=1+numberOfExtraCells;
            int[] tmp = new int[capacity];
            System.arraycopy(elements,0,tmp,0,length);
            tmp[length-1] = elem;
            elements=tmp;
        }
        elements[length]=elem;
        length++;
    }

    /**
     * Adding new elem by index (with shifts to the right)
     * @param elem  a new elem
     * @param index a place where should be the new elem
     */
    void addElemAt(int elem, int index) //сдвиг вправо
    {
        if (index>=0 && index <=length)
        {
            if (length==capacity)
            {
                capacity+=1+numberOfExtraCells;
                int[] tmp = new int[capacity];

                System.arraycopy(elements,0,tmp,0,index);
                tmp[index]=elem;
                System.arraycopy(elements,index,tmp,index+1,length-index);

                elements=tmp;
            }
            else
            {
                for (int i=length;i>index;i--)
                {
                    elements[i]= elements[i-1];
                }
                elements[index]=elem;
            }
            length++;
        }
    }

    /**
     * Return elem from container by index
     * @param indexOfElem index of the desired elem
     * @return the elem corresponding to the index
     */
    int getElem(int indexOfElem) // здесь либо исключение, либо другую проверку
    {
        if (indexOfElem>=0 && indexOfElem<length) return elements[indexOfElem];
        else return -1;
    }

    /**
     * Deleting an elem from the end of container
     */
    void deleteElemFromEnd()
    {
        if (length!=0)
        {
            length--;
            if (capacity-length>2*numberOfExtraCells)
            {
                capacity-=numberOfExtraCells;
                int[] tmp = new int[capacity];
                System.arraycopy(elements,0,tmp,0,length);
                elements = tmp;
            }
        }
    }

    /**
     *  Deleting an elem from container by index (with a shift to the left)
     * @param index index of elem which you want to delete
     */
    void deleteElemFrom(int index)//сдвиг влево
    {
        if (index>=0 && index <length)
        {
            length--;
            if (capacity-length>2*numberOfExtraCells)
            {
                capacity-=numberOfExtraCells;
                int[] tmp = new int[capacity];

                System.arraycopy(elements,0,tmp,0,index);
                System.arraycopy(elements,index+1,tmp,index,length-index);

                elements=tmp;
            }
            else
            {
                for (int i = index; i < length; i++) {
                    elements[i] = elements[i + 1];
                }
            }
        }
    }

    /**
     * Return number of active elements of container
     * @return number of elements
     */
    public int getLength() {
        return length;
    }

    /**
     * Representation of service information about an object in the form of a string
     * @return a String with information about an object
     *         (capacity, length, numberOfExtraCells, elements)
     */
    @Override
    public String toString() {
        return "IntContainer{" +
                "capacity=" + capacity +
                ", length=" + length +
                ", numberOfExtraCells=" + numberOfExtraCells +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

}
