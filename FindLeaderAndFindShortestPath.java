package findleader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindLeaderAndFindShortestPath {
	static int k = 1;
	static int leaderPosition = 0;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many rows do you want");
		int rows = sc.nextInt();
		sc.nextLine();
		System.out.println("How many columns do you want");
		int columns = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter values");
		int[][] matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[rows][columns];
		List<Integer> ans = new ArrayList<>();
		int[][] temp = new int[rows][columns];
		FindLeaderAndFindShortestPath fl = new FindLeaderAndFindShortestPath();
		fl.countBuildings(matrix, ans, visited, rows, columns, temp); // for leader
		int leader= fl.leaderOfGroup(ans);
		System.out.println("Leader of the group is " + leader);

		for (int i = 0; i < ans.size(); i++) {
			if (leader == ans.get(i)) {
				leaderPosition = i + 1;
				break;
			}
		}
		for (int i = 1; i <= ans.size(); i++) {
			map.put(i, 1000); // For shortestPath
		}
		fl.findShortest(temp);
		fl.print(leader, ans);

	}

	static int sum = 0;

	public void countBuildings(int[][] mat, List<Integer> ans, boolean[][] visited, int row, int col, int[][] temp) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (mat[i][j] != 0 && !visited[i][j]) {

					DFS(mat, i, j, visited, row, col, temp);
					ans.add(sum);
					k++;
					sum = 0;
				}

			}
		}
	}

	public void DFS(int[][] mat, int row, int col, boolean[][] visited, int rows, int columns, int[][] temp) {
		int rowNbr[] = { -1, 0, 0, 1 }; // Move 4 direction
		int colNbr[] = { 0, -1, 1, 0 };
		visited[row][col] = true;

		temp[row][col] = k;
		sum = sum + mat[row][col]; // Depth First Search

		for (int k = 0; k < 4; k++) {
			if (isSafe(mat, row + rowNbr[k], col + colNbr[k], visited, rows, columns)) {
				DFS(mat, row + rowNbr[k], col + colNbr[k], visited, rows, columns, temp);
			}
		}
	}

	public boolean isSafe(int[][] mat, int row, int col, boolean[][] visited, int rows, int columns) {
		if (row >= 0 && row < rows && col >= 0 && col < columns && (mat[row][col] != 0 && !visited[row][col])) {
			return true;
		}
		return false;
	}

	public int leaderOfGroup(List<Integer> ans) {

		int a = ans.get(0);

		for (int i = 0; i < ans.size(); i++) {

			if (a < ans.get(i)) {
				a = ans.get(i);
			}

		}

		return a;

	}

	public void findShortest(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {

				if (temp[i][j] == leaderPosition) {

					for (int k = 0; k < temp.length; k++) {
						for (int l = 0; l < temp[0].length; l++) {

							if (temp[k][l] > 0 && temp[k][l] != leaderPosition) {
								int distance = calculateDistance(i, j, k, l);
								int val = map.get(temp[k][l]);

								if (distance < val) {
									map.put(temp[k][l], distance);
								}
							}
						}
					}
				}
			}
		}
	}

	public int calculateDistance(int i, int j, int k, int l) {
		int x = 0;
		if (i > k) {
			x += i - k;
		} else {
			x += k - i;
		}
		if (j > l) {
			x += j - l - 1;

		} else {
			x += l - j - 1;
		}
		return x;
	}

	public void print(int z, List<Integer> ans) {
		System.out.println("Shortest path is :");
		for (int i = 1; i <= ans.size(); i++) {
			if (leaderPosition != i) {
				System.out.println("{" + z + "} to {" + ans.get(i - 1) + "} is " + map.get(i));
			}
		}
	}

}
