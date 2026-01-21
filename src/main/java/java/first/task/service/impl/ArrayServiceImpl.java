package java.first.task.service.impl;

import java.first.task.entity.CustomArray;
import java.first.task.exception.ArrayException;
import java.first.task.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImpl implements ArrayService {

    private static final Logger logger = LogManager.getLogger(ArrayServiceImpl.class);

    private void checkArray(CustomArray customArray) throws ArrayException {

        if (customArray == null){
            logger.error("CustomArray is null");
            throw new ArrayException("CustomArray cannot be null");
        }

        int[] array = customArray.getArray();

        if (array == null || array.length == 0){
            logger.error("Array inside CustomArray is empty or null");
            throw new ArrayException("Array is empty");
        }

    }

    @Override
    public int findMin(CustomArray customArray) throws ArrayException {

        checkArray(customArray);

        int[] array = customArray.getArray();

        int min = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }

        logger.info("Min value found: {}", min);
        return min;
    }

    @Override
    public int findMax(CustomArray customArray) throws ArrayException {

        checkArray(customArray);

        int[] array = customArray.getArray();

        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }

        logger.info("Max value found: {}", max);
        return max;
    }

    @Override
    public int calculateSum(CustomArray customArray) throws ArrayException {

        checkArray(customArray);
        int[] array = customArray.getArray();

        int sum = 0;
        for(int element : array){
            sum += element;
        }

        logger.info("Sum calculated: {}", sum);
        return sum;
    }

    @Override
    public void bubbleSort(CustomArray customArray) throws ArrayException {
        checkArray(customArray);
        int[] array = customArray.getArray();
        logger.info("Starting Bubble Sort");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Bubble Sort finished");
    }

    @Override
    public void selectionSort(CustomArray customArray) throws ArrayException {
        checkArray(customArray);
        int[] array = customArray.getArray();
        logger.info("Starting Selection Sort");

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        logger.info("Selection Sort finished");
    }


}