import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		int bags = -1;
		int fives = 5 * (N/5);
		int threes = N%5;
		while(fives > 0) {
			if(fives%5 == 0 && threes%3 == 0) {
				bags = fives/5 + threes/3;
				break;
			}
			else {
				fives -= 5;
				threes += 5;
			}
		}
		if(bags == -1 && threes%3 == 0) {
			bags =  threes/3;
		}
		System.out.println(bags);
	}
}
