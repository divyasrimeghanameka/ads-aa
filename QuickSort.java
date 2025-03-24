import java.util.*;
class QuickSort
{
	public static void quicksort(int[] arr,int low,int high)
	{
		if(low<high)
		{
			int pivot = partition(arr,low,high);
			quicksort(arr,low,pivot-1);
			quicksort(arr,pivot+1,high);
		}
	}
	public static int partition(int[] arr,int low,int high)
	{
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++)
		{
			if(arr[j]<=pivot)
			{
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	public static void measureExeTime(int []arr)
	{
		long startTime=System.nanoTime();
		quicksort(arr,0,arr.length-1);
		long endTime=System.nanoTime();
		long duration=endTime-startTime;
		System.out.println("Execution Time(in nanoseconds):"+duration);
		System.out.println("Sorted Arrays: "+ Arrays.toString(arr));
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
3
2
4
1
Average case (Random Array):
Execution Time(in nanoseconds):3989
Sorted Arrays: [1, 2, 3, 4]
Enter the elements for the Best case (Sorted array):
1
2
3
4
Best case (Sorted Array):
Execution Time(in nanoseconds):2470
Sorted Arrays: [1, 2, 3, 4]
Enter the elements for the Worst case (Reverse sorted array):
4
3
2
1
Worst case (Reverse Sorted Array):
Execution Time(in nanoseconds):2327
Sorted Arrays: [1, 2, 3, 4]
*/
