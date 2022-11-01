/*
 * 문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

출력
예제와 같이 요세푸스 순열을 출력한다.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class bj_1158 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		System.out.print("<");
		P(N, K);
		System.out.print(">");

	}

	private static void P(int N, int K) {
		ArrayList arr = new ArrayList();
		for (int i = 0; i < N; i++) {
			arr.add(i+1);
		}
		int num = K;
		int save = 0;
		int size = 0;
		while (!arr.isEmpty()) {
			if ((save + num - 1) < arr.size()-1) {
				System.out.printf("%d, ", arr.get(save + num - 1));
				arr.remove(save+num-1);
				save = save + num - 1;
			}
			else if (arr.size()==1) {
				System.out.print(arr.get(0));
				arr.remove(0);
			}
			else if ((save + num - 1) == arr.size()-1) {
				System.out.printf("%d, ", arr.get(save + num - 1));
				arr.remove(save+num-1);
				save = 0;
			}
			else if ((save + num - 1) > arr.size()-1) {
				if((save+num)%arr.size() == 0){
					System.out.printf("%d, ", arr.get(arr.size()-1));
					arr.remove(arr.size()-1);
					save = 0;
				}
				else {
					System.out.printf("%d, ", arr.get((save+num)%arr.size()-1));
					size = arr.size();
					arr.remove((save+num)%arr.size()-1);
					save = (save+num)%size-1;
				}
			}
		}
	}
}
