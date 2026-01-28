package com.safedjio.arraytask.specification.Impl;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.specification.CustomSpecification;

public class IdSpecification implements CustomSpecification {
    private final Long wantedId;

    public IdSpecification(Long wantedId){
        this.wantedId = wantedId;
    }

    @Override
    public boolean specify(CustomArray customArray){
        return customArray.getId() == wantedId;
    }

}
