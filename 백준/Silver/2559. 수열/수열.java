import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int p1 = 0;
		int p2 = K-1;
		int sum = 0;
		for(int i=p1; i<=p2; i++) {
			sum+=arr[i];
		}
		int max = sum;
		while(p2 < N-1) {
			sum-=arr[p1++];
			sum+=arr[++p2];
			if(max < sum) max = sum;
		}
		System.out.println(max);
	}
}
