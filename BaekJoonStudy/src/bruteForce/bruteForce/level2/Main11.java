/*
 * BinSin
 * https://www.acmicpc.net/problem/1987
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11 {
	
	static int answer = 0;
	
	static class Pair {
		int r, c;
		
		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void go(char[][] board, boolean[] check, int r, int c, int count) {
		if(answer < count) answer = count;
		Pair[] p = {new Pair(r-1, c), new Pair(r+1, c), new Pair(r, c-1), new Pair(r, c+1)};
		for(int i=0; i<4; i++) {
			int nr = p[i].r;
			int nc = p[i].c;
			if(0 <= nr && nr < board.length && 0 <= nc && nc < board[0].length) {
				if(!check[board[nr][nc] - 'A']) {
					check[board[nr][nc] - 'A'] = true;
					go(board, check, nr, nc, count+1);
					check[board[nr][nc] - 'A'] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				board[r][c] = s.charAt(c);
			}
		}
		
		int count = 0;
		boolean[] check = new boolean[26];
		check[board[0][0] - 'A'] = true;
		count++;
		go(board, check, 0, 0, count);
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
