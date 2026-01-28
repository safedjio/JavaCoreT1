package com.safedjio.arraytask.comparator;

import com.safedjio.arraytask.entity.CustomArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparatorTest {

    @Test
    void testSortById() {
        List<CustomArray> list = new ArrayList<>();
        int[] arr1 = {1};
        int[] arr2 = {1, 2};
        list.add(new CustomArray(arr1));
        list.add(new CustomArray(arr2));

        list.sort(new IdComparator());

        assertEquals(1L, list.get(0).getId());
        assertEquals(2L, list.get(1).getId());
    }

    @Test
    void testSortBySize() {
        List<CustomArray> list = new ArrayList<>();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {9};
        list.add(new CustomArray(arr1));
        list.add(new CustomArray(arr2));

        list.sort(new SizeComparator());

        assertEquals(1, list.get(0).getArray().length);
        assertEquals(3, list.get(1).getArray().length);
    }
}