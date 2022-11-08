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
		int[] arr1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] arr2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int p1 = 0;
		int p2 = 0;
		int n = 0;
		while(p1<N && p2<M) {
			int n1 = arr1[p1];
			int n2 = arr2[p2];
			if(n1 <= n2) {
				bw.write(String.valueOf(n1+" "));
				p1++;
			}
			else {	
				bw.write(String.valueOf(n2+" "));
				p2++;
			}
		}
		if(p1<N) {
			for(int i=p1; i<N; i++) {
				bw.write(String.valueOf(arr1[p1]+" "));
				p1++;
			}
		}
		if(p2<M) {
			for(int i=p2; i<M; i++) {
				bw.write(String.valueOf(arr2[p2]+" "));
				p2++;
			}
		}
		bw.flush();

	}
	

	
}
