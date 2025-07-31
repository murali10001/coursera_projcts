package pac_1;

import java.io.File;
import java.util.Scanner;


public class perimeter_of__a_shape {
	public static void main(String[] args) {
		
		double tot_dist=0;
		int x=0,y=0, prevX=0,prevY=0;
		double max=0;
		boolean isfirst=true;
		
		try {		
			
			
			File file=new File("C:/Users/manis/eclipse-workspace/coursera_project/src/pac_1/datatest/datatest4.txt");
			Scanner scan =new Scanner(file);
			
			while(scan.hasNextLine()) {
				
				String line =scan.nextLine().replace(" ","");
				String[] arr=line.split(",");
			
				int currX= Integer.parseInt(arr[0]);
				int currY= Integer.parseInt(arr[1]);
				if(isfirst) {		
					x=currX;
					y=currY;
					isfirst=false;
				}else{		
					double dist=Math.sqrt(Math.pow(currX-prevX,2)+Math.pow(currY-prevY,2));
					tot_dist+=dist;
					System.out.println("The distanc between "+ prevX+","+prevY+" and "+currX+","+currY+" is : "+dist);
					if(dist>=max) {
						max=dist;
					}
				}	
				prevX=currX;
				prevY=currY;
					
			}
			
			if(!isfirst) {
				
					double dist=Math.sqrt(Math.pow(x-prevX,2)+Math.pow(y-prevY,2));
					System.out.println("The distanc between "+ prevX+","+prevY+" and "+x+","+y+" is : "+dist);
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
