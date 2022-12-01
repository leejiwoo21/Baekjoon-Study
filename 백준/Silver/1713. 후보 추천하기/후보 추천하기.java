import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		int N = Integer.valueOf(br.readLine());
		int nRecommend = Integer.valueOf(br.readLine());
		int[] pick = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		HashMap<Integer,Integer> board = new HashMap<>(); // 게시판 <후보번호,추천수>
		Queue<Integer> order = new LinkedList<>(); // 전시된 순서, 후보번호
		for(int i=0; i < pick.length; i++) { 
			int n = pick[i]; // 후보번호
			// 전시중인 후보
			if(board.containsKey(n)) {
				board.put(n, board.get(n)+1);
			} 
			else {
				if(order.size() < N) { // 전시 자리가 있는 경우
					board.put(n, 1);
					order.add(n);
				}
				else { // 전시 자리가 없는 경우
					Remove(board,order);
					board.put(n, 1);
					order.add(n);
				}
			}
		}
		int[] ans = new int[board.size()];
		for(int i=0; i<board.size(); i++) {
			ans[i] = order.poll();
		}
		Arrays.sort(ans);
		for(int n:ans) System.out.print(n+" ");
		br.close();
	}
	
	private static void Remove(HashMap<Integer,Integer> board, Queue<Integer> order) {
		boolean[] outmen = new boolean[101];
		int recommend = 1001;
		for(int i=1; i<=100; i++) {
			if(board.containsKey(i)) {
				if(board.get(i) < recommend) {
					outmen = new boolean[101];
					outmen[i] = true;
					recommend = board.get(i);
				}
				else if(board.get(i) == recommend) {
					outmen[i] = true;
				}
			}
		}
		int n = order.size();
		boolean removed = false;
		for(int i=0; i<n; i++) {
			int man = order.poll();
			if(removed) {
				order.add(man);
			}
			else {
				if(outmen[man]) {
					board.remove(man);
					removed = true;
				}
				else order.add(man);
			}
		}
	}
}
