import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int p1 = 0; // 1번포인터 = 최솟값 인덱스
	static int p2 = 0; // 2번포인터
	static double nTeam = 0; // 팀의 수
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		int[] score = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(score);

		p1 = 0; // 1번포인터 = 최솟값 인덱스
		p2 = 1; // 2번포인터 = 최댓값 인덱스
		
		while(p1 < score.length-2) {
			p2 = p1+1;
			while(p2 < score.length-1) {
				int sum = score[p1] + score[p2];
				int target = -sum;
				nTeam += (bisearch_right(score, target, p2+1, score.length) - bisearch_left(score, target, p2+1, score.length));
				p2++;
			}
			p1++;
		}
		String s = String.format("%.0f", nTeam);
		System.out.print(s);
	}
	
	private static int bisearch_left(int[] score, int target, int start, int end) {
		int low = start;
		int high = end;
		int mid = 0;
		while(low < high) {
			mid = (high+low)/2;
			if(score[mid] < target){
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		return low;
	}
	
	private static int bisearch_right(int[] score, int target, int start, int end) {
		int low = start;
		int high = end;
		int mid = 0;
		while(low < high) {
			mid = (high+low)/2;
			if(target < score[mid]){
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return low;
	}
}
