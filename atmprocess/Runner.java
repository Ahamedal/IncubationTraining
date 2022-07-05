package atmprocess;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ATMProcess atmProcess = new ATMProcess();
		atmProcess.initialSetUp();
		atmProcess.showMap();
		boolean condition = true;
		while (condition) {
			int choose = 0;
			while (true) {
				try {
					System.out.println(
							"Enter 1-->Load Cash to ATM\nEnter 2-->Show CustomerDetails\nEnter 3-->ATM Operation");
					choose = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.nextLine();
				}

			}
			switch (choose) {
			case 1:
				try {
					System.out.println("Enter no Of 2000's");
					int noOf2000 = sc.nextInt();
					System.out.println("Enter no of 500's");
					int noOf500 = sc.nextInt();
					System.out.println("Enter no of 100's");
					int noOf100 = sc.nextInt();

					atmProcess.feedMoneyToATM(noOf2000, noOf500, noOf100);
				} catch (InputMismatchException e) {
					System.out.println("Enters numbers only");
				}
				break;

			case 2:
				System.out.println(atmProcess.showCustomerDetails());
				break;

			case 3:
				try {
					System.out.println("Enter Account Number");
					int accNo = sc.nextInt();
					System.out.println("Enter PinNumber");
					int pinNo = sc.nextInt();

					if (atmProcess.validateCustomer(accNo, pinNo)) {
						boolean condition2 = true;
						while (condition2) {
							System.out.println(
									"1.CheckBalance\n2.WithdrawMoney\n3.TransferMoney\n4.CheckAtmBalance\n5.MiniStateMent\n6.Cancel");
							int choice = sc.nextInt();
							switch (choice) {
							case 1:
								System.out.println("Your Balance is : " + atmProcess.getBalance(accNo));
								break;

							case 2:
								while (true) {
									System.out.println("Enter Withdrawal Amount");
									int amount = sc.nextInt();
									try {

										System.out.println(atmProcess.withdrawAmountValidation(accNo, amount));
										break;
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								break;

							case 3:
								System.out.println("Enter to accountNumber");
								int toAccNo = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter amount");
								int amount1 = sc.nextInt();
								try {
									if (amount1 <= 10000 && amount1 >= 100) {
										System.out.println(atmProcess.transferMoney(accNo, toAccNo, amount1));
									} else {
										System.out.println("Only transfer 100R-10000R");
									}
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								break;

							case 4:
								System.out.println(atmProcess.showATMBalance());
								break;

							case 5:

								List<String> lis = atmProcess.showTransactionDetails(accNo);
								System.out.println(lis.get(0));
								if (lis.size() < 12) {
									for (int i = 1; i < lis.size(); i++) {
										System.out.println(lis.get(i));
									}
								} else {
									for (int i = lis.size() - 11; i < lis.size(); i++) {
										System.out.println(lis.get(i));
									}
								}
								break;
							case 6:
								condition2 = false;

							}
						}
					} else {
						System.out.println("Your account number or pin number is wrong");
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}

	}
}
