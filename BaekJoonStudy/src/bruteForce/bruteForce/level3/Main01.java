/*
 * BinSin
 * https://www.acmicpc.net/problem/14500
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main01 {

	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pair[][] c = {
				{new Pair(0, 0), new Pair(0, 1), new Pair(1, 0), new Pair(1, 1)}, // 1
				{new Pair(0, 0), new Pair(0, 1), new Pair(0, 2), new Pair(0, 3)}, // 2
				{new Pair(0, 0), new Pair(1, 0), new Pair(2, 0), new Pair(3, 0)}, 
				{new Pair(0, 0), new Pair(1, 0), new Pair(2, 0), new Pair(2, 1)}, // 3
				{new Pair(1, 0), new Pair(1, 1), new Pair(1, 2), new Pair(0, 2)},
				{new Pair(0, 0), new Pair(0, 1), new Pair(1, 1), new Pair(2, 1)},
				{new Pair(0, 0), new Pair(0, 1), new Pair(1, 0), new Pair(0, 2)},
				{new Pair(0, 1), new Pair(1, 1), new Pair(2, 1), new Pair(2, 0)},
				{new Pair(0, 0), new Pair(0, 1), new Pair(0, 2), new Pair(1, 2)},
				{new Pair(0, 0), new Pair(0, 1), new Pair(1, 0), new Pair(2, 0)},
				{new Pair(0, 0), new Pair(1, 0), new Pair(1, 1), new Pair(1, 2)},
				{new Pair(0, 0), new Pair(1, 0), new Pair(1, 1), new Pair(2, 1)}, // 4
				{new Pair(1, 0), new Pair(1, 1), new Pair(0, 1), new Pair(0, 2)},
				{new Pair(0, 1), new Pair(1, 1), new Pair(1, 0), new Pair(2, 0)}, 
				{new Pair(0, 0), new Pair(0, 1), new Pair(1, 1), new Pair(1, 2)},
				{new Pair(0, 0), new Pair(0, 1), new Pair(0, 2), new Pair(1, 1)}, // 5
				{new Pair(0, 0), new Pair(1, 0), new Pair(2, 0), new Pair(1, 1)},
				{new Pair(1, 0), new Pair(1, 1), new Pair(1, 2), new Pair(0, 1)},
				{new Pair(1, 0), new Pair(0, 1), new Pair(1, 1), new Pair(2, 1)}
		};
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				for(int x=0; x<19; x++) {
					int sum = 0;
					boolean check = false;
					for(int y=0; y<4; y++) {
						int nx = i+c[x][y].x;
						int ny = j+c[x][y].y;
						if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
							check = true;
							break;
						}
						sum += map[nx][ny];
					}
					if(check) continue;
					max = Math.max(max, sum);
				}
			}
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
