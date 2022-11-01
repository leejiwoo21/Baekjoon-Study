import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gummun2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long a = 0;
		long[] arr = new long[N];
		for(int i = 0; i< N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		boolean ok = false;
		ArrayList<Long> M = new ArrayList<>();
		long na = 0;
		for(long i =2; i<arr[0]; i++) {
			na = arr[0]%i;
			for(int j =1; j<N; j++) {
				
				if(arr[j]%i == na) {
					ok = true;
				}
				else {
					ok = false;
					break;
				}
			}
			if(ok == true) {
				M.add(i);
			}
			ok = false;
		}
		Long[] dap = M.toArray(new Long[M.size()]);
		for(int i =0; i<dap.length; i++) {
			System.out.printf("%s ",dap[i]);
		}
	}
}
