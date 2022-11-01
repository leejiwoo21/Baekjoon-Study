import java.util.Scanner;

public class Dijkstra {
	static Scanner in = new Scanner(System.in);
	static int n = 0;
	int e = 0;
	int start = 0; // 시작 정점
	int arrive = 0; // 도착 정점
	static int[][] arr = new int[800][800]; // start > arrive 정점까지의 거리
	static boolean v[]; // 지났던 정점인지 확인할 배열
	static int[] dStart; // 시작지점에서 각 정점까지의 거리를 저장할 배열

	public static int getSmallIndex(int start) // start 지점에서 가장 가까운 정점을 찾아준다
	{
		int min = 200001; // 최소거리 저장
		int index = 0; // 정점
		for (int i = 0; i < n; i++) 
		{
			if (arr[start][i] < min && v[i] == false) 
			{
				min = arr[start][i] ;   //문제점
				index = i;
			}
		}
		return index;
	}

	public static void dijkstra(int start) {
		for (int i = 0; i < n; i++) {
			dStart[i] = arr[start][i];
		}
		dStart[start]=0;
		for (int i = 0; i < n; i++) {
			int current = getSmallIndex(start);
			v[current] = true;
			for (int j = 0; j < n; j++) {
				if (!v[j]) {
					if (dStart[current] + arr[current][j] < dStart[j]) {
						dStart[j] = dStart[current] + arr[current][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = in.nextInt(); // 정점의 수
		int e = in.nextInt(); // 경로의 수
		int start = 0; // 시작 정점
		int arrive = 0; // 도착 정점
		int[][] Arr = new int[n][n]; // start > arrive 정점까지의 거리
		boolean v[] = new boolean[n]; // 지났던 정점인지 확인할 배열
		int[] dStart = new int[n]; // 시작지점에서 각 정점까지의 거리를 저장할 배열
		
		for (int i = 0; i < n; i++) // 처음에 아무곳도 안 들렸기 때문에 false로 초기화
		{
			v[i] = false;
		}
		for (int i = 0; i < n; i++) // 모든 경로의 거리를 무한 값으로 설정(나중에 다익스트라 함수를 사용할 때 0값이 사용되지 않도록 하기위함)
		{

			for (int j = 0; j < n; j++) {
				arr[i][j] = 200001;
			}
		}
		for (int i = 0; i < e; i++) // 정점사이의 거리 입력받기
		{
			start = in.nextInt();
			arrive = in.nextInt();
			Arr[start-1][arrive-1] = in.nextInt();
		}
		int n1 = in.nextInt(); // 경유지점1
		int n2 = in.nextInt(); // 경유지점2
		
		dijkstra(0);
		int d1 = dStart[n1-1]; // 0지점에서 경유지점1까지 거리 저장
		int d2 = dStart[n2-1]; // 0지점에서 경유지점2까지 거리 저장
		for (int i = 0; i < n; i++) // 처음에 아무곳도 안 들렸기 때문에 false로 초기화
		{
			v[i] = false;
		}
		
		dijkstra(n1-1);
		int n1_N = dStart[n-1]; // 1번 경유지점에서 N까지 거리
		int n1_n2 = dStart[n2-1]; // 경유지점 사이의 거리
		for (int i = 0; i < n; i++) // 처음에 아무곳도 안 들렸기 때문에 false로 초기화
		{
			v[i] = false;
		}
		
		dijkstra(n2-1);
		int n2_N = dStart[n-1]; // 2번 경유지점에서 N까지 거리
		
		if((d1 + n1_n2 + n2_N >= 200000) && (d2 + n1_n2 + n2_N >= 200000))
		{
			System.out.println("-1");
		}
		else if((d1 + n1_n2 + n2_N) >= (d2 + n1_n2 + n2_N))
		{
			System.out.printf("%d",d2 + n1_n2 + n2_N );
		}
		else
		{
			System.out.printf("%d",d1 + n1_n2 + n2_N);
		}

	}
}
