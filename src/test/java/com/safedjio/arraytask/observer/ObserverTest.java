package com.safedjio.arraytask.observer;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.entity.CustomArrayParameters;
import com.safedjio.arraytask.observer.Impl.ArrayObserverImpl;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObserverTest {

    @Test
    void testObserverUpdatesWarehouse() {
        int[] arr = {1,2,3};
        CustomArray array = new CustomArray(arr);
        array.setObserver(new ArrayObserverImpl());

        array.setElement(0, 5);

        array.setElement(0, 10);

        CustomArrayParameters stats = ArrayWarehouse.getInstance().get(array.getId());

        assertNotNull(stats, "Статистика должна существовать");
        assertEquals(15, stats.getSum(), "Сумма должна обновиться до 15");
        assertEquals(10, stats.getMax(), "Максимум должен стать 10");
        assertEquals(5.0, stats.getAverage(), "Среднее должно стать 5.0");
    }
}