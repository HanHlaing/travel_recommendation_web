package com.hhm.tr;

public class Test {

	public static void main(String []args){

        String s = "hello";
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        int bitLength = 8;// change 7 if you want to 7 bit
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < bitLength; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        System.out.println("'" + s + "' to  binary ( "+bitLength+"-bit ): " + binary);
        
        /*******************************/
        String[] binaryArray=binary.toString().split(" ");
        int arrLength=binaryArray.length;
        StringBuilder sevenBinary = new StringBuilder();
        String extraBitHolder="";
        int index=0;
        int range=0;
        String lastindex="";
        for(int i=arrLength-1; i>=0; i--) {
        	
        		String origin=binaryArray[index].substring(0,bitLength-(index+1));
        		String extraBit=binaryArray[index].substring(bitLength-(index+1));
        		
        		if(extraBit.length()==7) {
        			
        			sevenBinary.append(extraBit+" ");
        			extraBitHolder= "";    
        		}else {
        			
        			sevenBinary.append(swap(extraBitHolder,extraBit)+origin+" ");
        			extraBitHolder= extraBit;    
        		}
        		
        		 
        		if(index < 6)
        			index++;
        		else
        			index =0;
        		
        		range++;
        		
        		if(range==arrLength) {
        			
        		lastindex=extraBit;
        	
        		}
        }
        
        String lastBit=lastindex;
        for(int j=0;j<(7-lastindex.length());j++) {
			lastBit+="0";
		}
        sevenBinary.append(lastBit+" ");
        System.out.println("Seven bit binary : "+sevenBinary);
        
        /*******************************/
        
        String[] decimalArray=sevenBinary.toString().split(" ");
        StringBuilder decimalData = new StringBuilder();
      
        for(int i=0;i<decimalArray.length;i++) {
        	
        		decimalData.append(Integer.parseInt(decimalArray[i],2)+" ");          
        }
        
        	
        System.out.println("Decimal data : "+decimalData);  
        
        
        /*******************************/
        
     
    }
	
	 public static String swap(String s1, String s2) 
	    { 
	        String temp = s1; 
	        s1 = s2; 
	        s2 = temp; 
	        return s2;
	    } 

}
