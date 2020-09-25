/*
 * BinSin
 * https://www.acmicpc.net/problem/14890
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			boolean[] c = new boolean[N];
			boolean check = true;
			for(int j=1; j<N; j++) {
				if(map[i][j-1] < map[i][j]) {
					if(j-L < 0) {
						check = false;
						break;
					}
					for(int k=1; k<=L; k++) {
						if(!c[j-k] && map[i][j] == map[i][j-k]+1) {
							c[j-k] = true;
						} else {
							check = false;
							break;
						}
					}
				} else if(map[i][j-1] > map[i][j]) {
					if(j+L > N) {
						check = false;
						break;
					}
					for(int k=0; k<L; k++) {
						if(!c[j+k] && map[i][j-1] == map[i][j+k]+1) {
							c[j+k] = true;
						} else {
							check = false;
							break;
						}
					}
					if(!check) break;
					j += L-1;
				}
				if(!check) {
					break;
				}
			}
			if(check) {
				answer++;
			}
		}
		
		for(int i=0; i<N; i++) {
			boolean[] c = new boolean[N];
			boolean check = true;
			for(int j=1; j<N; j++) {
				if(map[j-1][i] < map[j][i]) {
					if(j-L < 0) {
						check = false;
						break;
					}
					for(int k=1; k<=L; k++) {
						if(!c[j-k] && map[j][i] == map[j-k][i]+1) {
							c[j-k] = true;
						} else {
							check = false;
							break;
						}
					}
				} else if(map[j-1][i] > map[j][i]) {
					if(j+L > N) {
						check = false;
						break;
					}
					for(int k=0; k<L; k++) {
						if(!c[j+k] && map[j-1][i] == map[j+k][i]+1) {
							c[j+k] = true;
						} else {
							check = false;
							break;
						}
					}
					if(!check) break;
					j += L-1;
				}
				if(!check) {
					break;
				}
			}
			if(check) {
				answer++;
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
