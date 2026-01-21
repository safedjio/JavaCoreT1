package java.first.task.service;

import java.first.task.entity.CustomArray;
import java.first.task.exception.ArrayException;

public interface ArrayService {
    int findMin(CustomArray customArray) throws ArrayException;
    int findMax(CustomArray customArray) throws ArrayException;
    int calculateSum(CustomArray customArray) throws ArrayException;
    void bubbleSort(CustomArray customArray) throws ArrayException;
    void selectionSort(CustomArray customArray) throws ArrayException;
}
