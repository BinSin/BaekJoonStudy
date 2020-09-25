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
import java.util.StringTokenizer;

public class Main6 {
	
	static int N;
	static int[][] S;
	
	public static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
		if(index == N) {
			if(first.size() != N/2) return -1;
			if(second.size() != N/2) return -1;
			int stark = 0;
			int link = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					if(i == j) continue;
					stark += S[first.get(i)][first.get(j)];
					link += S[second.get(i)][second.get(j)];
				}
			}
			int dif = Math.abs(stark - link);
			return dif;
		}
		
		int ans = -1;
		first.add(index);
		int stark = go(index+1, first, second);
		if(ans == -1 || (stark != -1 && ans > stark)) {
			ans = stark;
		}
		first.remove(first.size() - 1);
		
		second.add(index);
		int link = go(index+1, first, second);
		if(ans == -1 || (link != -1 && ans > link)) {
			ans = link;
		}
		second.remove(second.size() - 1);
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		bw.write(go(0, first, second) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
