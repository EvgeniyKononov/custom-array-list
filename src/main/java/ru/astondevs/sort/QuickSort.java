package ru.astondevs.sort;

/**
 * The utility class for making sorting using Quick Sort algorithm.
 */

public class QuickSort {
    /**
     * The static method for sorting elements by Quick Sort algorithm.
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
}
