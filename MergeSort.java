import java.util.*;

class MergeSort
{
    public static void mergesort(int[] arr)
    {
        if (arr.length < 2)
            return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);
    }
    static void merge(int[] arr, int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length)
        {
            arr[k++] = left[i++];
        }
        while (j < right.length)
        {
            arr[k++] = right[j++];
        }
    }
    static void measureExeTime(int[] arr)
    {
        long startTime = System.nanoTime();
        mergesort(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time (in nanoseconds): " + duration);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] avgCase = new int[n];
        System.out.println("Enter the elements for the Average case (Random array):");
        for (int i = 0; i < n; i++)
        {
            avgCase[i] = sc.nextInt();
        }
        System.out.println("Average case (Random Array):");
        measureExeTime(avgCase.clone());
        int[] bestCase = new int[n];
        System.out.println("Enter the elements for the Best case (Sorted array):");
        for (int i = 0; i < n; i++)
        {
            bestCase[i] = sc.nextInt();
        }
        System.out.println("Best case (Sorted Array):");
        measureExeTime(bestCase.clone());
        int[] worstCase = new int[n];
        System.out.println("Enter the elements for the Worst case (Reverse sorted array):");
        for (int i = 0; i < n; i++)
        {
            worstCase[i] = sc.nextInt();
        }
        System.out.println("Worst case (Reverse Sorted Array):");
        measureExeTime(worstCase.clone());

        sc.close();
    }
}
/*output:
Enter the number of elements:
4
Enter the elements for the Average case (Random array):
6
3
8
1
Average case (Random Array):
Execution time (in nanoseconds): 60155
Sorted Array: [1, 3, 6, 8]
Enter the elements for the Best case (Sorted array):
6
3
8
1
Best case (Sorted Array):
Execution time (in nanoseconds): 5341
Sorted Array: [1, 3, 6, 8]
Enter the elements for the Worst case (Reverse sorted array):
6
3
8
1
Worst case (Reverse Sorted Array):
Execution time (in nanoseconds): 7575
Sorted Array: [1, 3, 6, 8]*/
