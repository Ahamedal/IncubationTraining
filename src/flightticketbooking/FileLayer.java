package flightticketbooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileLayer {
	static final String path="/home/ahmed-inc1497/Documents/AllFlights/";
	String file1="Flight-A112-Chennai-Mumbai.txt";
	String file2="Flight-A113-Chennai-Kolkata.txt";
	String file3="Flight-A114-Chennai-Delhi.txt";

	void createDirectory() {
		
		File f1=new File(path);
		boolean boo=f1.mkdir();
		
		if(boo) {
			System.out.println("Folder created successfully");
		}
		else {
			System.out.println("Error Found");
		}
		
	}
	void createFile() {
	  try(FileWriter fw=new FileWriter(path+"Flights.txt");){
		  fw.write("Flight-A1-Chennai-Mumbai\n");
		  createAndWriteFile(file1);
		  fw.write("Flight-A2-Chennai-Kolkata\n");
		  createAndWriteFile(file2);
		  fw.write("Flight-A3-Chennai-Delhi");
		  createAndWriteFile(file3);
		  
		  
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	void createAndWriteFile(String path1) {
		try(FileWriter fw=new FileWriter(path+path1);){
			fw.write("Business:{2,3,2},1\n");
			fw.write("Economy:{3,4,4},1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String readFile1(int k) {
		if(k==1) {
		String str="";
		try(BufferedReader bf=new BufferedReader(new FileReader(path+file1));){
			
			if((str=bf.readLine())!=null) {
				return str;
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(k==2) {
			String str="";
			try(BufferedReader bf=new BufferedReader(new FileReader(path+file2));){
				
				if((str=bf.readLine())!=null) {
					return str;
				}
				
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(k==3) {
			String str="";
			try(BufferedReader bf=new BufferedReader(new FileReader(path+file3));){
				
				if((str=bf.readLine())!=null) {
					return str;
				}
				
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "";
	
	}
	String readFile2(int k) {
		if(k==1) {
		String str="";
		try(BufferedReader bf=new BufferedReader(new FileReader(path+file1));){
			bf.readLine();
			if((str=bf.readLine())!=null) {
				return str;
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(k==2) {
			String str="";
			try(BufferedReader bf=new BufferedReader(new FileReader(path+file2));){
				bf.readLine();
				if((str=bf.readLine())!=null) {
					return str;
				}
				
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if(k==3) {
			String str="";
			try(BufferedReader bf=new BufferedReader(new FileReader(path+file3));){
				bf.readLine();
				if((str=bf.readLine())!=null) {
					return str;
				}
				
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	
	}
	
}
