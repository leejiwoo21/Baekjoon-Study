
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
import java.util.Scanner;

import java.util.Scanner;

public class bj_2580_3 {
	static ArrayList arrr = new ArrayList();
	static int[][] check = new int[9][9];
	static Blank[][] blanks = new Blank[9][9];
	static class Blank {
		int i = 0;
		int j = 0;
		ArrayList numbers = new ArrayList();

		public Blank(int i, int j, ArrayList arr) {
			this.i = i;
			this.j = j;
			numbers = arr;
		}
	}

	private static void Solve(int[][] map) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (blanks[i][j] != null) { // ��ĭ�̶��
					while(((int) blanks[i][j].numbers.size() > 0)) { // ������ ���� �迭�� �� �迭�� �ƴϰ�
						int n = (int) blanks[i][j].numbers.get(0); // n�� ���ڹ迭 �� �հ�
						if (test(map, n, i, j)) { // �� ���� �� �� �ִٸ�
							map[i][j] = n;
							blanks[i][j] = new Blank(i,j,arrr);
							if((i == 8)&&(j ==8)) {
								break;
							}
							Solve(map);
						}
						else { // �����ٸ�
							if(blanks[i][j].numbers.size()>0) {
							blanks[i][j].numbers.remove(0); // �� �հ� ����
							}
							else {
								break;
							}
						}
					}
					
				}else { // ���� �ִ� ĭ�̶��
					if((i == 8)&&(j==8)) {
						break;
					}
				}
			}
		}
	}

	private static boolean test(int[][] map, int n, int i, int j) {
		int count = 0;
		for (int x = 0; x < 9; x++) { // ���� �˻�
			if ((map[x][j] == n) && (x != i)) {
				count++;
			}
		}
		for (int y = 0; y < 9; y++) { // ���� �˻�
			if ((map[i][y] == n) && (y != j)) {
				count++;
			}
		}
		if (i == 0) {
			if (j == 0) {
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (((x != i) || (y != j)) && (map[x][y] == n)) {
							count++;
						}
					}
				}
			} else {
				for (int x = 0; x < 3; x++) {
					for (int y = (j / 3) * 3; y < ((j / 3) * 3) + 3; y++) {
						if (((x != i) || (y != j)) && (map[x][y] == n)) {
							count++;
						}
					}
				}
			}
		} else {
			if (j == 0) {
				for (int x = (i / 3) * 3; x < ((i / 3) * 3) + 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (((x != i) || (y != j)) && (map[x][y] == n)) {
							count++;
						}
					}
				}
			} else {
				for (int x = (i / 3) * 3; x < ((i / 3) * 3) + 3; x++) {
					for (int y = (j / 3) * 3; y < ((j / 3) * 3) + 3; y++) {
						if (((x != i) || (y != j)) && (map[x][y] == n)) {
							count++;
						}
					}
				}
			}
		}
		if (count == 0) {
			return true;
		} 
		else {
			return false;
		}
	}

	private static void Sudoku(int map[][]) {

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
					} else {
						Blank blank = new Blank(i, j, can);
						blanks[i][j] = blank;
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] map = new int[9][9];
		for (int i = 0; i < 9; i++) { // ���ڵ� ����
			for (int j = 0; j < 9; j++) {
				map[i][j] = in.nextInt();
			}
		}
		Sudoku(map); // ������ ������ �ذ�
		
		Solve(map);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println("");
		}
	}
}
