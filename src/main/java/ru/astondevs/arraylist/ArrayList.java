package ru.astondevs.arraylist;

import ru.astondevs.exception.OutOfIndexCustomException;

import java.util.Arrays;
import java.util.Comparator;

import static ru.astondevs.sort.QuickSort.quickSort;

/**
 * Class ArrayList is custom ArrayList which realize the main methods from ArrayList Collection Framework.
 *
 * @param <T> ArrayList can contain any elements of Object type.
 */
public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INCREASING_FACTOR = 2;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int lastIndexElement = -1;

    /**
     * Method for adding the new element to ArrayList to the end of the list.
     *
     * @param e element which need to add to ArrayList.
     */
    public void add(T e) {
        checkCapacity();
        lastIndexElement++;
        array[lastIndexElement] = e;
    }

    /**
     * Method for insert the new element to ArrayList by exact index.
     *
     * @param e     element which need to insert to ArrayList.
     * @param index index where need to insert the new element.
     */
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

    /**
     * Method for replacing the element by new element in ArrayList by exact index.
     *
     * @param e     element which need to add to ArrayList by another one.
     * @param index index of element which must be replaced.
     */
    public void replace(T e, int index) {
        checkIndex(index);
        array[index] = e;
    }

    /**
     * Method for getting element by index.
     *
     * @param index index of getting element.
     * @return element by provided index
     */
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Method for deleting element by index.
     *
     * @param index index of deleting element.
     */

    public void delete(int index) {
        checkIndex(index);
        for (int i = index; i < lastIndexElement; i++) {
            array[i] = array[i + 1];
        }
        lastIndexElement--;
    }

    /**
     * Method for deleting all elements from ArrayList.
     */
    public void clear() {
        for (int i = 0; i <= lastIndexElement; i++) {
            array[i] = null;
        }
        lastIndexElement = -1;
    }

    /**
     * Method for getting all elements of ArrayList.
     *
     * @return The result returns as array of elements.
     */
    public T[] getAll() {
        Object[] elementsOfArray = new Object[lastIndexElement + 1];
        for (int i = 0; i <= lastIndexElement; i++) {
            elementsOfArray[i] = array[i];
        }
        return (T[]) elementsOfArray;
    }

    /**
     * Method for getting the current size of ArrayList, which means the quantity of added elements in the list,
     * and not current size of array in ArrayList.
     *
     * @return The quantity of added elements in the list.
     */
    public int size() {
        return lastIndexElement + 1;
    }

    /**
     * Method for sorting of elements ArrayList of Comparable type.
     *
     * @return ArrayList with sorted elements.
     */
    public ArrayList<T> sort() {
        Comparable[] sortedArray = getSortedArray();
        for (int i = 0; i < sortedArray.length; i++) {
            array[i] = sortedArray[i];
        }
        return this;
    }

    /**
     * Method for sorting of ArrayList elements using Comparator.
     *
     * @return ArrayList with sorted elements.
     */
    public ArrayList<T> sort(Comparator<T> c) {
        T[] sortedArray = quickSort((T[])array, 0, this.size() - 1, c);
        for (int i = 0; i < sortedArray.length; i++) {
            array[i] = sortedArray[i];
        }
        return this;
    }

    private Comparable[] getSortedArray() {
        int size = size();
        Object[] source = getAll();
        T[] array = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = (T) source[i];

        }
        return quickSort((Comparable[]) array, 0, size - 1);
    }

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
        return Arrays.toString(getAll());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return Arrays.equals(array, arrayList.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
