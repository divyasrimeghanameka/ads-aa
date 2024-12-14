import java.util.*;
class Linear
{
	int linearSearch(int arr[],int x,int n)
	{
		for(int i=0;i<n;i++)
		{
			if(arr[i]==x)
			return i;
		}
		return -1;
	}
	public static void main(String[]args)
	{
		int a[]={2,31,5,7,8,3,54};
		int n=a.length;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int x=sc.nextInt();
		Linear obj=new Linear();
		int result=obj.linearSearch(a,x,n);
		if(result==-1)
		System.out.println("not found");
		else
		System.out.println("found at index: "+result);
	}
}
