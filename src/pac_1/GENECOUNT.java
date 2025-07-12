package pac_1;
import java.io.*;

public class GENECOUNT {
	public static void main(String[] args) {
	
		try {
			
			File file = new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/DEL.txt");
			FileReader sequ = new FileReader(file);
			BufferedReader geneCount = new BufferedReader(sequ);
			String sequence = geneCount.readLine();
			geneCount.close();
			int count = countGenes(sequence);      
		        // Output the result
		        System.out.println("Number of genes: " + count);
		        
		        System.out.println("----------------------------------------------------------");		        
		      //Display each gene  
		      System.out.println("Gene are ");
		      displaygene(sequence);
		}
			catch(Exception e) {
				System.out.println(e);
			}
			
	    }
	
	    public static int countGenes(String sequence) {
	        int count = 0;
	        int index = 0;
	        
	        //Loop through the sequence and search for "AAT" start and "GGT" end
	        while (index < sequence.length()) {
	            //Find the start codon "AAT"
	            int start = sequence.indexOf("ATG", index);
	            
	            //If a start codon is found, find the stop codon "GGT" after it
	            if (start != -1) {
	                int end = sequence.indexOf("TAA", start + 3); // Search after the start codon
	                
	                //If a stop codon is found, it's a gene
	                if (end != -1) {
	                    count++;
	                    //Move index to the position after the stop codon for next search
	                    index = end + 3;
	                } else {
	                    break; //If no stop codon is found, stop
	                }
	            } else {
	                break; //If no start codon is found, stop
	            }
	        }
	        
	        return count;
	    }
	    //display gene function
	    public static void displaygene(String sequence) {
	        int startindex=0;
	    	int genenum=0;
	    	int max =0;
	    	int min=Integer.MAX_VALUE;
	    	
	    	while((startindex=sequence.indexOf("ATG",startindex))!=-1) {
	    		int endindex=sequence.indexOf("TAA",startindex+3);
	    		if(endindex!=1) {
	    			String gen=sequence.substring(startindex,endindex+3);
	    			
	    			System.out.println("Gene "+(++genenum)+" : "+gen);
	    			
	    			int len =gen.length();
	    			switch(genenum){
	    			case 1:	
	    				System.out.println(genenum+"st gene length : "+len+"\n");break;
	    			case 2:	
    					System.out.println(genenum+"nd gene length : "+len+"\n");break;
	    			case 3:	
    					System.out.println(genenum+"rd gene length : "+len+"\n");break;
	    			default:	
    					System.out.println(genenum+"th gene length : "+len+"\n");break;
	    			}
	    			 
	    			
	    			startindex=endindex+3;
	    			if(len>=max) {
	    				max=len;
	    				
	    			}
	    			if(len<=min) {
	    				min=len;
	    			}
	    			
	    			
	    		}
	    		else {
	    			break;
	    		 }
	    	}
	    	System.out.println("\nMaximum Gene length is : "+max);
	    	System.out.println("\nMinimum Gene length is : "+min);
	    }
	   
}
