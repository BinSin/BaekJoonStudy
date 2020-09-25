/*
 * BinSin
 * https://www.acmicpc.net/problem/2529
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	
	public static boolean prev_permutation(int[] p) {
		int i = p.length - 1;
		
		while(i > 0 && p[i-1] <= p[i]) {
			i--;
		}
		
		if(i <= 0)
			return false;
		
		int j = p.length - 1;
		while(p[i-1] <= p[j]) {
			j--;
		}
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		j = p.length - 1;
		while(i < j) {
			tmp = p[i];
			p[i++] = p[j];
			p[j--] = tmp;
		}
		
		return true;
	}
	
	public static boolean next_permutation(int[] p) {
		int i = p.length - 1;
		
		while(i > 0 && p[i-1] >= p[i]) {
			i--;
		}
		
		if(i <= 0)
			return false;
		
		int j = p.length - 1;
		while(p[i-1] >= p[j]) {
			j--;
		}
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		j = p.length - 1;
		while(i < j) {
			tmp = p[i];
			p[i++] = p[j];
			p[j--] = tmp;
		}
		
		return true;
	}
	
	public static boolean check(int[] perm, char[] sign) {
		for(int i=0; i<sign.length; i++) {
			if(sign[i] == '<' && perm[i] > perm[i+1]) {
				return false;
			}
			if(sign[i] == '>' && perm[i] < perm[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] sign = new char[k];
		for(int i=0; i<k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		int[] big = new int[k+1];
		int[] small = new int[k+1];
		for(int i=0; i<=k; i++) {
			big[i] = 9-i;
			small[i] = i;
		}
		
		do {
			if(check(big, sign)) break;
		} while(prev_permutation(big));
		
		do {
			if(check(small, sign)) break;
		} while(next_permutation(small));
		
		String max = "", min = "";
		for(int i=0; i<=k; i++) {
			max += big[i];
			min += small[i];
		}
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
		br.close();
	}
}
