package com.safedjio.arraytask.comparator;
import com.safedjio.arraytask.entity.CustomArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int[] array1 = o1.getArray();
        int[] array2 = o2.getArray();
        return Integer.compare(array1[0], array2[0]);
    }
}