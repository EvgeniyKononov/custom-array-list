package ru.astondevs.sort;

import java.util.Comparator;

/**
 * The utility class for making sorting using Quick Sort algorithm.
 */

public class QuickSort {

    /**
     * The static method for sorting Comparable elements by Quick Sort algorithm.
     *
     * @param array The array which need to sort.
     * @param left  Index of first element of array.
     * @param right Index of last element of array.
     * @param <T>   Elements of array which extends Comparable type.
     * @return The array of sorted elements.
     */
    public static <T extends Comparable<T>> T[] quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot, right);
        }
        return array;
    }

    /**
     * The static method for sorting elements by Quick Sort algorithm using comparator.
     *
     * @param array The array which need to sort.
     * @param left  Index of first element of array.
     * @param right Index of last element of array.
     * @param c Comparator for comparing of objects.
     * @param <T>   Elements of array.
     * @return The array of sorted elements.
     */
    public static <T> T[] quickSort(T[] array, int left, int right, Comparator c) {
        if (left < right) {
            int pivot = partition(array, left, right, c);
            quickSort(array, left, pivot - 1, c);
            quickSort(array, pivot, right, c);
        }
        return array;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];
        while (right >= left) {
            while (array[left].compareTo(pivot) < 0) {
                left++;
            }
            while (pivot.compareTo(array[right]) < 0) {
                right--;
            }
            if (right >= left) {
                T swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                ++left;
                --right;
            }
        }
        return left;
    }

    private static <T> int partition(T[] array, int left, int right, Comparator c) {
        int mid = (left + right) / 2;
        T pivot = array[mid];
        while (right >= left) {
            while (c.compare(array[left], pivot) < 0) {
                left++;
            }
            while (c.compare(array[right], pivot) > 0) {
                right--;
            }
            if (right >= left) {
                T swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                ++left;
                --right;
            }
        }
        return left;
    }
}
