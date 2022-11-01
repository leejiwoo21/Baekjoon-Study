import java.util.Scanner;
import java.util.Arrays;

public class Find2 {
	public static int compare(int[] arr, int num)
	{
		int high = arr.length-1 , low = 0 , mid = 0;
		
		while(low<= high)
		{
		mid = (high + low)/2;
		if( arr[mid] == num)
		{
			return 1;
		}
		else if( arr[mid] < num)
		{
			low = mid+1;
		}
		else high = mid-1;
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n] ;
		for(int i = 0; i<n; i++)
		{
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int m = in.nextInt();
		
		for(int i = 0; i < m; i++)
		{
			System.out.println(compare(arr,in.nextInt()));
		}
	}
}


