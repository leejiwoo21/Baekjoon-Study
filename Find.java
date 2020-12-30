import java.util.Scanner;
import java.util.Arrays;

public class Find {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}
		Arrays.sort(list);
		int m = in.nextInt();
		int a = 0;
		int b = n;
		int k = 0;
		int index = 0;
		for (int i = 0; i < m; i++) {
			index = in.nextInt();
			k = (a + b) / 2;
			while (true) {
				if (index == list[k]) {
					System.out.println(1);
					break;
				} else if (list[a] == list[k] || list[b] == list[k]) {
					System.out.println(0);
					break;
				} else if (index < list[k]) {
					b = k;
				} else if (index > list[k]) {
					a = k;
				}		

			}
		}

	}

}
