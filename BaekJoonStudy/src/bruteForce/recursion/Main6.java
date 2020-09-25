/*
 * https://www.acmicpc.net/problem/14888
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main6 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void go(int[] A, int[] oper, int result, int i) {
		if(i == A.length) {
			if(result < min) {
				min = result;
			}
			if(result > max) {
				max = result;
			}
			return;
		}
		
		if(oper[0] > 0) {
			oper[0]--;
			go(A, oper, result + A[i], i+1);
			oper[0]++; 
		}
		if(oper[1] > 0) {
			oper[1]--;
			go(A, oper, result - A[i], i+1);
			oper[1]++;
		}
		if(oper[2] > 0) {
			oper[2]--;
			go(A, oper, result * A[i], i+1);
			oper[2]++;
		}
		if(oper[3] > 0) {
			oper[3]--;
			go(A, oper, result / A[i], i+1);
			oper[3]++;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		go(A, oper, A[0], 1);
		
		bw.write(max + "\n");
		bw.write(min + "");
		br.close();
		bw.flush();
		bw.close();
	}
}
