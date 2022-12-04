import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력
		int N = Integer.valueOf(br.readLine());
		BigInteger M = new BigInteger("1234567891");
		String line = br.readLine();
		BigInteger hash= new BigInteger("0");
		for(int i=0; i<N; i++) {
			BigInteger a = new BigInteger(String.valueOf((line.charAt(i) -96)));
			BigInteger n = BigPow(31,i);
			hash = hash.add(a.multiply(n));
		}
		System.out.print(hash.remainder(M));
	}
	
	private static BigInteger BigPow(int r, int i) {
		BigInteger R = new BigInteger(String.valueOf(r));
		BigInteger result = new BigInteger("1");
		while(i-->0) {
			result = result.multiply(R);
		}
		return result;
	}
}
