
/*
 * ������� 18���� ������ �����ڰ� ���� '��ƾ �簢��'�̶� ���񿡼� ������ ������ ���� ���� �α⸦ ������ �ִ�. �� ������ �Ʒ� �׸��� ���� ����, ���� ���� 9���� �� 81���� ���� ĭ���� �̷���� ���簢�� �� ������ �̷����µ�, ���� ���� �� �Ϻ� ĭ���� 1���� 9������ ���� �� �ϳ��� ���� �ִ�.
 * 
 * ������ �� ĭ�� ä��� ����� ������ ����.

������ �����ٰ� �����ٿ��� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
���� ������ ���еǾ� �ִ� 3x3 ���簢�� �ȿ��� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
���� ���� �� ������ �ǿ� ���� �ִ� ���ڵ��� ������ �־��� �� ��� �� ĭ�� ä���� ���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
��ȩ �ٿ� ���� �� �ٿ� 9���� ���� ���� �� �������� �� �ٿ� ���� �ִ� ���ڰ� �� ĭ�� ����� ���ʷ� �־�����. ������ ���� �� ĭ�� ��쿡�� 0�� �־�����. ������ ���� ��Ģ��� ä�� �� ���� ����� �Է��� �־����� �ʴ´�.

���
��� �� ĭ�� ä���� ������ ���� ���� ����� ��ȩ �ٿ� ���� �� �ٿ� 9���� �� ĭ�� ����� ����Ѵ�.

������ ���� ä��� ����� ������ ���� �� �� �ϳ����� ����Ѵ�.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_2580 {

	static int[][] check = new int[9][9];

	private static void Sudoku(int map[][], int zeros) {
		while (zeros != 0) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					ArrayList can = new ArrayList();
					if ((map[i][j] == 0) && (check[i][j] == 0)) {
						for (int k = 1; k < 10; k++) { // check �ʱ�ȭ
							can.add(k);
						}
						for (int k = 0; k < 9; k++) { // ���� �˻�
							if (can.contains(map[i][k])) {
								Integer a = map[i][k];
								can.remove(a);
							}
						}
						for (int k = 0; k < 9; k++) { // ���� �˻�
							if (can.contains(map[k][j])) {
								Integer a = map[k][j];
								can.remove(a);
							}
						}
						// �簢�� �˻� ����
						if (i == 0) {
							if (j == 0) {
								for (int k = 0; k < 3; k++) {
									for (int g = 0; g < 3; g++) {
										if (can.contains(map[k][g])) {
											Integer a = map[k][g];
											can.remove(a);
										}
									}
								}
							} else {
								for (int k = 0; k < 3; k++) {
									for (int g = (j / 3) * 3; g < ((j / 3) * 3) + 3; g++) {
										if (can.contains(map[k][g])) {
											Integer a = map[k][g];
											can.remove(a);
										}
									}
								}
							}
						} else {
							if (j == 0) {
								for (int k = (i / 3) * 3; k < ((i / 3) * 3) + 3; k++) {
									for (int g = 0; g < 3; g++) {
										if (can.contains(map[k][g])) {
											Integer a = map[k][g];
											can.remove(a);
										}
									}
								}
							} else {
								for (int k = (i / 3) * 3; k < ((i / 3) * 3) + 3; k++) {
									for (int g = (j / 3) * 3; g < ((j / 3) * 3) + 3; g++) {
										if (can.contains(map[k][g])) {
											Integer a = map[k][g];
											can.remove(a);
										}
									}
								}
							}

						}
						if (can.size() == 1) {
							map[i][j] = (int) can.get(0);
							zeros--;
							check[i][j] = 1;
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] map = new int[9][9];
		int zeros = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = in.nextInt();
				if (map[i][j] == 0) {
					zeros++;
				}
			}
		}
		Sudoku(map, zeros);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println("");
		}

	}

}
