import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 문자열 => 정수배열
		int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = line[0];
		int M = line[1];
		
		// 숫자들을 저장
		double nums[] = new double[N+1];
		line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// 배열의 각 칸은 1번부터 해당 인덱스까지의 합을 유지함
		for(int i=1; i<=N; i++) nums[i] = line[i-1] + nums[i-1];
		
		while(M-->0) {
			line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int start = line[0];
			int end = line[1];
			// 배열에 저장된 구간합을 가져와 사용함
			double sum = nums[end] - nums[start-1];
			
			System.out.println((int)sum);
		}
		
	}
	
}
