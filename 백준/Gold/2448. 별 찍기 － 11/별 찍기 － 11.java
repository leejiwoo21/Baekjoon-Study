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
import java.util.List;

public class Main {

	static int[][] picture = new int[3200][10000]; // 점 위치
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		
		oneStar(N,N,N);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N*2-1;  j++) {
				if(picture[i][j]==1) bw.write("*");
				else bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void oneStar(int N, int x, int h) {
		if(N != 3) {
			oneStar(N/2,x,h-N/2);
			twoStar(N/2,x,h);
		}
		else {
			smallStar(x,h);
		}
	}
	
	private static void twoStar(int N, int x, int h) {
		if(N != 3) {
			oneStar(N,x-N,h);
			oneStar(N,x+N,h);
		}
		else {
			smallStar(x-N,h);
			smallStar(x+N,h);
		}
	}
	
	private static void smallStar(int x, int h) {
		picture[h-2][x] = 1;
		picture[h-1][x-1] = 1;
		picture[h-1][x+1] = 1;
		picture[h][x+2] = 1;
		picture[h][x+1] = 1;
		picture[h][x] = 1;
		picture[h][x-1] = 1;
		picture[h][x-2] = 1;
	}
}
