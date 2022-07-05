package playerchessgame;

import java.util.InputMismatchException;

import java.util.List;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Chess ch = new Chess();
		ch.initialSetUp();
		ch.printingBoard();

		int i = 0;

		boolean flags = true;

		while (true) {
			int choice1 = 0;
			System.out.println(ch.getRecording());
			int choice = 0;
			if (i != 0 && flags) {
				System.out.println("You like to reverse 1-Yes or 0-No");

				try {
					choice = sc.nextInt();
					sc.nextLine();

				} catch (InputMismatchException e) {
					System.out.println("Enters numbers only");
					sc.nextLine();
				}

			}
			if (choice == 1) {
				try {
					ch.reverse();
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());

				}
				System.out.println(ch.printingBoard());
			} else {
				System.out.println("Player 1 -->move white");
				String coinPosition = null;
				List<String> position = null;
				while (true) {
					System.out.println(
							"Enter choose any one of coin position or Enter Print for print board or Enter exit  for exit game");
					coinPosition = sc.nextLine();

					if (coinPosition.equals("Print")) {
						System.out.println(ch.printingBoard());
					} else if (coinPosition.equals("Exit")) {
						System.out.println("Exit the game");
						System.exit(0);
					}

					else {
						try {

							if (ch.checkPlayerMoveOppositeCoin(coinPosition, 'W')) {
								position = ch.getPosition(coinPosition);
								if (!ch.isBlockCheck(coinPosition, position, "W")) {
									System.out.println("Choose another move because king is check");
									continue;
								}
								System.out.println(position);

								if (position.size() == 0) {
									System.out.println("This coin dont move to any position");
								} else {
									break;
								}
							}

							else {
								System.out.println("choose only white coin positions");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

				}
				boolean flag = true;
				while (flag) {
					System.out.println(
							"Enter move position or Enter Print for print board or Enter exit for exit game or Enter help(coin Position--help)");
					String movePosition = sc.nextLine();
					if (movePosition.equals("Print")) {
						System.out.println(ch.printingBoard());
					} else if (coinPosition.equals("Exit")) {
						System.out.println("Exit the game");
						System.exit(0);
					} else if (movePosition.contains("help")) {
						String[] array = movePosition.split("--");
						try {
							List<String> help = ch.getHelp(array[0], "W", coinPosition);
							for (int k = 0; k < help.size(); k++) {
								System.out.println(help.get(k));
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							if (!ch.moveWhiteCheck(coinPosition, movePosition)) {
								System.out.println("Choose another move");
								continue;
							}
							if (ch.move(coinPosition, movePosition, position)) {
								System.out.println(ch.printingBoard());
								flag = false;
							} else {
								System.out.println("moved position is wrong");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				}

				try {
					if (ch.isBlackKingCheckMate() && !ch.allCoinForCheckMate("B")) {
						System.out.println("CheckMate\nWhite is win\nGame is over");
						System.exit(0);
					}
					if (ch.isBlackKingCheck()) {

						System.out.println("Now a time,Black King is Check");
					}
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}

				System.out.println("You like to reverse 1-Yes or 0-No");

				try {
					choice1 = sc.nextInt();

				} catch (InputMismatchException e) {
					// e.printStackTrace();
					System.out.println("Enters numbers only");

				}

				sc.nextLine();
			}
			if (choice1 == 1) {
				try {
					ch.reverse();
					flags = false;
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());

				}
				System.out.println(ch.printingBoard());
			} else {
				String coinPosition1 = null;
				List<String> position1 = null;

				while (true) {
					System.out.println("Player 2 -->move Black");

					System.out.println(
							"Enter choose any one of coin position or Enter Print for print board or Enter exit for exit game");
					coinPosition1 = sc.nextLine();
					if (coinPosition1.equals("Print")) {
						System.out.println(ch.printingBoard());
					} else if (coinPosition1.equals("Exit")) {
						System.out.println("Exit the game");
						System.exit(0);
					} else {
						try {

							if (ch.checkPlayerMoveOppositeCoin(coinPosition1, 'B')) {
								position1 = ch.getPosition(coinPosition1);
								if (!ch.isBlockCheck(coinPosition1, position1, "B")) {
									System.out.println("Choose another move because king is check");
									continue;
								}
								System.out.println(position1);
								if (position1.size() == 0) {
									System.out.println("This coin dont move to any position");
								} else {
									break;
								}

							} else {
								System.out.println("Choose only black coin to move");
							}
						} catch (Exception e) {
							// e.printStackTrace();
							System.out.println(e.getMessage());
						}
					}

				}
				boolean flag1 = true;
				while (flag1) {
					System.out.println(
							"Enter move position or Enter Print for print board or Enter exit for exit game or Enter help(coinpoisition--help)");
					String movePosition1 = sc.nextLine();
					if (coinPosition1.equals("Print")) {
						System.out.println(ch.printingBoard());
					} else if (coinPosition1.equals("Exit")) {
						System.out.println("Exit the game");
						System.exit(0);
					} else if (movePosition1.contains("help")) {
						String[] array = movePosition1.split("--");
						try {
							List<String> help = ch.getHelp(array[0], "B", coinPosition1);
							for (int k = 0; k < help.size(); k++) {
								System.out.println(help.get(k));
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					else {
						try {
							if (!ch.moveBlackCheck(coinPosition1, movePosition1)) {
								System.out.println("Choose another move because king is check");
								continue;
							}
							if (ch.move(coinPosition1, movePosition1, position1)) {
								System.out.println(ch.printingBoard());
								flag1 = false;
							} else {
								System.out.println("moved position is wrong");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}

				try {
					if (ch.isWhiteKingCheckMate() && !ch.allCoinForCheckMate("W")) {
						System.out.println("CheckMate\nBlack is win\nGame is over");
						System.exit(0);
					}
					if (ch.isWhiteKingCheck()) {
						System.out.println("Now a time,White King is Check");
					}
				} catch (Exception e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}

				flags = true;
				i++;
			}

		}
	}
}
