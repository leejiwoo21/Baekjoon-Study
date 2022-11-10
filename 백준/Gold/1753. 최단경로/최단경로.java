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
import java.util.Collections;

public class Main {

	static class Node implements Comparable<Node>{
		public Node(int pos, int dist) {
			this.pos = pos;
			this.dist = dist;
		}
		int pos,dist=0;
		
		@Override
		public int compareTo(Node node) {
			if(this.dist > node.dist) return 1;
			else if(this.dist < node.dist) return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int str[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int V = str[0];
		int E = str[1];
		int K = Integer.valueOf(br.readLine());
		ArrayList<ArrayList<Node>> map = new ArrayList<ArrayList<Node>>(); // 가중치 지도
		
		for(int i=0;i<=V;i++) {
			map.add(new ArrayList<Node>());
		}
		
		// 간선의 가중치 입력
		int u,v,w = 0;
		for(int i=0; i<E; i++) {
			str = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			u=str[0];
			v=str[1];
			w=str[2];
			map.get(u).add(new Node(v,w)); // get(index)로 해당 인덱스에 접근이 가능함
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		int dist[] = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		q.add(new Node(K,0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(dist[curr.pos] < curr.dist) continue;
			for(int i=0; i<map.get(curr.pos).size();i++) {
				Node nextNode = map.get(curr.pos).get(i);
				
				if(dist[nextNode.pos] > curr.dist + nextNode.dist) {
					dist[nextNode.pos] = curr.dist + nextNode.dist;
					q.add(new Node(nextNode.pos, dist[nextNode.pos]));
				}
			}
		}
		
		for(int i=1; i<=V;i++){
			if(i==K) {
				System.out.println(0);
			}
			else if(dist[i]<Integer.MAX_VALUE){
				System.out.println(dist[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}
	
}
