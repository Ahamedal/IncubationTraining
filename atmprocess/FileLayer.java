package atmprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class FileLayer {
  File file=new File("ATM.txt");
  File file1=new File("Customers.txt");
	public void createAndWriteFile(ATM atm) {
		try(FileWriter fw=new FileWriter(file);) {
			fw.write("Denomination\t\t\tNumber\t\t\t\tValue\n");
			fw.write("2000\t\t\t\t"+atm.getNoOf2000()+"\t\t\t\t"+(2000*atm.getNoOf2000())+"\n");
			fw.write("500\t\t\t\t"+atm.getNoOf500()+ "\t\t\t\t"+(500*atm.getNoOf500())+"\n");
			fw.write("100\t\t\t\t"+atm.getNoOf100()+ "\t\t\t\t"+(100*atm.getNoOf100())+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ATM readFile() 
	{
		ATM atm=ATM.ATMOBJECT;
		if(file.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(file))){
		int i=0;
			bf.readLine();
			String st="";
			while((st=bf.readLine())!=null) {
				String[] ar=st.split("\t\t\t\t");
				if(i==0) {
					atm.setNoOf2000(Integer.parseInt(ar[1]));
				}
				else if(i==1) {
					atm.setNoOf500(Integer.parseInt(ar[1]));
				}
				else if(i==2) {
					atm.setNoOf100(Integer.parseInt(ar[1]));
				}
				i++;
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return atm;
	}
	public void write(Map<Integer,Customer> customers) {
		
		try(FileWriter fw=new FileWriter(file1)){
			fw.write("AccNo\t\t\t\tAccountHolder\t\t\tPinNumber\t\t\tAccountBalance");
			Set<Integer> set=customers.keySet();
			for(Integer accNo:set) {
				Customer customer=customers.get(accNo);
			    fw.write(customer.getAccNo()+"\t\t\t\t"+customer.getAccHolder()+"\t\t\t\t"+customer.getPinNumber()+"\t\t\t\t"+customer.getBalance());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
