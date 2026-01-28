package com.safedjio.arraytask.specification.Impl;
import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.specification.CustomSpecification;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;

public class LessThanMaxSpecification implements CustomSpecification {
    private final int max;

    public LessThanMaxSpecification(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray array) {
        int currentMax = ArrayWarehouse.getInstance()
                .get(array.getId())
                .getMax();

        return currentMax > max;
    }
}