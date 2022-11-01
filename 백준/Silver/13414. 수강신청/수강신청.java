import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		LinkedHashSet<String> hash = new LinkedHashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		int K = Integer.valueOf(str[0]);
		int L = Integer.valueOf(str[1]);
		String s;

		for (int i = 0; i < L; i++) {
			s = br.readLine();
			if(hash.contains(s)) {
				hash.remove(s);
			}
			hash.add(s);
			
		}
		Iterator<String> Hash = hash.iterator();
		
		while(Hash.hasNext()) {
			bw.write(Hash.next());
			bw.newLine();
			K--;
			if(K<1) {
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}
}
