package com.safedjio.arraytask.repository;
import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.observer.Impl.ArrayObserverImpl;
import com.safedjio.arraytask.specification.CustomSpecification;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomRepository {
    private static CustomRepository instance;

    private List<CustomArray> arrays = new ArrayList<>();

    private CustomRepository() {
    }

    public static CustomRepository getInstance() {
        if (instance == null) {
            instance = new CustomRepository();
        }
        return instance;
    }

    public void add(CustomArray array) {
        array.setObserver(new ArrayObserverImpl());
        arrays.add(array);
    }

    public void remove(CustomArray array) {
        arrays.remove(array);
    }

    public List<CustomArray> getAll(){
        return new ArrayList<>(arrays);
    }

    public List<CustomArray> query(CustomSpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray array : arrays) {
            if (specification.specify(array)) {
                result.add(array);
            }
        }
        return result;
    }

    public void sort(Comparator<CustomArray> comparator) {
        arrays.sort(comparator);
    }

}