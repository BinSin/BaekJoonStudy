/*
 * https://www.acmicpc.net/problem/14500
 * BinSin
 */

package bruteForce.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4 {
	
	static int[][][] block = { // 0,0 을 기준으로 가능한 모든 테트로미노는 19가지
			{{0,1}, {0,2}, {0,3}},
	        {{1,0}, {2,0}, {3,0}},
	        {{1,0}, {1,1}, {1,2}},
	        {{0,1}, {1,0}, {2,0}},
	        {{0,1}, {0,2}, {1,2}},
	        {{1,0}, {2,0}, {2,-1}},
	        {{0,1}, {0,2}, {-1,2}},
	        {{1,0}, {2,0}, {2,1}},
	        {{0,1}, {0,2}, {1,0}},
	        {{0,1}, {1,1}, {2,1}},
	        {{0,1}, {1,0}, {1,1}},
	        {{0,1}, {-1,1}, {-1,2}},
	        {{1,0}, {1,1}, {2,1}},
	        {{0,1}, {1,1}, {1,2}},
	        {{1,0}, {1,-1}, {2,-1}},
	        {{0,1}, {0,2}, {-1,1}},
	        {{0,1}, {0,2}, {1,1}},
	        {{1,0}, {2,0}, {1,1}},
	        {{1,0}, {2,0}, {1,-1}}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int answer = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				for(int i=0; i<19; i++) {
					int sum = arr[n][m];
					boolean check = true;
					for(int j=0; j<3; j++) {
						int x = n + block[i][j][0];
						int y = m + block[i][j][1];
						if(0 <= x && x < N && 0 <= y && y< M) {
							sum += arr[x][y];
						} else {
							check = false;
							break;
						}
					}
					if(check && answer < sum) {
						answer = sum;
					}
				}
			}
		}
		
		bw.write(answer + "");
		br.close();
		bw.flush();
		br.close();
	}
}
