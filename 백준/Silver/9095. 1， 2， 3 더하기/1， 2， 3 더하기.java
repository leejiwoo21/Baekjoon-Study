import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n=0;
		int[] dp = new int[11];
		DP(dp,0);
		for(int i=0; i<T; i++) {
			n = sc.nextInt();
			System.out.println(dp[n]);
		}

	}
	
	private static void DP(int[] dp, int n) {
		if(n+1 <= 10) {
			dp[n+1] +=1;
			DP(dp,n+1);
		}
		if(n+2 <= 10) {
			dp[n+2] +=1;
			DP(dp,n+2);
		}
		if(n+3 <= 10) {
			dp[n+3] +=1;
			DP(dp,n+3);
		}
	}
		
}
