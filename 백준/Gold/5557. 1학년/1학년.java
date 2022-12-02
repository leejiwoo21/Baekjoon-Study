import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		int N = Integer.valueOf(br.readLine());
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		long[][] memo = new long[N+1][21]; // [연산한 숫자의 수][연산 결과] = 중복 수
		
		memo[0][nums[0]]++;

		for(int i=1; i<N-1; i++) {
			int n = nums[i];
			for(int j=0;j<=20; j++) {
				if(memo[i-1][j] != 0) {
					int plus = j+n;
					int minus = j-n;
					if(plus <= 20) memo[i][plus]+=memo[i-1][j];
					if(minus>=0) memo[i][minus]+=memo[i-1][j];
				}
			}
		}
		System.out.print(memo[N-2][nums[N-1]]);
	}
}
