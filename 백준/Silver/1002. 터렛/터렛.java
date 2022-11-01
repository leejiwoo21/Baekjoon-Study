import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		int x1, y1, r1, x2, y2, r2; // R = 조규현과 백승환 사이의 거리
		double R= 0;
		for(int i=0; i<T; i++) {
			String[] pos = in.nextLine().split("\\s");
			x1 = Integer.valueOf(pos[0]);
			y1 = Integer.valueOf(pos[1]);
			r1 = Integer.valueOf(pos[2]);
			x2 = Integer.valueOf(pos[3]);
			y2 = Integer.valueOf(pos[4]);
			r2 = Integer.valueOf(pos[5]);
			
			if(r1 < r2) { // r1이 더 큰수가 되도록 순서를 바꾼다
				int temp = x1;
				x1 = x2;
				x2 = temp;
				temp = y1;
				y1 = y2;
				y2 = temp;
				temp = r1;
				r1 = r2;
				r2 = temp;
			}
			int r3 = r1+ r2;
			if( (x1==x2) && (y1== y2) && (r1==r2) ) {
				System.out.println(-1);
				continue;
			}
			R = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
			if(r3 < R || (r1 > R+r2)) System.out.println(0);
			else if(r3 == R || r1 == R+r2) System.out.println(1);
			else System.out.println(2);
		}
	}

}
