package com.safedjio.arraytask.repository;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.entity.CustomArrayParameters;
import com.safedjio.arraytask.specification.Impl.IdSpecification;
import com.safedjio.arraytask.specification.Impl.SumGreaterSpecification;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositorySearchTest {

    @BeforeEach
    void setUp() {
        CustomRepository repo = CustomRepository.getInstance();
        int[] arr1 = {10, 10, 10};
        int[] arr2 = {1, 2, 3};
        CustomArray a1 = new CustomArray(arr1);
        CustomArray a2 = new CustomArray(arr2);

        repo.add(a1);
        repo.add(a2);

        ArrayWarehouse.getInstance().put(1L, new CustomArrayParameters(30, 10, 10, 10.0));
        ArrayWarehouse.getInstance().put(2L, new CustomArrayParameters(6, 3, 1, 2.0));
    }

    @Test
    void testFindById() {
        List<CustomArray> result = CustomRepository.getInstance().query(new IdSpecification(1L));
        assertAll(
                ()->assertEquals(1, result.size()),
                ()->assertEquals(1L, result.get(0).getId())
        );
    }

    @Test
    void testFindBySumGreater() {
        List<CustomArray> result = CustomRepository.getInstance().query(new SumGreaterSpecification(10));
        assertAll(
        ()->assertEquals(1, result.size()),
        ()->assertEquals(30, ArrayWarehouse.getInstance().get(result.get(0).getId()).getSum())
        );
    }
}