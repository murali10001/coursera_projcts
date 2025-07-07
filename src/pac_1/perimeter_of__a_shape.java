package pac_1;

import java.io.File;
import java.util.Scanner;


public class perimeter_of__a_shape {
	public static void main(String[] args) {
		
		double tot_dist=0;
		int currX=0,currY=0, prevX=0,prevY=0;
		double max=0;
		boolean isfirst=true;
		
		try {		
			
			
			File file=new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/example3.txt");
			Scanner scan =new Scanner(file);
			
			while(scan.hasNextLine()) {
				
				String line =scan.nextLine().replace(" ","");
				String[] arr=line.split(",");
			
				int x= Integer.parseInt(arr[0]);
				int y= Integer.parseInt(arr[1]);
				if(isfirst) {		
					currX=x;
					currY=y;
					isfirst=false;
				}else{		
					double dist=Math.sqrt(Math.pow(x-prevX,2)+Math.pow(y-prevY,2));
					tot_dist+=dist;
					System.out.println("The distanc between "+ prevX+","+prevY+" and "+x+","+y+" is : "+dist);
					if(dist>=max) {
						max=dist;
					}
				}	
				prevX=x;
				prevY=y;
					
			}
			
			if(!isfirst) {
				
					double dist=Math.sqrt(Math.pow(currX-prevX,2)+Math.pow(currY-prevY,2));
					System.out.println("The distanc between "+ prevX+","+prevY+" and "+currX+","+currY+" is : "+dist);
					tot_dist+=dist ;
					if(dist>=max) {
						max=dist;
					}
					
			}		
					
			scan.close();
			System.out.println();
			System.out.println("Total Perimeter : "+ tot_dist);
			System.out.println("Maximum Distance Between Points : "+ max);

			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
