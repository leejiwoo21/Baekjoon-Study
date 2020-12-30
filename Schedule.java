
/*
 * 1. 시작하는 순서대로 배열
 * 2. 짧은 순서대로 배열
 * 3. 빨리 끝나는 순서대로 배열
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		n = in.nextInt();
		ArrayList Start = new ArrayList();
		ArrayList End = new ArrayList();
		int time = 0;
		int change = 0;
		for (int i = 0; i < n; i++) {
			time = in.nextInt();
			Start.add(time);
			time = in.nextInt();
			End.add(time);
		}

		for (int i = 0; i < n - 1; i++) {

			for (int j = i; j < n - 1; j++) {
				if ((int) End.get(i) > (int) End.get(i + 1)) {
					change = (int) End.get(i);
					End.set(i, (int) End.get(i + 1));
					End.set(i + 1, change);
					change = (int) Start.get(i);
					Start.set(i, (int) Start.get(i + 1));
					Start.set(i + 1, change);
				}
			}
		}
		
		int size = End.size();
		int number = 0;
		while (true) {
			int i = 0;
			int j = 1;
			if ((int) End.get(i) <= (int) Start.get(j)) {
				i = j;
				number++;
			} else
				j++;
			if (i + 1 == size)
				break;
		}
		System.out.printf("%d", number);
	
	}
}
