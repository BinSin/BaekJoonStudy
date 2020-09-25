/*
 * BinSin
 * https://www.acmicpc.net/problem/2580
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {

	static int square(int x, int y) {
		return (x / 3) * 3 + (y / 3);
	}
	
	static boolean go(int[][] sudoku, boolean[][][] check, int z) {
		if(z == 81) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
		int x = z / 9;
		int y = z % 9;
		if(sudoku[x][y] != 0) {
			return go(sudoku, check, z+1);
		} else {
			for(int i=1; i<=9; i++) {
				if(!check[0][x][i] && !check[1][y][i] && !check[2][square(x,y)][i]) {
					check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = true;
					sudoku[x][y] = i;
					if(go(sudoku, check, z+1))
						return true;
					
					sudoku[x][y] = 0;
					check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = false;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] sudoku = new int[9][9];
		boolean[][][] check = new boolean[3][9][10];
		StringTokenizer st;
		for(int i=0; i<9; i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(n != 0) {
					check[0][i][n] = true;
					check[1][j][n] = true;
					check[2][square(i, j)][n] = true;
				}
				sudoku[i][j++] = n;
			}
		}
		
		go(sudoku, check, 0);
		
		br.close();
	}
}
