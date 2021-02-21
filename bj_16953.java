
/*
 * 문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bj_16953 {
	
	static class Node{
		long a = 0;
		long c = 0;
		public Node(long a, long c) {
			this.a = a;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		
		System.out.println(BFS(A,B));
		
	}
	
	private static long BFS(long A,long B) {
		long count = -1;
		Queue<Node> q = new LinkedList<Node>();
		HashSet<Long> visit = new HashSet();
		
		Node node = new Node(A, 1);
		q.offer(node);
		visit.add(A);
		
		while(!q.isEmpty()) {
			long a = q.peek().a;
			long c = q.peek().c;
			
			q.poll();
			
			if(a>B) {
				continue;
			}
			else if(a == B) {
				count = c;
				break;
			}
			
			long gob = a*2;
			long one = a*10+1;
			
			if(!visit.contains(gob)) {
				visit.add(gob);
				q.offer(new Node(gob,c+1));
			}
			if(!visit.contains(one)) {
				visit.add(one);
				q.offer(new Node(one,c+1));
			}
		
		}
		return count;
	}
}
