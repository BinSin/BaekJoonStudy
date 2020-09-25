/*
 * BinSin
 * https://www.acmicpc.net/problem/14502
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main03 {

	public static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs(int[][] newMap, List<Pair> virus, int N, int M) {
		Queue<Pair> q = new LinkedList<>();
		for(int i=0; i<virus.size(); i++) q.add(virus.get(i));
		
		Pair[] next = {new Pair(0, 1), new Pair(1, 0), new Pair(-1, 0), new Pair(0, -1)};
		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(Pair n : next) {
				int nx = p.x + n.x;
				int ny = p.y + n.y;
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(newMap[nx][ny] == 0) {
					q.add(new Pair(nx, ny));
					newMap[nx][ny] = 2;
				}
			}
		}
	}
	
	private static int safeSum(int[][] newMap, int N, int M) {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(newMap[i][j] == 0) sum++;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		List<Pair> blank = new ArrayList<>();
		List<Pair> virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n == 0) blank.add(new Pair(i, j));
				else if(n == 2) virus.add(new Pair(i, j));
			}
		}
		
		int answer = 0;
		for(int i=0; i<blank.size()-2; i++) {
			for(int j=i+1; j<blank.size()-1; j++) {
				for(int k=j+1; k<blank.size(); k++) {
					int[][] newMap = new int[N][M];
					for(int l=0; l<N; l++) newMap[l] = map[l].clone();
					
					newMap[blank.get(i).x][blank.get(i).y] = 1;
					newMap[blank.get(j).x][blank.get(j).y] = 1;
					newMap[blank.get(k).x][blank.get(k).y] = 1;
					bfs(newMap, virus, N, M);
					int safe = safeSum(newMap, N, M);
					answer = Math.max(answer, safe);
				}
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
