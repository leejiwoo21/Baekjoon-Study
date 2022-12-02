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
		PriorityQueue<Long> pq = new PriorityQueue<>();
		while(N-->0) pq.add(Long.valueOf(br.readLine()));
		
		long sum = 0;
		while(pq.size() > 1) {
			long deck1 = pq.poll();
			long deck2 = pq.poll();
			long n = deck1 + deck2;
			sum += n;
			pq.add(n);
		}
		System.out.print(sum);
	}
}
