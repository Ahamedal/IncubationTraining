package playerchessgame;

import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Chess ch=new Chess();
		ch.initialSetUp();
		//System.out.println(ch.getPosition("d7"));
		while(true) {
			
			System.out.println("Player 1 -->move whight");
			System.out.println("Enter choose any one of coin position");
			String coinPosition=sc.nextLine();
			
			List<String> position=ch.getPosition(coinPosition);
			System.out.println(position);
			boolean flag=true;
			while(flag) {
			System.out.println("Enter move position");
			String movePosition=sc.nextLine();
			
			if(ch.move(coinPosition,movePosition,position)) {
				flag=false;
			}
			else {
				System.out.println("moved position is wrong");
			}
			
			}
			System.out.println("Player 2 -->move Black");
			System.out.println("Enter choose any one of coin position");
			String coinPosition1=sc.nextLine();
			
			List<String> position1=ch.getPosition(coinPosition1);
			System.out.println(position1);
			boolean flag1=true;
			while(flag1) {
			System.out.println("Enter move position");
			String movePosition1=sc.nextLine();
			
			if(ch.move(coinPosition1,movePosition1,position1)) {
				flag1=false;
			}
			else {
				System.out.println("moved position is wrong");
			}
			
			}
		}
		
	}
}
