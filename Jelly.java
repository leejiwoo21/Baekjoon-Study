
// 점프킹 쩰리
import java.util.*;

public class Jelly {

	static class Here {
		int x = 0;
		int y = 0;
		int jump = 0;

		public Here(int x, int y, int jump) {
			this.x = x;
			this.y = y;
			this.jump = jump;
		}
	}

	public static void main(String[] args) {
		Stack<Here> stack = new Stack<>();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] step = new int[N][N];
		int[][] visit = new int[N][N];
		int x = 0;
		int y = 0;
		int jump = 0;
		boolean ok = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				step[i][j] = in.nextInt();
			}
		}

		stack.push(new Here(x, y, step[x][y]));

		while (!stack.empty()) {
			Here here = stack.peek();
			x = here.x;
			y = here.y;
			jump = here.jump;

			if (jump == -1) {
				ok = true;
				break;
			}
			else if(x + step[x][y] < N && visit[x + step[x][y]][y] == 0) {
				x += step[x][y];
				stack.push(new Here(x , y, step[x][y]));
			} else if (y + step[x][y] < N && visit[x][y + step[x][y]] == 0) {
				y += step[x][y];
				stack.push(new Here(x, y, step[x][y]));
			} else {
				visit[x][y] = 1;
				stack.pop();
			}
		}
		if (ok == true) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}
}