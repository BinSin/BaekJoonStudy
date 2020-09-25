/*
 * BinSin
 * https://www.acmicpc.net/problem/15686
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

public class Main06 {
	
	static int N;
	static int M;
	static int[][] map;
	static List<Pair> house;
	static List<Pair> chicken;
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	static boolean nextPermutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		
		if(I == -1) return false;
		
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
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n == 1) house.add(new Pair(i, j));
				else if(n == 2) chicken.add(new Pair(i, j));
			}
		}

		int[] p = new int[chicken.size()];
		for(int i=p.length-1; i>=p.length-M; i--) p[i] = 1;
		int answer = N * N * N;
		do {
			int sum = 0;
			for(Pair h : house) {
				int min = N * N;
				for(int i=0; i<chicken.size(); i++) {
					if(p[i] == 0) continue;
					Pair c = chicken.get(i);
					int dx = Math.abs(h.x-c.x);
					int dy = Math.abs(h.y-c.y);
					min = Math.min(min, dx + dy);
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
		} while(nextPermutation(p));
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
