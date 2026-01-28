package com.safedjio.arraytask.specification.Impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.specification.CustomSpecification;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;

public class MinSpecification implements CustomSpecification {
    private final int min;

    public MinSpecification(int min) {
        this.min = min;
    }

    @Override
    public boolean specify(CustomArray array) {
        int currentMin = ArrayWarehouse.getInstance()
                .get(array.getId())
                .getMin();

        return currentMin == min;
    }
}