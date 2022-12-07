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
		Conf[] confs = new Conf[N];
		for(int i=0; i<N; i++) {
			int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Conf newConf = new Conf(line[0],line[1]);
			confs[i] = newConf;
		}
		
		Arrays.sort(confs);
		
		int end = -1;
		int count = 0;

		for(int i=0; i<N; i++) {
			Conf c = confs[i];
			if(c.start >= end) {
				end = c.end;
				count++;
			}
		}
		System.out.print(count);
	}
	private static class Conf implements Comparable<Conf>{
		int start = 0;
		int end = 0;
		public Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Conf c) {
			if(this.end < c.end)return -1;
			else if(this.end > c.end) return 1;
			else {
				if(this.start > c.start) return 1;
				else if(this.start < c.start) return -1;
				else return 0;
			}
		}
	}
}
