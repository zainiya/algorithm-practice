package AlgorithmIlluminated;

import java.util.Arrays;

public class SortingAlgorithms {

  public void execute() {
    int[] toSort = new int[]{5, 6, 7, 8, 1, 2, 3, 4};

    System.out.println("Sorting Algorithms:");
    System.out.println("sort using selection sort = " + Arrays.toString(selectionSort(toSort)));
  }

  private int[] selectionSort(int[] toSort) {
    for (int i = 0; i < toSort.length; i++) {
      int minIdx = i;
      for (int j = i + 1; j < toSort.length; j++) {
        if (toSort[j] < toSort[minIdx]) {
          minIdx = j;
        }
      }
      // swap
      int temp = toSort[minIdx];
      toSort[minIdx] = toSort[i];
      toSort[i] = temp;
    }
    return toSort;
  }
}
