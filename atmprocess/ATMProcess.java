package atmprocess;

import java.util.HashMap;
import java.util.Map;

public class ATMProcess {

     ATM atm=ATM.ATMOBJECT;
     FileLayer fl=new FileLayer();
     
     Map<Integer,Customer> customers=new HashMap<>();
     
     public void initialSetUp() {
    	
    	 
    	 atm=fl.readFile();
    	 
     }
    		
     public void setAtmAmount(int noOf2000,int noOf500,int noOf100) {
    	 atm.setNoOf2000(noOf2000);
    	 atm.setNoOf500(noOf500);
    	 atm.setNoOf100(noOf100);
    	 fl.createAndWriteFile(atm);
     }
     
     
     }
