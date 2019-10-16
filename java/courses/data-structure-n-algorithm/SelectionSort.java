import java.lang.Math;
import java.util.Arrays;

public class Main
{
  public static void main(String[] args)
  {
    SelectionSort selectionSort = new SelectionSort();
    int[] arr = {5,2,3,7,1,9,8,11,4};
    selectionSort.sort(arr);
    
    System.out.print(Arrays.toString(arr));
  }
}

public class SelectionSort
{
 
  public int findMin(int[] arr)
  {
    int min = arr[0];
    for(int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
      	min = arr[i];
      }
    }
    return min;
  }
  
  public int findMinIndex(int[] arr, int curIndex)
  {
    int min = arr[curIndex];
    int index = curIndex;
    for(int i = curIndex + 1; i < arr.length; i++) {
      if (arr[i] < min) {
      	min = arr[i];
        index = i;
      }
    }
    return index;
  }
  
  public void swapNumbers(int[] arr, int curIndex, int newIndex) {
    int temp = arr[curIndex];
    arr[curIndex] = arr[newIndex];
    arr[newIndex] = temp;
  }
  
  public void sort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      int minIndex = this.findMinIndex(arr, i);
      this.swapNumbers(arr, i, minIndex);
    }
  }
}
