package ru.astondevs.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.astondevs.sort.QuickSort.quickSort;

class QuickSortTest {

    @Test
    void quickSort_whenSortArray_thenReturnSortedArray() {
        Integer[] expected = new Integer[100];
        Integer[] actual = new Integer[100];
        for(int i = 0, j = 99; i < 100; i++, j--) {
            actual[j] = j;
            expected[i] = i;
        }
        quickSort(actual, 0, actual.length - 1);
        assertArrayEquals(expected, actual);
    }

}