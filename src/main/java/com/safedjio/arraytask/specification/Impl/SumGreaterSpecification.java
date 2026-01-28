package com.safedjio.arraytask.specification.Impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.entity.CustomArrayParameters;
import com.safedjio.arraytask.specification.CustomSpecification;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;

public class SumGreaterSpecification implements CustomSpecification{
    private final double minSum;

    public SumGreaterSpecification(double minSum) {
        this.minSum = minSum;
    }

    @Override
    public boolean specify(CustomArray array) {
        double sum = ArrayWarehouse.getInstance()
                .get(array.getId())
                .getSum();

        return sum > minSum;
    }
}