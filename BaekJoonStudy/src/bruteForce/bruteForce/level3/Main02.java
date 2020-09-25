/*
 * BinSin
 * https://www.acmicpc.net/problem/15661
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main02 {

	private static int N;
	private static int[][] score;
	
	private static int go(int index, List<Integer> stark, List<Integer> link) {
		if(index == N) {
			if(stark.size() == 0) return -1;
			if(link.size() == 0) return -1;
			int ss = 0;
			for(int i=0; i<stark.size(); i++) {
				for(int j=0; j<stark.size(); j++) {
					if(i == j) continue;
					ss += score[stark.get(i)][stark.get(j)];
				}
			}
			int ls = 0;
			for(int i=0; i<link.size(); i++) {
				for(int j=0; j<link.size(); j++) {
					if(i == j) continue;
					ls += score[link.get(i)][link.get(j)];
				}
			}
			return Math.abs(ss-ls);
		}
		
		int answer = -1;
		stark.add(index);
		int ss = go(index+1, stark, link);
		if(answer == -1 || (ss != -1 && answer > ss))
			answer = ss;
		stark.remove(stark.size()-1);
		
		link.add(index);
		int ls = go(index+1, stark, link);
		if(answer == -1 || (ls != -1 && answer > ls))
			answer = ls;
		link.remove(link.size()-1);
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		score = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Integer> stark = new ArrayList<>();
		List<Integer> link = new ArrayList<>();
		bw.write(go(0, stark, link) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
