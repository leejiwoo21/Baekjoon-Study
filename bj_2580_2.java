/*
 * 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
 * 
 * 나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

입력
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.

출력
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.

 */import java.util.ArrayList;
import java.util.Scanner;

public class bj_2580_2 {
	static int[][] check = new int[9][9];
	static Blank[][] blanks = new Blank[9][9];
	static int row = 0; // 행
	static int col = 0; // 열

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
				if (blanks[i][j] != null) { // 빈칸이라면
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

	private static boolean test(int n, int map[][], int i, int j) { // n이 map의 i,j에 올 수 있는지 검사
		int count = 0;
		for (int x = 0; x < 9; x++) { // 가로 검사
			if ((n == map[x][j]) && (x != i)) {
				count++;
			}
		}
		for (int y = 0; y < 9; y++) { // 세로 검사
			if ((n == map[i][y]) && (y != j)) {
				count++;
			}
		}
		// 사각형 검사
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
					for (int k = 1; k < 10; k++) { // check 초기화
						can.add(k);
					}
					for (int k = 0; k < 9; k++) { // 가로 검사
						if (can.contains(map[i][k])) {
							Integer a = map[i][k];
							can.remove(a);
						}
					}
					for (int k = 0; k < 9; k++) { // 세로 검사
						if (can.contains(map[k][j])) {
							Integer a = map[k][j];
							can.remove(a);
						}
					}
					// 사각형 검사 시작
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
		for (int i = 0; i < 9; i++) { // 숫자들 저장
			for (int j = 0; j < 9; j++) {
				map[i][j] = in.nextInt();
			}
		}
		Sudoku(map); // 간단한 스도쿠 해결

		Solve(map,row,col);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println("");
		}
	}
}
