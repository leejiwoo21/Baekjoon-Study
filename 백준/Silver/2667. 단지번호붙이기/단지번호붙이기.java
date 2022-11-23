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

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1}; 
	
	public static class Point{
		int x;
		int y;
		public Point(int X, int Y) {
			x = X;
			y = Y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		int map[][] = new int[N+1][N+1];
		// map초기화
		for(int i=0; i<N; i++) map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		PriorityQueue<Integer> areas = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					Point p = new Point(i,j);
					int houses = search(p,map,N);
					areas.add(houses);
				}
			}
		}
		int area = areas.size();
		System.out.println(area);
		for(int i=0; i<area; i++) System.out.println(areas.poll());
	}
	
	private static int search(Point p, int[][] map, int N) {
		boolean check[][] = new boolean[N+1][N+1];
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		int x = p.x;
		int y = p.y;
		map[x][y] = 0;
		check[x][y] = true;
		int houses = 1;
		
		
		while(!q.isEmpty()) {
			Point curr_point = q.poll();
			x = curr_point.x;
			y = curr_point.y;
			int mx = 0;
			int my = 0;
			for(int i=0; i<4; i++) {
				mx = x + dx[i];
				my = y + dy[i];
				if(mx < N && my < N && mx >= 0 && my >= 0 && !check[mx][my] && map[mx][my]== 1) {
					check[mx][my] = true;
					map[mx][my] = 0;
					q.add(new Point(mx,my));
					houses++;
				}
			}
		}
		return houses;
	}

}
