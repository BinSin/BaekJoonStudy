/*
 * https://www.acmicpc.net/problem/10974
 * BinSin
 */

package bruteForce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3 {
	
	public static int[] swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
		return p;
	}
	
	public static int factorial(int n) {
		return n == 1 ? 1 : n * factorial(n-1);
	}
	
	public static int[] nextPermutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		if(I == -1)
			return new int[] {-1};
		
		for(int j=p.length-1; j>=0; j--) {
			if(p[j] > p[I]) {
				J = j;
				break;
			}
		}
		
		swap(p, I, J);
		
		J = p.length - 1;
		
		while(I+1 < J) {
			swap(p, I+1, J);
			I++;
			J--;
		}
		
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i+1;
		}
		
		for(int i=0; i<factorial(p.length); i++) {
			for(int j=0; j<p.length; j++) {
				bw.write(p[j] + " ");
			}
			bw.write("\n");
			p = nextPermutation(p);
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
