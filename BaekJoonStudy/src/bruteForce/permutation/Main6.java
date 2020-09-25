/*
 * https://www.acmicpc.net/problem/6603
 * BinSin
 */

package bruteForce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main6 {
	
	public static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	public static int[] nextPermutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		
		if(I == -1) return new int[] {-1};
		
		for(int j=p.length-1; j>0; j--) {
			if(p[j] > p[I]) {
				J = j;
				break;
			}
		}
		swap(p, I, J);
		
		J = p.length - 1;
		while(I < J) {
			swap(p, I+1, J);
			I++;
			J--;
		}
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			int[] lotto = new int[n];
			for(int i=0; i<n; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] p = new int[n];
			for(int i=0; i<6; i++) {
				p[i] = 0;
			}
			for(int i=6; i<n; i++) {
				p[i] = 1;
			}
			while(p[0] != -1) {
				for(int i=0; i<n; i++) {
					if(p[i] == 0) bw.write(lotto[i] + " ");
				}
				bw.write("\n");
				p = nextPermutation(p);
			}
			if(p[0] == -1)
				bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
