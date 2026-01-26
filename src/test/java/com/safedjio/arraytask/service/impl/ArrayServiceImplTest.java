package com.safedjio.arraytask.service.impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.exception.ArrayException;
import com.safedjio.arraytask.service.ArrayService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceImplTest {

    private final ArrayService service = new ArrayServiceImpl();

    @Test
    void findMin_PositiveNumbers_CorrectValue() throws ArrayException {
        CustomArray customArray = new CustomArray(new int[]{10, 2, 5});

        int actualMin = service.findMin(customArray);

        assertEquals(2, actualMin, "Minimum should be 2");
    }

    @Test
    void findMax_NegativeNumbers_CorrectValue() throws ArrayException {

        CustomArray customArray = new CustomArray(new int[]{-5, -1, -10});

        int actualMax = service.findMax(customArray);

        assertEquals(-1, actualMax);
    }

    @Test
    void calculateSum_MixedNumbers_CorrectSum() throws ArrayException {

        CustomArray customArray = new CustomArray(new int[]{1, -1, 5});

        int actualSum = service.calculateSum(customArray);

        assertEquals(5, actualSum);
    }

    @Test
    void findMin_EmptyArray_ThrowException() {

        CustomArray emptyArray = new CustomArray(new int[]{});

        assertThrows(ArrayException.class, () -> service.findMin(emptyArray));
    }

    @Test
    void bubbleSort_UnsortedArray_SortedArray() throws ArrayException {

        CustomArray customArray = new CustomArray(new int[]{5, 1, 4});

        CustomArray expectedArray = new CustomArray(new int[]{1, 4, 5});

        service.bubbleSort(customArray);

        assertEquals(expectedArray, customArray);
    }

    @Test
    void selectionSort_UnsortedArray_SortedArray() throws ArrayException {
        CustomArray customArray = new CustomArray(new int[]{10, 2, 8});
        CustomArray expectedArray = new CustomArray(new int[]{2, 8, 10});

        service.selectionSort(customArray);

        assertEquals(expectedArray, customArray);
    }

    @Test
    void bubbleSort_NullArray_ThrowException() {
        assertThrows(ArrayException.class, () -> service.bubbleSort(null));
    }
}