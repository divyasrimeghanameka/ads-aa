import java.util.*;
class MergeSort
{
	public static void mergesort(int []arr)
	{
		if(arr.length<2)
			return;
		int mid=arr.length/2;
		int[] left=Arrays.copyOfRange(arr,0,mid);
		int[] right=Arrays.copyOfRange(arr,mid,arr.length);
		mergesort(left);
		mergesort(right);
		merge(arr,left,right);
	}
	static void merge(int[] arr,int[] left,int[] right)
	{
		int i=0,j=0, k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<=right[j])
			{
				arr[k++]=right[i++];
			}
			else
			{
				arr[k++]=right[j++];
			}
		}
		while(i<left.length)
		{
			arr[k++]=left[i++];
		}
		while(j<right.length)
		{
			arr[k++]=right[j++];
		}
	}
	static void measureExeTime(int[] arr)
	{
		long startTime=System.nanoTime();
		mergesort(arr);
		long endTime=System.nanoTime();
		long duration=endTime-startTime;
		System.out.println("Execution time(in nanoseconds):"+duration);
		System.out.println("Sorted Array:"+Arrays.toString(arr));
	}
	public static void main(String[]args)
	{
		Random random=new Random();
		int n=10;
		int[] avgCase=new int[n];
		for(int i=0;i<n;i++)
		{
			avgCase[i]=random.nextInt(100);
		}
		System.out.println("Average case (Random Array):");
		measureExeTime(avgCase.clone());
		int[] bestCase=new int[n];
		for(int i=0;i<n;i++)
		{
			bestCase[i]=i;
		}
		System.out.println("best case(sorted array):");
		measureExeTime(bestCase.clone());
		int[] worstCase=new int[n];
		for(int i=0;i<n;i++)
		{
			worstCase[i]=n-i-1;
		}
		System.out.println("worst case(reverse sorted array):");
		measureExeTime(worstCase.clone());
	}
}			
