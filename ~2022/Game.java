import java.util.*;

public class Game {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long x1 = in.nextInt();
		long y1 = in.nextInt();
		long z1 = (y1*100)/x1;
		long a = 1;
		long b = 1000000000;
		long z2 = 0;
		long x2 = 0;
		long y2 = 0;
		long mid = 0;
		if (99 <= z1) { // 0³ª´©±â ¹æÁö
			System.out.println(-1);
		} else {
			while (a<=b) {
				mid = (a + b) / 2;
				x2 = x1 + mid;
				y2 = y1 + mid;
				z2 = (y2*100/x2);
				if (z1 < z2) {
					b = mid-1;
				}
				else {
					a = mid+1;
				}
			}
			System.out.println(a);
		}
	}

}
