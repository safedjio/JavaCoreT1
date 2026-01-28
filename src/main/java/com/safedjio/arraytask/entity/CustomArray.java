package com.safedjio.arraytask.entity;
import com.safedjio.arraytask.observer.ArrayEvent;
import com.safedjio.arraytask.observer.ArrayObserver;
import com.safedjio.arraytask.service.IdGenerator;

import java.util.Arrays;

public class CustomArray {
    private final long id;
    private int[] array;
    private ArrayObserver observer;
    private final int size;

    public CustomArray( int[] array){
        this.id = IdGenerator.generateId();
        this.array = array.clone();
        this.size = array.length;
    }

    public int[] getArray() {
        return array.clone();
    }

    public long getId() { return id; }

    public void setArray(int[] array) {
        this.array = array.clone();
        notifyObserver();
    }

    public void setArrayElement(int index, int value) {
        this.array[index] = value;
        notifyObserver();
    }

    public int getArrayElement(int index) {
        return array[index];
    }

    public void setObserver(ArrayObserver observer) {
        this.observer = observer;
    }

    private void notifyObserver() {
        if (observer != null) {
            ArrayEvent event = new ArrayEvent(this);
            observer.update(event);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;
        CustomArray that = (CustomArray) obj;
       return  Arrays.equals(array, that.array);

    }

    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("CustomArray{ array=[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}
