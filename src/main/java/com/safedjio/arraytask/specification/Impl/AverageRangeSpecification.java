package com.safedjio.arraytask.specification.Impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.specification.CustomSpecification;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;

public class AverageRangeSpecification implements CustomSpecification {
    private final double min;
    private final double max;

    public AverageRangeSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray array) {
        double avg = ArrayWarehouse.getInstance()
                .get(array.getId())
                .getAverage();

        return avg >= min && avg <= max;
    }
}