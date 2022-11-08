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
		int M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int[] arr = Stream.of(str).mapToInt(Integer::parseInt).toArray();
		
		int p1 = 0;
		int p2 = 0;
		int n = 0;
		int sum = arr[0];
		while(p1<N && p2<N){
			if(sum == M) {
				n+=1;
				
				if(p2<N-1)sum += arr[++p2];
				else break;
			}
			else if(sum > M) sum -= arr[p1++];
			else if(p2 < N-1) sum += arr[++p2];
			else {
				break;
			}
		}
		System.out.println(n);
		
	}
	

	
}
