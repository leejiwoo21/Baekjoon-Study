import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] fibo = new int[41][2]; // [n값에 해당하는][0과 1의 수]
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		DP(fibo,2);
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			System.out.println(fibo[n][0] + " " + fibo[n][1]);
		}

	}
	
	private static void DP(int[][] arr, int n) {
		arr[n][0] = arr[n-1][0] + arr[n-2][0];
		arr[n][1] = arr[n-1][1] + arr[n-2][1];
		if(n == 40) return;
		DP(arr, n+1);
	}
		
}
