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
		
		// 문자열 => 정수배열
		int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = line[0];
		int M = line[1];
		
		boolean graph[][] = new boolean[1001][1001];
		// 간선 저장
		for(int i=0; i<M; i++) {
			line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int start = line[0];
			int end = line[1];
			graph[start][end] = true;
			graph[end][start] = true;
		}
		
		int node = 1; // 탐색을 시작할 노드, 0부터 증가하여 N까지 탐색
		int CC = 0; // Connected Component의 수
		boolean[] check = new boolean[1001]; // 방문여부
		check[1] = true;
		Connect(node,N,graph,check);
		CC++;
		
		for(node=1;node<=N; node++) {
			if(check[node] == false) {
				Connect(node,N,graph,check);
				CC++;
			}
		}
		System.out.println(CC);
		
	}
	
	private static void Connect(int startNode, int N, boolean[][] graph, boolean[] check) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startNode);
		while(!q.isEmpty()) {
			int currNode = q.poll();
			for(int nextNode=1; nextNode<=N; nextNode++) {
				if(graph[currNode][nextNode] == true && check[nextNode] == false) {
					check[nextNode] = true;
					q.add(nextNode);
				}
			}
		}
	}
	
}
