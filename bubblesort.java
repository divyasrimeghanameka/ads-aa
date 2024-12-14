import java.util.*;
class BubbleSort
{
	void bubbleSort(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				
				}
			}
		}
	}
	public static void main(String[]args)
	{
		BubbleSort obj=new BubbleSort();
		int a[]={62,52,12,01,98,67,36,42};
		obj.bubbleSort(a);
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
	}
}
