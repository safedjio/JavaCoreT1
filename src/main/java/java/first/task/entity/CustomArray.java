package java.first.task.entity;
import java.util.Arrays;

public class CustomArray {

    private int[] array;

    public CustomArray(int[] array){
        this.array = array;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        CustomArray that = (CustomArray) obj;

       return  Arrays.equals(array, that.array);

    }

    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){
        return "CustomArray{" +
                "array = " + Arrays.toString(array) +
                "}";
    }

}
