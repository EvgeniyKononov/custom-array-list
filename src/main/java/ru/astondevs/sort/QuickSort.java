package ru.astondevs.sort;

import ru.astondevs.arraylist.ArrayList;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ListIterator;

public class QuickSort<T> {

    public static <T extends Comparable<T>> T[] sort(ArrayList<T> list) {
        int size = list.size();
        // T[] array = (T[]) Array.newInstance(list.getClass().getComponentType(), size);
     /*   T[] source = list.getAll();
        T[] array = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = source[i];
        }*/
        Object[] source = list.getAll();
        T[] array = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = (T) source[i];

        }
        return quickSort(array, 0, size-1);
    }

    public static <T extends Comparable<T>> T[] quickSort(T[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return sortArr;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        T border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            // while (sortArr[i] < border) i++;
            while (sortArr[i].compareTo(border) < 0) i++;
            // while (sortArr[j] > border) j--;
            while (sortArr[j].compareTo(border) > 0) j--;
            if (i <= j) {
                T swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }
        return sortArr;
    }

}
