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
		long N = Integer.parseInt(str[0]);
		long M = Long.parseLong(str[1]);
		long max =0;
		str = br.readLine().split(" ");
		long[] trees = new long[1000001];
		long n = 0;
		for(int i=0; i<N; i++) {
			n = Long.parseLong(str[i]);
			if(max < n) max = n;
			trees[i] = n;
		}
		
		long high = max;
		long low = 0;
		long h = 0;
		while(high > low) {
			h = (high+low)/2;
			long sum = Sum(trees,N,h);
			if( M <= sum ) { // 올라감
				low = h+1;
			}
			else { // 내려감
				high = h;
			}
		}
		System.out.println(low-1);
	}
	
	private static long Sum(long[] trees, long N, long h) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(trees[i]>h) sum += trees[i]-h;
			if(sum > 2000000001) return sum;
		}
		return sum;
	}
	
}
