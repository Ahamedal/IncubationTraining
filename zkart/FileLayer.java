package zkart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileLayer {
	File file1 = new File("zusers_db.txt");
	File file2 = new File("zkart_db.txt");

	public boolean checkCustomerFile() {
		if (file1.exists()) {
			return true;
		}
		return false;
	}

	public boolean checkProductFile() {
		if (file2.exists()) {
			return true;
		}
		return false;
	}

	public void writeCustomer(Map<String, Customer> customers) {
		try (FileWriter fw = new FileWriter(file1)) {
			fw.write("UserName\t\t\tEncrptedPassword\t\tName\t\t\tMobileNumber\t\t\tCredits\n");
			Set<String> customersName = customers.keySet();
			for (String name : customersName) {
				Customer custome = customers.get(name);
				fw.write(custome.getEmailId() + "\t\t\t" + custome.getEncryptedPassword() + "\t\t\t" + custome.getName()
						+ "\t\t\t" + custome.getMobileNumber() + "\t\t\t" + custome.getCredits() + "\n");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeProduct(Map<Integer, Product> products) {
		try (FileWriter fw = new FileWriter(file2)) {
			fw.write("ProductId\t\tCategory\t\tBrand\t\t\tModel\t\t\tPrice\t\t\tStock\t\t\tDiscount(%)\n");
			Set<Integer> productIds = products.keySet();
			for (int id : productIds) {
				Product product = products.get(id);
				fw.write(product.getProductId() + "\t\t\t" + product.getCategoryName() + "\t\t\t"
						+ product.getBrandName() + "\t\t\t" + product.getModelName() + "\t\t\t"
						+ product.getPriceOfProduct() + "\t\t\t" + product.getStockOfProduct() + "\t\t\t"
						+ product.getDiscount() + "\n");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<String, Customer> readCustomer() {
		Map<String, Customer> customers = new HashMap<>();
		if (file1.exists()) {
			try (BufferedReader bf = new BufferedReader(new FileReader(file1))) {
				String st = "";
				bf.readLine();
				while ((st = bf.readLine()) != null) {
					String[] ar = st.split("\t\t\t");
					Customer customer = new Customer();
					customer.setEmailId(ar[0]);
					customer.setEncryptedPassword(ar[1]);
					customer.setName(ar[2]);
					customer.setMobileNumber(Long.parseLong(ar[3]));
					customer.setCredits(Integer.parseInt(ar[4]));
					customers.put(customer.getEmailId(), customer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customers;
	}

	public Map<Integer, Product> readProduct() {
		Map<Integer, Product> products = new HashMap<>();
		if (file2.exists()) {
			try (BufferedReader bf = new BufferedReader(new FileReader(file2))) {
				String st = "";
				bf.readLine();
				while ((st = bf.readLine()) != null) {
					String[] ar = st.split("\t\t\t");
					Product product = new Product();
					product.setProductId(Integer.parseInt(ar[0]));
					product.setCategoryName(ar[1]);
					product.setBrandName(ar[2]);
					product.setModelName(ar[3]);
					product.setPriceOfProduct(Integer.parseInt(ar[4]));
					product.setStockOfProduct(Integer.parseInt(ar[5]));
					product.setDiscount(Integer.parseInt(ar[6]));
					products.put(product.getProductId(), product);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

	public String printItems() {
		String an = "";
		if (file2.exists()) {
			try (BufferedReader bf = new BufferedReader(new FileReader(file2))) {
				String st = "";
				while ((st = bf.readLine()) != null) {
					an += st + "\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return an;
	}

	public String printItemsLessStock() {
		String an = "";
		if (file2.exists()) {
			try (BufferedReader bf = new BufferedReader(new FileReader(file2))) {
				String st = "";
				st = bf.readLine();

				while ((st = bf.readLine()) != null) {
					String[] ar = st.split("\t\t\t");
					if (Integer.parseInt(ar[5]) < 10) {
						an += st + "\n";
					}
				}
				if (an.equals("")) {
					return "No Less Stock Product";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return an;
	}

}
