package com.mycorp;

import java.util.Arrays;

public class IntContainer {
    private int capacity;
    private int length;
    private int numberOfExtraCells;
    private int[] elements;

    IntContainer(int sizeOfContainer, int countOfExtraCells)
    {
        //if (sizeOfContainer<0) throw new Exception("Size of container can't be less or equal 0");
        //if (countOfExtraCells<0) throw new Exception("Container can't have negative number of extra cells");
        length=sizeOfContainer;
        numberOfExtraCells=countOfExtraCells;
        capacity=length+numberOfExtraCells;
        elements = new int[capacity];
    }

    IntContainer(int sizeOfContainer)
    {
        this(sizeOfContainer,5);
    }

    IntContainer()
    {
        this(0,5);
    }

    void add(int elem)
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

    void addAt(int elem, int index) //сдвиг вправо
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

    int getElem(int indexOfElem) // здесь либо исключение, либо другую проверку
    {
        if (indexOfElem>=0 && indexOfElem<length) return elements[indexOfElem];
        else return -1;
    }

    void delete()
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

    void deleteFrom(int index)
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

    public int getLength() {
        return length;
    }

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
