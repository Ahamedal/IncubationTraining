package playerchessgame;

import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Chess ch = new Chess();
		ch.initialSetUp();
		// System.out.println(ch.getPosition("d7"));

		while (true) {
			System.out.println(ch.getRecording());
			System.out.println("Player 1 -->move whight");
			String coinPosition = null;
			List<String> position = null;
			while (true) {
				System.out.println("Enter choose any one of coin position or Enter Print for print board or Enter exit for exit game");
				coinPosition = sc.nextLine();

				if (coinPosition.equals("Print")) {
					System.out.println(ch.printingBoard());
				} else if (coinPosition.equals("Exit")) {
					System.out.println("Exit the game");
					System.exit(0);
				} else {
					if (ch.checkPlayerMoveOppositeCoin(coinPosition, 'W')) {
						position = ch.getPosition(coinPosition);
						System.out.println(position);

						if (position.size() == 0) {
							System.out.println("This coin dont move to any position");
						} else {
							break;
						}
					} else {
						System.out.println("choose only white coin positions");
					}
				}

			}
			boolean flag = true;
			while (flag) {
				System.out.println("Enter move position or Enter Print for print board or Enter exit for exit game");
				String movePosition = sc.nextLine();
				if (movePosition.equals("Print")) {
					System.out.println(ch.printingBoard());
				} else if (coinPosition.equals("Exit")) {
					System.out.println("Exit the game");
					System.exit(0);
				} else {
					if (ch.move(coinPosition, movePosition, position)) {
						System.out.println(ch.printingBoard());
						flag = false;
					} else {
						System.out.println("moved position is wrong");
					}

				}
			}
			System.out.println("Player 2 -->move Black");
			String coinPosition1 = null;
			List<String> position1 = null;
			while (true) {
				System.out.println("Enter choose any one of coin position or Enter Print for print board or Enter exit for exit game");
				coinPosition1 = sc.nextLine();
				if (coinPosition.equals("Print")) {
					System.out.println(ch.printingBoard());
				} else if (coinPosition.equals("Exit")) {
					System.out.println("Exit the game");
					System.exit(0);
				} else {
					if (ch.checkPlayerMoveOppositeCoin(coinPosition1, 'B')) {
						position1 = ch.getPosition(coinPosition1);
						System.out.println(position1);
						if (position.size() == 0) {
							System.out.println("This coin dont move to any position");
						} else {
							break;
						}
					} else {
						System.out.println("Choose only black coin to move");
					}
				}
			}
			boolean flag1 = true;
			while (flag1) {
				System.out.println("Enter move position or Enter Print for print board or Enter exit for exit game");
				String movePosition1 = sc.nextLine();
				if (coinPosition.equals("Print")) {
					System.out.println(ch.printingBoard());
				} else if (coinPosition.equals("Exit")) {
					System.out.println("Exit the game");
					System.exit(0);
				} else {
					if (ch.move(coinPosition1, movePosition1, position1)) {
						System.out.println(ch.printingBoard());
						flag1 = false;
					} else {
						System.out.println("moved position is wrong");
					}
				}
			}
		}

	}
}
