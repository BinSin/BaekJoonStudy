/*
 * https://www.acmicpc.net/problem/10973
 * BinSin
 */

package bruteForce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	
	public static int[] swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
		return p;
	}
	
	public static int[] prevPermutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) { // A[i-1] > A[i] 를 만족하는 가장 큰 i
			if(p[i-1] > p[i]) {
				I = i-1;
				break;
			}
		}
		if(I == -1)
			return new int[] {-1};
		
		for(int j=p.length-1; j>=0; j--) { // j >= i && A[j] < A[i-1] 를 만족하는 가장 큰 j
			if(p[j] < p[I]) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		p = prevPermutation(p);
		for(int i=0; i<p.length-1; i++) {
			bw.write(p[i] + " ");
		}
		bw.write(p[p.length-1] + "");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
