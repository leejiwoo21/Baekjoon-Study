
/*
 * ����
���� A�� B�� �ٲٷ��� �Ѵ�. ������ ������ ������ ���� �� �����̴�.

2�� ���Ѵ�.
1�� ���� ���� �����ʿ� �߰��Ѵ�. 
A�� B�� �ٲٴµ� �ʿ��� ������ �ּڰ��� ���غ���.

�Է�
ù° �ٿ� A, B (1 �� A < B �� 109)�� �־�����.

���
A�� B�� �ٲٴµ� �ʿ��� ������ �ּڰ��� 1�� ���� ���� ����Ѵ�. ���� �� ���� ��쿡�� -1�� ����Ѵ�.
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
