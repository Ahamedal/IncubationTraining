package zkart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ZKart objForLogic = new ZKart();
		try {
			objForLogic.initialSetUp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		boolean condition = true;
		while (condition) {
			System.out.println("1.Customer Signup \n2.Login\n3.Admin login\n4.Exit");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {

			case 1:
				try {
					boolean condition2 = true;
					Customer cus = new Customer();
					String emailId = null;
					while (condition2) {
						System.out.println("Enter your EmailId/UserName");
						emailId = sc.nextLine();
						if (objForLogic.existCustomer(emailId)) {
							System.out.println("Your emailId is already exist");
						} else {
							cus.setEmailId(emailId);
							condition2 = false;
						}

					}
					System.out.println("Enter your name");
					String name = sc.nextLine();
					cus.setName(name);
					System.out.println("Enter Your MobileNo");
					long mNo = sc.nextLong();
					sc.nextLine();
					cus.setMobileNumber(mNo);
					boolean condition3 = true;
					while (condition3) {
						boolean condition6 = true;
						String passWord = null;
						while (condition6) {
							System.out.println("Enter Password");
							passWord = sc.nextLine();
							if (objForLogic.checkPasswordCritteria(passWord)) {
								condition6 = false;
							} else {
								System.out.println(
										"Password complexity of mandating atleast 1 lowercase,1 uppercase and 1 numbers");
							}
						}
						System.out.println("Enter retype above password");
						String reType = sc.nextLine();
						if (objForLogic.checkPassword(passWord, reType)) {

							cus.setEncryptedPassword(objForLogic.encryptPass(passWord));
							condition3 = false;
						} else {
							System.out.println("Your password is not matching");
						}
					}

					objForLogic.addCustomer(cus);
					System.out.println("Signup successfully");
				}
				catch(InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.nextLine();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println("Enter your emailId");
					String emailId1 = sc.nextLine();
					System.out.println("Enter your password");
					String pass = sc.nextLine();
					if (!objForLogic.loginCheck(emailId1, pass)) {
						System.out.println("your emailId or password is wrong");
					} else {
						boolean condition5 = true;
						while (condition5) {
							System.out.println("1.shopping 2.orderHistory 3.Exit");
							int sel3 = sc.nextInt();
							sc.nextLine();
							switch (sel3) {
							case 1:
								boolean condition4 = true;

								List<Integer> listOfKart = new ArrayList<>();
								List<Integer> noOfNeeds = new ArrayList<>();

								while (condition4) {
									System.out.println(objForLogic.getZKart());
									System.out.println("Enter productId");
									int sel1 = sc.nextInt();
									sc.nextLine();
									System.out.println("How many do you want");
									int sel7 = sc.nextInt();
									sc.nextLine();
									listOfKart.add(sel1);
									noOfNeeds.add(sel7);

									System.out.println("Enter Continue Shopping Enter true or false ");
									condition4 = sc.nextBoolean();

								}

								int invoice = objForLogic.generateInvoice();
								objForLogic.checkOutCard(listOfKart, noOfNeeds);
								sc.nextLine();
								System.out.println("Is wishes to use credit Yes/No");
								String choice1 = sc.nextLine();
								int credit = 0;
								if (choice1.startsWith("Y") || choice1.startsWith("y")) {
									while (true) {
										System.out.println("Enter how many credits are used");
										credit = sc.nextInt();
										sc.nextLine();
										if (objForLogic.checkCredit(emailId1, credit)) {

											break;
										} else {
											System.out.println("you dont have that credits");
										}
									}
								}
								System.out.println("Your unique voice number is " + invoice);

								int totalAmount = 0;

								if (listOfKart.size() != 0) {

									System.out.println("Your orderDetails\n");
									for (int i = 0; i < listOfKart.size(); i++) {

										totalAmount += (objForLogic.getProduct(listOfKart.get(i)).getPriceOfProduct()
												* noOfNeeds.get(i));

										System.out.println(
												objForLogic.getProduct(listOfKart.get(i)) + "=" + noOfNeeds.get(i));
									}

									System.out.println("Your totalAmount is " + (totalAmount - credit));
									objForLogic.reduceCredit(emailId1, credit);

									objForLogic.addOrderHistory(emailId1, listOfKart, noOfNeeds, credit,
											objForLogic.addCredit(emailId1, totalAmount));
								} else {
									System.out.println("Your ordered product is not avilable");
								}
								break;

							case 2:
								System.out.println(objForLogic.getOrderHistory(emailId1));
								break;

							case 3:
								condition5 = false;

								break;

							}
						}
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.nextLine();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:

				System.out.println("Enter your loginId/emailId");
				String emailId6 = sc.nextLine();
				System.out.println("Enter your password");
				String password = sc.nextLine();
				boolean condition13 = true;
				while (condition13) {
					try {
						if (objForLogic.adminLoginCheck(emailId6, password)) {
							System.out.println(
									"1.Show to display items 2.Show to display less than or equal to(10) 3.reOrder 4.Update discount of item 5.exit");
							int see = sc.nextInt();
							sc.nextLine();
							switch (see) {
							case 1:
								System.out.println(objForLogic.printItems());
								break;
							case 2:

								String temp = objForLogic.printItemsLessStock();
								if (!temp.startsWith("No")) {
									System.out.println(
											"ProductId\t\tCategory\t\tBrand\t\t\tModel\t\t\tPrice\t\t\tStock\t\t\tDiscount\n");
								}
								System.out.println(temp);
								break;
							case 3:

								while (true) {
									System.out.println("Enter product Id");
									int prodId = sc.nextInt();
									sc.nextLine();
									Product product = objForLogic.getProduct(prodId);
									System.out.println("How many stock to add this product");
									int stock = sc.nextInt();
									sc.nextLine();
									objForLogic.addStock(product, stock);
									System.out.println("Enter continue to reorder Yes or No");
									String choice = sc.nextLine();
									if (choice.startsWith("N") || choice.startsWith("n")) {
										break;
									}

								}

								break;

							case 4:
								System.out.println("Enter productId");
								int product = sc.nextInt();
								sc.nextLine();
								System.out.println(objForLogic.getProduct(product));
								System.out.println("Enter Discount");
								int discount = sc.nextInt();
								sc.nextLine();
								objForLogic.updateDiscount(product, discount);
								break;
							case 5:
								condition13 = false;
								break;

							}

						} else {
							System.out.println("Your emailId and password is wrong");
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Enter numbers only");
						sc.nextLine();
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				break;
			case 4:
				condition = false;
			}
		}
	}
}
