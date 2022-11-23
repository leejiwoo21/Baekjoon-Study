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
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		// 왼쪽(앞)에 더 큰 사람이 몇 명 있는가
		int left[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int line[] = new int[N+1];
		Arrays.fill(line, N);
		
		//키작은 사람부터 줄새움
		for(int i=1; i<N; i++) {
			int curr_height = i; //현재 사람의 키
			int left_tall_men = 0; //현재 위치에서 왼쪽에 더 큰 사람이 몇 명있는지
			int curr_left = left[i-1]; //왼쪽에 더 큰 사람이 몇 명 있어야 하는지
			for(int j=1; j<=N; j++) {
				// 왼쪽에 더 큰 사람의 조건을 만족하는가
				if(left_tall_men == curr_left) {
					// 지금 위치에 나보다 작은 사람이 있는가
					if(line[j] < curr_height) continue; // 그렇다면 내 자리가 아님 => 다음 위치를 확인함
					else line[j] = curr_height; // 아니면 내가 그 자리에 선다
					break;
				}
				// 왼쪽에 더 큰 사람 수를 만족할 때 까지 왼쪽으로 이동
				if(line[j] > curr_height) left_tall_men++;
			}
		}
		//출력
		for(int i=1; i<=N; i++) {
			System.out.print(line[i]+" ");
		}
	}

}
