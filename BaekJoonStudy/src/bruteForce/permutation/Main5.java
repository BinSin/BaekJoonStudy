/*
 * https://www.acmicpc.net/problem/10971
 * BinSin
 */

package bruteForce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5 {
	
	static final int MAX = 10000000;
	
	public static int[] swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
		return p;
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
		int[][] value = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		
		int min = MAX;
		while(p[0] == 0) { // 1234, 2341, 3412, 4123 모두 같으므로 1을 시작점으로 두면 된다.
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				int val = value[p[i]][p[i+1]];
				if(val == 0) sum = MAX;
				else sum += val;
			}
			int lastVal = value[p[N-1]][p[0]];
			if(lastVal == 0) sum = MAX;
			else sum += lastVal;
			
			if(min > sum) min = sum;
			
			p = nextPermutation(p);
		}
		
		
		bw.write(min + "");
		br.close();
		bw.flush();
		bw.close();
		
	}
}
