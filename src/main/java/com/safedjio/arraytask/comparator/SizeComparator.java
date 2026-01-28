package com.safedjio.arraytask.comparator;

import com.safedjio.arraytask.entity.CustomArray;

import java.util.Comparator;

public class SizeComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Integer.compare(o1.getArray().length, o2.getArray().length);
    }
}