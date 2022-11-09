import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 

public class Main {

	public static void main(String[] args) {
		int arr[] = new int[20000];
		for(int i=1; i<10001; i++) {
			if(i<10) {
				arr[i+i] += 1;
			}
			else if(i<100) {
				arr[i+i%10+(i/10)]+=1;
			}
			else if(i<1000) {
				arr[i+i/100+(i%100/10)+i%10]+=1;
			}
			else if(i<10000) {
				arr[i+i/1000+(i%1000/100)+(i%1000%100/10)+(i%10)]+=1;
			}
		}
		for(int i=1; i<10000; i++) {
			if(arr[i] ==0) {
				System.out.println(i);
			}
		}
	}
}
