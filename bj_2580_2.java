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

 */import java.util.ArrayList;
import java.util.Scanner;

public class bj_2580_2 {
	static int[][] check = new int[9][9];
	static Blank[][] blanks = new Blank[9][9];
	static int row = 0; // ��
	static int col = 0; // ��

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

	private static void Solve(int map[][],int row, int col) {
		int finish = 0;
		for (int i = row; i < 9; i++) {
			for (int j = col; j < 9; j++) {
				if (blanks[i][j] != null) { // ��ĭ�̶��
					int k = 1;
					int n = (int) blanks[i][j].numbers.get(blanks[i][j].numbers.size() - k);
					if ((int) blanks[i][j].numbers.get(blanks[i][j].numbers.size()) > 0) {
						if(test(n,map,i,j)) {
						map[i][j] = n;
						if(row<8){
							row++;
						}
						else if((row == 8)&&(col <8)) {
							row = 0;
							col++;
						}
						else if((row == 8)&&(col==8)) {
							finish =1;
						}
						if(finish != 1) {
						Solve(map,row,col);
						}
						if(finish == 1) {
							break;
						}
					} else {
						k++;
						Solve(map,row,col);
					}
				}
			}
		}
	}

	private static boolean test(int n, int map[][], int i, int j) { // n�� map�� i,j�� �� �� �ִ��� �˻�
		int count = 0;
		for (int x = 0; x < 9; x++) { // ���� �˻�
			if ((n == map[x][j]) && (x != i)) {
				count++;
			}
		}
		for (int y = 0; y < 9; y++) { // ���� �˻�
			if ((n == map[i][y]) && (y != j)) {
				count++;
			}
		}
		// �簢�� �˻�
		if (i == 0) {
			if (j == 0) {
				for (int k = 0; k < 3; k++) {
					for (int g = 0; g < 3; g++) {
						if ((n == map[k][g])&&(k != i) && (g != j)) {
							count++;
						}
					}
				}
			} else {
				for (int k = 0; k < 3; k++) {
					for (int g = (j / 3) * 3; g < ((j / 3) * 3) + 3; g++) {
						if ((n == map[k][g])&&(k != i) && (g != j)) {
							count++;
						}
					}
				}
			}
		} else {
			if (j == 0) {
				for (int k = (i / 3) * 3; k < ((i / 3) * 3) + 3; k++) {
					for (int g = 0; g < 3; g++) {
						if ((n == map[k][g])&&(k != i) && (g != j)) {
							count++;
						}
					}
				}
			} else {
				for (int k = (i / 3) * 3; k < ((i / 3) * 3) + 3; k++) {
					for (int g = (j / 3) * 3; g < ((j / 3) * 3) + 3; g++) {
						if ((n == map[k][g])&&(k != i) && (g != j)) {
							count++;
						}
					}
				}
			}

		}
		if(count > 0) {
			return false;
		}
		else return true;
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

		Solve(map,row,col);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println("");
		}
	}
}
