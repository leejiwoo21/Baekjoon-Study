import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] nodes = new int[101][101];
		int coms = Integer.valueOf(br.readLine());
		int links = Integer.valueOf(br.readLine());
		int start, end =0;
		for(int i =0; i< links; i++) {
			String[] str = br.readLine().split(" ");
			start = Integer.valueOf(str[0]);
			end = Integer.valueOf(str[1]);
			nodes[start][end] = 1;
		}
		System.out.print(bfs(nodes,coms));
		
	}
	private static int bfs(int[][] nodes, int coms) {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int currNode = q.poll();
			for(int nextNode=1; nextNode<=coms; nextNode++) {
				if(nodes[currNode][nextNode] == 1) {
					nodes[currNode][nextNode] = 0;
					set.add(nextNode);
					q.add(nextNode);
				}
				else if(nodes[nextNode][currNode] == 1) {
					nodes[nextNode][currNode] = 0;
					set.add(nextNode);
					q.add(nextNode);
				}
			}
		}
		return set.size()-1;
	}

}
