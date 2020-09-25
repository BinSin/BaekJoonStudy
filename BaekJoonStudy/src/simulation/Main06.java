/*
 * BinSin
 * https://www.acmicpc.net/problem/15685
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main06 {
	
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
		boolean[][] map = new boolean[101][101];

		Pair[] dir = {new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1), new Pair(1, 0)};
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map[x][y] = true;
			List<Integer> list = new ArrayList<>();
			list.add(d);
			for(int j=1; j<=g; j++) {
				List<Integer> tmp = new ArrayList<>(list);
				Collections.reverse(tmp);
				for(int k=0; k<tmp.size(); k++) {
					tmp.set(k, (tmp.get(k)+1)%4);
				}
				list.addAll(tmp);
			}
			for(int l : list) {
				x += dir[l].x;
				y += dir[l].y;
				if(0 <= x && x <= 100 && 0 <= y && y <= 100)
					map[x][y] = true;
			}
		}
		
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					answer++;
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
