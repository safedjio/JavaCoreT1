package com.safedjio.arraytask.observer.Impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.entity.CustomArrayParameters;
import com.safedjio.arraytask.exception.ArrayException;
import com.safedjio.arraytask.observer.ArrayEvent;
import com.safedjio.arraytask.observer.ArrayObserver;
import com.safedjio.arraytask.service.ArrayService;
import com.safedjio.arraytask.service.impl.ArrayServiceImpl;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;

public class ArrayObserverImpl implements ArrayObserver {
    @Override
    public void update(ArrayEvent event) {
        CustomArray array = event.getArray();

        ArrayService service = new ArrayServiceImpl();
        int sum = 0,min = 0,max = 0; double avg = 0;
        try {
            sum = service.calculateSum(array);
            max = service.findMax(array);
            min = service.findMin(array);
            avg = service.findAverage(array);
        } catch (ArrayException e) {
            throw new RuntimeException(e);
        }

        CustomArrayParameters stats = new CustomArrayParameters(sum, min, max, avg );

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        warehouse.put(array.getId(), stats);

        System.out.println("Warehouse updated for ID: " + array.getId());
    }
}