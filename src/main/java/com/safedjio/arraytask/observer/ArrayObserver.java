package com.safedjio.arraytask.observer;

import com.safedjio.arraytask.exception.ArrayException;

public interface ArrayObserver {
    void update(ArrayEvent event);
}