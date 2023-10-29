package ru.astondevs;

import ru.astondevs.arraylist.ArrayList;

import java.util.Arrays;

import static ru.astondevs.sort.QuickSort.quickSort;
import static ru.astondevs.sort.QuickSort.sort;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3,2);
        integerList.add(4);
      //  integerList.add(5,6); // Ошибка - индекс вставки больше, чем последний индекс.
        System.out.println(integerList);
        System.out.println(integerList.get(4));
       // System.out.println(integerList.get(5)); // Ошибка - индекс вставки больше, чем последний индекс.
        integerList.delete(1);
        System.out.println(integerList);
        integerList.delete(3);
        System.out.println(integerList);
        integerList.replace(1,1);
        System.out.println(integerList);
        //integerList.clear();
        //System.out.println(quickSort(integerList), 0, 10);
        integerList.replace(10,1);
        System.out.println(integerList);
        System.out.println(Arrays.toString(sort(integerList)));
    }
}