package com.safedjio.arraytask.validator;
import com.safedjio.arraytask.entity.CustomArray;

public class ArrayValidator {
    public static boolean isValid (CustomArray customArray){
        if (customArray == null){
            return false;
        }

        int[] array = customArray.getArray();
        return array != null && array.length > 0;
    }
}