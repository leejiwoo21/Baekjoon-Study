import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Queue;
import java.util.LinkedList;

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
	// 실행 중 익은 토마토의 수
	static int changed = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int M = line[0];
		int N = line[1];
		
		int[][] box = new int[N+1][M+1];
		for(int i= 0; i<N; i++) {
			box[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] check  = new boolean[N+1][M+1];
		
		int matured = 0; // 익은 토마토의 수
		int tomato = 0; // 모든 토마토의 수
		// 처음 토마토 위치를 q에 넣는다
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(box[y][x] != -1) tomato++;
				if(box[y][x] == 1) {
					q.add(new Point(x,y));
					check[y][x] = true;
					matured++;
				}
			}
		}
		
		if(tomato == matured) {
			// 처음부터 모두 익은 경우
			System.out.print(0);
		}
		else {
			int time = -1;
			while(!q.isEmpty()) {
				q = Search(box,check,q,N,M);
				time++;
			}
			if(tomato == (changed + matured)) System.out.println(time);	// 모든 토마토가 익은 경우
			else System.out.println(-1);
		}
	}
	
	// 새 큐를 만들어 다음 실행에서 사용할 토마토를 반환함
	private static Queue<Point> Search(int[][] box, boolean[][] check, Queue<Point> q, int N, int M) {
		Queue<Point> nextQ = new LinkedList<>();
		while(!q.isEmpty()) { // bfs
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int mx = x+dx[i];
				int my = y+dy[i];
				if(mx>=0 && my>=0 && mx<M && my<N && check[my][mx]==false && box[my][mx]==0) {
					nextQ.add(new Point(mx,my));
					check[my][mx] = true;
					box[my][mx] = 1;
					changed++;
				}
			}
		}
		return nextQ;
	}
}
