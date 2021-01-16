import java.util.*;
import java.io.*;
public class bj_3111 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String A = br.readLine();
		String T = br.readLine();
		StringBuilder sb = new StringBuilder(T);
		while(sb.indexOf(A)!= -1)
		{
		sb.delete(sb.indexOf(A),sb.indexOf(A)+A.length());
		sb.delete(sb.lastIndexOf(A),sb.lastIndexOf(A)+A.length());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
