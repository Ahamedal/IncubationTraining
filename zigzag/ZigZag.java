package zigzag;

import java.util.Scanner;

public class ZigZag {
	public static void main(String[] args) {
		ZigZag z=new ZigZag();
		Scanner sc=new Scanner(System.in);
		System.out.println("How many rows do you want");
		int row=sc.nextInt();
		System.out.println("How many columns do you want");
		int col=sc.nextInt();
		System.out.println("Enter values");
		int[][] mat=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		System.out.println(z.zigzag(mat, row, col).trim());
	}

	public String zigzag(int[][] mat,int m,int n) {
		int row=0;
		int col=0;
		int rows=0;
		int columns=0;
		String string="";
		for(int i=0;i<(m+n-1);i++) {
			row=rows;
			col=columns;
			if((i%2)!=0) {
				
			while(true) {
				if(row<0||row>=m||col<0||col>=n) {
					break;
				}
				
			string+=" "+mat[row][col];
			rows=row;
			columns=col;
			row++;
			col--;
			}
			if(rows+1==m) {
				columns++;
			}
			else {
			rows++;
			}
			}
			else {
			while(true) {
				if(row<0||row>=m||col<0||col>=n) {
					break;
				}
			string+=" "+mat[row][col];
			rows=row;
			columns=col;
			row--;
			col++;
			}
			if(columns+1==n) {
				rows++;
			}
			else {
			columns++;
			}
			}
			}
		return string;
	}
}
