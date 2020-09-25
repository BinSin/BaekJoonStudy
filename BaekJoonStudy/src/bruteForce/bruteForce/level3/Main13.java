/*
 * BinSin
 * https://www.acmicpc.net/problem/16197
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main13 {
	
	static int N;
	static int M;
	static char[][] board;
	static Pair[] next = {new Pair(0, -1), new Pair(0, 1), new Pair(-1, 0), new Pair(1, 0)};
	static int answer = 11;
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void go(int index, Pair a, Pair b) {
		if(index > 10) return;
		for(Pair n : next) {
			Pair an = new Pair(a.x+n.x, a.y+n.y);
			Pair bn = new Pair(b.x+n.x, b.y+n.y);
			int check = 0;
			if(an.x < 0 || an.x >= N || an.y < 0 || an.y >= M) check++;
			if(bn.x < 0 || bn.x >= N || bn.y < 0 || bn.y >= M) check++;
			if(check == 0) {
				if(board[an.x][an.y] == '#') an = a;
				if(board[bn.x][bn.y] == '#') bn = b;
                if(an == a && bn == b) continue;
				go(index+1, an, bn);
			} else if(check == 1) {
				answer = Math.min(answer, index+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		Pair a = new Pair(0, 0);
		Pair b = new Pair(0, 0);
		boolean check = false;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				board[i][j] = c;
				if(!check && c == 'o') {
					a = new Pair(i, j);
					check = !check;
				}
				else if(check && c == 'o') b = new Pair(i, j);
			}
		}
		go(0, a, b);
		bw.write((answer != 11 ? answer : -1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}