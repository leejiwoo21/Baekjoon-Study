import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.valueOf(br.readLine());
		
		while(T-->0) {
			int size = 0;
			int k = Integer.valueOf(br.readLine());
			PriorityQueue<Double> minQ = new PriorityQueue<>(); // 0번이 최솟값
			PriorityQueue<Double> maxQ = new PriorityQueue<>(Collections.reverseOrder()); // 0번이 최댓값
			HashMap<Double,Integer> delMax = new HashMap<>();
			HashMap<Double,Integer> delMin = new HashMap<>();
			while(k-->0) {
				String line[] = br.readLine().split(" ");
				String oper = line[0];
				double val = Double.valueOf(line[1]);
				if(oper.equals("I")) { // 추가는 두 pq에 실행
					minQ.add(val);
					maxQ.add(val);
					size++;
				}
				else if(size == 0) continue;
				// 작은 값 추출은 최소Q에서 실행
				else if(val == -1) {
					double n = minQ.poll();
					while(delMax.containsKey(n)){
						if(delMax.get(n) == 1) delMax.remove(n);
						else delMax.put(n,delMax.get(n)-1);
						n = minQ.poll();
					}
					if(delMin.containsKey(n)) delMin.put(n, delMin.get(n)+1);
					else delMin.put(n, 1);
					if(size >= 1) size--;
				}
				// 큰 값 제거는 최대Q에서 실행
				else{
					double n = maxQ.poll();
					while(delMin.containsKey(n)){
						if(delMin.get(n) == 1) delMin.remove(n);
						else delMin.put(n,delMin.get(n)-1);
						n = maxQ.poll();
					}
					if(delMax.containsKey(n)) delMax.put(n, delMax.get(n)+1);
					else delMax.put(n, 1);
					if(size >= 1) size--;
				}
			}
			if(size == 0) {
				System.out.println("EMPTY");
			}
			else {
				double min = minQ.poll();
				while(delMax.containsKey(min)){
					if(delMax.get(min) == 1) delMax.remove(min);
					else delMax.put(min,delMax.get(min)-1);
					min = minQ.poll();
				}
				
				double max = maxQ.poll();
				while(delMin.containsKey(max)){
					if(delMin.get(max) == 1) delMin.remove(max);
					else delMin.put(max,delMin.get(max)-1);
					max = maxQ.poll();
				}

				String minStr = String.format("%.0f", min);
				String maxStr = String.format("%.0f", max);
				System.out.println(maxStr+" "+minStr);
			}	
		}
	}
}
