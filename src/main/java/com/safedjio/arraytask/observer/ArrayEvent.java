package com.safedjio.arraytask.observer;

import com.safedjio.arraytask.entity.CustomArray;


public class ArrayEvent {
    private final CustomArray array;

    public ArrayEvent(CustomArray array){
        this.array = array;
    }

    public CustomArray getArray(){
        return array;
    }
}