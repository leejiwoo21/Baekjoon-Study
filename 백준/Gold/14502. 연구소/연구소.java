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

public class Main {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1}; 
	static Queue<Point[]> walls = new LinkedList<Point[]>(); // 벽이 들어설 수 있는 모든 위치를 저장
	static int[] wallPoint = new int[3]; // 벽이 들어설 수 있는 위치를 나타낼 임시 포인트
	static Queue<int[]> points = new LinkedList<>(); // 벽 배치의 경우의 수를 기억하는 큐(zeros배열에서의 순서를 기준으로 기억함)
	static Point[] virus;
	
	public static class Point{
		int x;
		int y;
		public Point(int X, int Y) {
			x = X;
			y = Y;
		}
	}
	
	// 벽 위치의 모든 경우의 수를 구함  ex) {0,0,1} , {0,0,2} , ... 
	private static void Combination(int[] arr, int max,int cnt, int idx) { 
		if(cnt == 3) {
			int[] wp = wallPoint.clone(); // deepcopy 거지같은거
			points.add(wp);
			return;
		}
		for(int i=idx; i<max; i++) {
			wallPoint[cnt] = arr[i];
			Combination(arr, max,cnt+1, i+1);
		}
	}
	
	// 벽 설치 => 바이러스 퍼짐(bfs) => 0갯수 저장 => 벽 이동 반복(브루트포스)
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = line[0];
		int M = line[1];
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int count = 0; // 0의 갯수
		Point[] zeros = new Point[N*M]; // 0이 들어간 위치를 저장
		Queue<Point> virus = new LinkedList<>(); // 바이러스의 위치
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					Point p = new Point(i,j);
					zeros[count++] = p;
				}
				if(map[i][j] == 2) {
					Point p = new Point(i,j);
					virus.add(p);
				}
			}
		}
		// 배열에서 0 제거
		zeros = Arrays.copyOfRange(zeros, 0, count);
		
		int[] arr = new int[zeros.length]; //콤비네이션의 재료
		for(int i=0; i<arr.length;i++) arr[i]+=i; // {0,1,2,3,...,zeros의길이}
		Combination(arr,zeros.length,0,0);

		// 순서(정수)형태의 벽의 위치를 Point형태로 walls에 저장
		while(!points.isEmpty()) {
			int[] nums = points.poll();
			Point[] plist = {zeros[nums[0]],zeros[nums[1]], zeros[nums[2]]};
			walls.add(plist);
		}
		
		int answer = wallPlace(map,virus,N,M);
		System.out.print(answer);
	}
	
	// 벽 배치의 모든 경우의 수를 대입
	private static int wallPlace(int[][] map, Queue<Point> virus, int N, int M) {
		int MAX = 0;
		while(!walls.isEmpty()) {
			Point[] wallPoints = walls.poll();
			int result = CountZero(wallPoints,map,virus,N,M);
			if(result > MAX) MAX = result;
		}
		return MAX;
	}

	// 벽을 세웠을 때 map에서 0의 수를 세는 함수
	private static int CountZero(Point[] wallPoints, int[][] map, Queue<Point> virus, int N, int M) {
		int[][] mapTest = mapDeepCopy(map, N, M); // deepcopy

		for(int i=0; i<3; i++) {
			Point p = wallPoints[i];
			mapTest[p.x][p.y] = 1;
		}

		
		int zero = 0;
		zero = Spread(N,M,mapTest,virus);

		return zero;
	}
	
	// 맵에 바이러스가 퍼짐
	private static int  Spread(int N, int M, int[][] map, Queue<Point> virus) {
		boolean[][] check = new boolean[N][M];
		Queue<Point> virusTest = new LinkedList<>();
		for(Point p: virus) { // deepcopy
			virusTest.add(p);
		}

		while(!virusTest.isEmpty()) {
			Point p = virusTest.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(mx>=0 && my>=0 && mx<N && my<M && (map[mx][my]== 0) && !check[mx][my] ) {
					virusTest.add(new Point(mx,my));
					map[mx][my] = 2;
					check[mx][my] = true;
				}
			}
		}
		int zero = 0;

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					zero++;
				}
			}
		}
		return zero;
		
	}
	
	private static int[][] mapDeepCopy(int[][] original, int N, int M){
		int[][] copy = new int[N][M];
		for(int i=0;i<N;i++) {
			copy[i] = original[i].clone(); // 2차원 배열은 clone해봤자 x좌표만 deepcopy됨
		}
		return copy;
	}
}
