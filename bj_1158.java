/*
 * ����
�似Ǫ�� ������ ������ ����.

1������ N������ N���� ����� ���� �̷�鼭 �ɾ��ְ�, ���� ���� K(�� N)�� �־�����. ���� ������� K��° ����� �����Ѵ�. �� ����� ���ŵǸ� ���� ������ �̷���� ���� ���� �� ������ ����� ������. �� ������ N���� ����� ��� ���ŵ� ������ ��ӵȴ�. ������ ������� ���ŵǴ� ������ (N, K)-�似Ǫ�� �����̶�� �Ѵ�. ���� ��� (7, 3)-�似Ǫ�� ������ <3, 6, 2, 7, 5, 1, 4>�̴�.

N�� K�� �־����� (N, K)-�似Ǫ�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� K�� �� ĭ�� ���̿� �ΰ� ������� �־�����. (1 �� K �� N �� 5,000)

���
������ ���� �似Ǫ�� ������ ����Ѵ�.
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
