package AlgorithmIlluminated;

import java.util.Arrays;

public class SortingAlgorithms {

  public void execute() {
    int[] toSort = new int[]{5, 6, 7, 8, 1, 2, 3, 4};

    System.out.println("Sorting Algorithms:");
    System.out.println("sort using selection sort = " + Arrays.toString(selectionSort(toSort)));
    System.out.println("sort using insertion sort = " + Arrays.toString(insertionSort(toSort)));
    System.out.println("sort using bubble sort = " + Arrays.toString(bubbleSort(toSort)));
  }

  private int[] selectionSort(int[] toSort) {
    if (toSort.length == 1) {
      return toSort;
    }
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

  private int[] insertionSort(int[] toSort) {
    if (toSort.length == 1) {
      return toSort;
    }
    for (int i = 1; i < toSort.length; i++) {
      int current = toSort[i];
      int j = i - 1;

      while (j > 0 && toSort[j] > current) {
        toSort[j + 1] = toSort[j];
        j = j - 1;
      }
      toSort[j + 1] = current;
    }
    return toSort;
  }

  private int[] bubbleSort(int[] toSort) {
    if (toSort.length == 1) {
      return toSort;
    }
    for (int i = 0; i < toSort.length; i++) {
      for (int j = i + 1; j < toSort.length; j++) {
        if (toSort[i] > toSort[j]) {
          int temp = toSort[j];
          toSort[j] = toSort[i];
          toSort[i] = temp;
        }
      }
    }
    return toSort;
  }
}
