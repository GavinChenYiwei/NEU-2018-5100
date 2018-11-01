import java.io.File;
import java.io.RandomAccessFile;

//Question 1
public class MyindexOutOfBoundException extends Exception{
    int lowerBound;
    int upperBound;
    int index;

    public MyindexOutOfBoundException(int[] arr, int index){
        this.lowerBound = 0;
        this.upperBound = arr.length -1;
        this.index = index;
    }

    @Override
    public String toString(){
        return "Error Message: Index: " + index + ", but Lower bound: "+
                lowerBound + ", Upper bound: "+ upperBound;
    }

    public static void main(String[] args) throws MyindexOutOfBoundException{
        int[] test = {1,2,3,4,5};
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(test[i]);
            }
        } catch (Exception e){
            throw new MyindexOutOfBoundException(test,Integer.valueOf(e.getMessage()));
        }
        finally {
            System.out.println("End");
        }
    }
}
