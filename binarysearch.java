import java.util.*;
class Binary
{
  int binarysearch(int arr[], int x, int left, int right)
  { 
    while(left<=right)
    {
        int mid=left+(right-left)/2;
        if(arr[mid]==x)
        return mid;
        if(arr[mid]<x)
        left=mid+1;
        else
        right=mid-1;
    }
    return -1;
  }
  public static void main(String[]args)
  {
      Binary obj=new Binary();
      int arr[]={2,4,6,8,10};
      int n=arr.length;
      Scanner sc=new Scanner(System.in);
      System.out.println("enter a number:");
      int x=sc.nextInt();
      int result=obj.binarysearch(arr,x,0,n-1);
      if(result==-1)
          System.out.println("not found");
      else
          System.out.println("found at index "+result);
   }
}
