package com.safedjio.arraytask.comparator;
import com.safedjio.arraytask.entity.CustomArray;
import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2){
        return Long.compare(o1.getId(), o2.getId());
    }
}
