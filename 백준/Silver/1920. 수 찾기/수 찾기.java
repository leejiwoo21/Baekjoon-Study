import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static int N, M, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<N; i++) {
			hs.add(sc.nextInt()); // N의 정수 A(HasSet)에 담기
		}
		
		M = sc.nextInt();
		int arr[] = new int[M];
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			if (hs.contains(arr[i])) { // M개의 수들이 A에 존재하는지 체크
				answer = 1;
			} else {
				answer = 0;
			}
			System.out.println(answer);
		}
	}
}


