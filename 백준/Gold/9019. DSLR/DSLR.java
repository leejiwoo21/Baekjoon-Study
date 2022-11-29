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
	
	static String ans; // 출력할 문자열
	static boolean[] check = new boolean[10001]; // 방문 확인용
	static Queue<Case> q = new LinkedList<>();
	public static class Case{
		int n;
		String move;
		public Case(int n, String move) {
			this.n = n;
			this.move = move;
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		while(T-->0) {
			q = new LinkedList<>();
			check = new boolean[10001];
			String[] line = br.readLine().split(" ");
			int start = Integer.valueOf(line[0]); // start = A
			int target = Integer.valueOf(line[1]); // target = B
			Case c = new Case(start,"");
			q.add(c);
			check[start] = true;
			while(!q.isEmpty()) {
				Case C = q.poll();
				int n = C.n;
				String move = C.move;
				if(operD(target,n,move)) break;
				if(operS(target,n,move)) break;
				if(operL(target,n,move)) break;
				if(operR(target,n,move)) break;
			}
			System.out.println(ans);
		}
	}
	
	private static boolean operD(int target, int n, String move) {
		int result = (n*2)%10000;
		move += "D";
		return hit(target,result,move);
	}
	
	static boolean operS(int target, int n, String move) {
		int result=0;
		if(n == 0) result = 9999;
		else result = n-1;
		move += "S";
		return hit(target,result,move);
	}
	
	public static boolean operL(int target, int n, String move) {
		int result = (n%1000)*10 + (n/1000);
		move += "L";
		return hit(target,result,move);
	}
	
	private static boolean operR(int target, int n, String move) {
		int result = (n%10)*1000 + (n/10);
		move += "R";
		return hit(target,result,move);
	}

	private static boolean hit(int target, int result, String move) {
		if(result == target) {
			ans = move;
			return true;
		}
		else {
			if(!check[result]) {
				q.add(new Case(result,move));
				check[result] = true;
			}
			return false;
		}
	}
}
