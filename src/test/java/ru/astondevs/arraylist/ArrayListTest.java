package ru.astondevs.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.astondevs.exception.OutOfIndexCustomException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    void add_whenAddingNewElements_thenListContainsAddedElements() {
        list.add(10);
        assertEquals(11, list.size());
        for (int i = 0; i < 11; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void add_whenAddingMoreElementsThanInitialCapacityOfList_thenListExpandCapacityAutomatically() {
        for (int i = 10; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void addByIndex_whenAddingNewElementsByIndex_thenNewElementPlacedByIndexAndOldElementsShiftedToTheRight() {
        list.add(100, 5);
        assertEquals(11, list.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.get(i));
        }
        assertEquals(100, list.get(5));
        for (int i = 6; i < 11; i++) {
            assertEquals(i - 1, list.get(i));
        }
    }

    @Test
    void addByIndex_whenAddingNewElementsByIndexMoreThanCurrentSize_thenThrowingOutOdIndexException() {
        assertThrows(OutOfIndexCustomException.class, () -> list.add(100, 100));
    }

    @Test
    void replace_whenReplaceElement_thenNewElementInListInsteadOfOldOneAndSizeWithoutChanges() {
        list.replace(100, 5);
        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.get(i));
        }
        assertEquals(100, list.get(5));
        for (int i = 6; i < 10; i++) {
            assertEquals(i, list.get(i));
        }
        assertEquals(10, list.size());
    }

    @Test
    void replace_whenReplaceElementsByIndexMoreThanCurrentSize_thenThrowingOutOdIndexException() {
        assertThrows(OutOfIndexCustomException.class, () -> list.replace(100, 100));
    }

    @Test
    void get_whenGettingElementByIndex_thenReturnElement() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void get_whenGettingElementByIndexMoreThanCurrentSize_thenThrowingOutOdIndexException() {
        assertThrows(OutOfIndexCustomException.class, () -> list.get(10));
    }

    @Test
    void delete_whenDeletingElement_thenElementsAfterDeletedElementsShiftsOnTheLeftAndSizeDecreased() {
        list.delete(5);
        assertEquals(9, list.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.get(i));
        }
        for (int i = 5; i < 9; i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void delete_whenDeletingElementByIndexMoreThanCurrentSize_thenThrowingOutOdIndexException() {
        assertThrows(OutOfIndexCustomException.class, () -> list.delete(10));
    }

    @Test
    void clear_whenClearList_whenDeletingAllElementsFromListAndSizeIsZero() {
        list.clear();
        assertEquals(0, list.size());
        Integer[] expected = {};
        assertArrayEquals(expected, list.getAll());
    }

    @Test
    void getAll_whenGettingAllElementsOfList_ReturnArrayOfListElements() {
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, list.getAll());
    }

    @Test
    void size_whenGettingSizeOfList_TheReturnQuantityOfListElements() {
        int expected = 10;
        assertEquals(expected, list.size());
    }

    @Test
    void sort_whenSortList_thenReturnListWithSortedElements() {
        list.clear();
        ArrayList<Integer> expected = new ArrayList<>();
        for(int i = 0, j = 99; i < 100; i++, j--) {
            list.add(j);
            expected.add(i);
        }
        assertEquals(expected, list.sort());
    }
}