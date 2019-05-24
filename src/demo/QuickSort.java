package demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {



    // Driver program
    public static void main(String args[])
    {

        int arr[] = {98, 0, 0 , 99,45,23,83,23,233, 7, 8, 9, 1, 5};
        int arrLength = arr.length;


        QuickSort ob = new QuickSort();
        if(arrLength > 0) {

            ob.quickSort(arr, 0, arrLength - 1);

        } else {

            System.out.println("The array length is 0.");
            return;
        }


        System.out.println("Sorted array: ");
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }


    public void quickSort(int arr[], int lowerBound, int upperBound)
    {

        // Check array size
        if (lowerBound < upperBound) // If LOWER INDEX == UPPER INDEX, array size 1, done.
        {

            // Partition array: Find the median value of the array, This is the pivot
            int pivot = partition(arr, lowerBound, upperBound);

            // Sort the partitions on either side of the pivot
            quickSort(arr, lowerBound, pivot - 1);  // Before pivot
            quickSort(arr, pivot + 1, upperBound); // After pivot
        }
    }


    // UB pivot
    public int partition (int arr[], int lowerBound, int upperBound)
    {

        // Pivot - Element to place at median position
        int pivot = arr[upperBound];

        int down = (lowerBound - 1);    /* In this algo, the down index is where the for loop below has stopped
                                        * finding values >= pivot.
                                        *
                                        * If it never moves right, then the pivot is the smallest value
                                        * in the array (one index after down).

                                        * Think of "down" as the follow-behind Swapper and "up" as the Scout.
                                        */

        for (int up = lowerBound; up < upperBound; up++)
        {

            // The number of up values <= pivot is equal to the index of down.
            // Pivot will be placed at down+1 (Pivot is places directly after all values that it is larger than.)
            if (arr[up] <= pivot)
            {

                down++;    //

                //swap arr[i] and arr[j]
                int temp = arr[up];
                arr[up] = arr[down];
                arr[down] = temp;
            }
        }


        //swap arr[i + 1] and arr[upperBound])
        int temp = arr[upperBound];
        arr[upperBound] = arr[down + 1];
        arr[down + 1] = temp;


        return down + 1;
    }
}
