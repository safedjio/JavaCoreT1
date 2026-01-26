package com.safedjio.arraytask.entity;
import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray(int[] array){
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
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
