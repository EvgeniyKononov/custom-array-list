package ru.astondevs.arraylist;

import ru.astondevs.exception.OutOfIndexCustomException;
import ru.astondevs.sort.QuickSort;

import java.util.Arrays;

import static ru.astondevs.sort.QuickSort.quickSort;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INCREASING_FACTOR = 2;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int lastIndexElement = -1;

    public void add(T e) {
        checkCapacity();
        lastIndexElement++;
        array[lastIndexElement] = e;
    }

    public void add(T e, int index) {
        checkCapacity();
        checkIndex(index);
        lastIndexElement++;
        Object temp;
        for (int i = index; i <= lastIndexElement; i++) {
            temp = array[i];
            array[i] = e;
            e = (T) temp;
        }
    }

    public void replace(T e, int index) {
        checkIndex(index);
        array[index] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public void delete(int index) {
        checkIndex(index);
        for (int i = index; i <= lastIndexElement; i++) {
            array[i] = array[i + 1];
        }
        lastIndexElement--;
    }

    public void clear() {
        for (int i = 0; i <= lastIndexElement; i++) {
            array[i] = null;
        }
        lastIndexElement = -1;
    }

    public T[] getAll(){
        Object[] elementsOfArray = new Object[lastIndexElement + 1];
        for (int i = 0; i <= lastIndexElement; i++) {
            elementsOfArray[i] = array[i];
        }
        return (T[]) elementsOfArray;
    }

    public int size(){
        return lastIndexElement + 1;
    }


   /*
    public T[] sort() {
       // T[] elementsOfArray = fillArray();
       // array = quickSort(elementsOfArray, 0, elementsOfArray.length - 1);
        return QuickSort.sort(getAll());
    }
/*
    private T[] fillArray() {
        Object[] elementsOfArray = new Object[lastIndexElement + 1];
        for (int i = 0; i <= lastIndexElement; i++) {
            elementsOfArray[i] = array[i];
        }
        return (T[]) elementsOfArray;
    }
/*
    private <T extends Comparable<T>> T[] quickSort(T[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return sortArr;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        T border = (T) sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            // while (sortArr[i] < border) i++;
            while (sortArr[i].compareTo(border) < 0) i++;
            // while (sortArr[j] > border) j--;
            while (sortArr[j].compareTo(border) > 0) j--;
            if (i <= j) {
                T swap = (T) sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
        return sortArr;
    }
*/
    private void checkIndex(int index) {
        if (index > lastIndexElement) {
            throw new OutOfIndexCustomException("Provided index is more than last element in the list. " +
                    "The last element has index: " + lastIndexElement);
        }
    }

    private void checkCapacity() {
        if (array.length - 1 == lastIndexElement) {
            array = increaseCapacity();
        }
    }

    private Object[] increaseCapacity() {
        Object[] newArray = new Object[(array.length - 1) * DEFAULT_INCREASING_FACTOR];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
