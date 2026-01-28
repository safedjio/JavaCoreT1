package com.safedjio.arraytask.service;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.exception.ArrayException;

public interface ArrayService {
    int findMin(CustomArray customArray) throws ArrayException;
    int findMax(CustomArray customArray) throws ArrayException;
    double findAverage(CustomArray customArray) throws ArrayException;
    int calculateSum(CustomArray customArray) throws ArrayException;
    void bubbleSort(CustomArray customArray) throws ArrayException;
    void selectionSort(CustomArray customArray) throws ArrayException;
}
