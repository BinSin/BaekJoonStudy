/*
 * BinSin
 * https://www.acmicpc.net/problem/14889
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5 {
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] perm = new int[N];
		for(int i=0; i<N/2; i++) {
			perm[i] = 1;
		}
		Arrays.sort(perm);
		
		int min = 2000;
		do {
			ArrayList<Integer> first = new ArrayList<>();
			ArrayList<Integer> second = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(perm[i] == 0) {
					first.add(i);
				} else {
					second.add(i);
				}
			}
			
			int stark = 0;
			int link = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					if(i == j) continue;
					stark += S[first.get(i)][first.get(j)];
					link += S[second.get(i)][second.get(j)];
				}
			}
			
			int score = Math.abs(stark - link);
			if(score < min) min = score;
			if(min == 0) break;
		} while(next_permutation(perm));
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
