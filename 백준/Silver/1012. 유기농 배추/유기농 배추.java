import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
	
	
	static class point{
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		int x =0;
		int y =0;
	}
	
	static int[] X_move = {1,0,-1,0};
	static int[] Y_move = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.valueOf(br.readLine());
		for(int t=0; t<T; t++) {
			int[][] field = new int[51][51];
			int M,N,k =0;
			String[] str = br.readLine().split(" ");
			M = Integer.valueOf(str[0]);
			N = Integer.valueOf(str[1]);
			k = Integer.valueOf(str[2]);
			
			int row, col=0;
			for(int i=0; i<k; i++) {
				str = br.readLine().split(" ");
				row = Integer.valueOf(str[0]);
				col = Integer.valueOf(str[1]);
				field[row][col] = 1;
			}
			int result = search(field, M, N);
			System.out.println(result);
		}
	}
	
	private static int search(int[][] field, int M, int N) {
		int needBugs = 0;
		int currX, currY=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(field[i][j] == 1) {
					dfs(field,M,N,i,j);
					++needBugs;
				}
			}
		}
		return needBugs;
	}
	
	private static void dfs(int[][] field, int M, int N, int x, int y) {
		Stack<point> st = new Stack<>();
		point p = new point(x,y);
		st.push(p);
		field[x][y] = 0;
		while(!st.isEmpty()) {
			p = st.pop();
			int currX = p.x;
			int currY = p.y;
			for(int i=0; i<4; i++) {
				int nextX = currX + X_move[i];
				int nextY = currY + Y_move[i];
				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
					if(field[nextX][nextY] == 1) {
						st.push(new point(nextX,nextY));
						field[nextX][nextY] = 0;
					}
				}
			}
		}
	}

}
