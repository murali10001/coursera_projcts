package pac_1;
/*import edu.duke.*;
import java.awt.Point;
import edu.duke.FileResource;
import edu.duke.Shape;
*/

import java.io.*;
import java.util.*;

public  class practice {
	/*public static getperimeter(Shape s) {
		double totp=0;
		Point prept=s.getLastPoint();
		for(Point currpt:s.getPoints()) {
			double currDist=prept.distance(currpt);
			totp +=currDist;
			prept=currpt;
		}
		return totp;
	}
	public static void testp() {
		FileResource file =new FileResource("");
		Shape s= new Shape(file);
		double length=getperimeter(s);
		System.out.println("ans= "+length);
	}
	*/
//	public static String findgene(String gene){
//		int startindex=gene.indexOf("ATG");
//		int currindex=gene.indexOf("TAA",startindex+3);
//		while(startindex!=-1) {
//			if((currindex-startindex)%6==0) {
//				return gene.substring(startindex,currindex+3);
//			
//			}
//			else {
//				currindex = gene.indexOf(currindex+1);
//			}
//			
//		}
//		return "not found";
//	}
	public static void main(String[] args)throws Exception {
//		String sequece=new String("AATVFVJFVLIFNVIJSFJKAGDJHHVVVSKVNNNAVJVTAA");
//		String x=findgene(sequece);
//		if(x!="not found"){
//			System.out.println(x.length()+3);
//		}	
//		System.out.println(x);
		Scanner scan =new Scanner(new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/hello_unicode.txt"));
		
		
		
		while(scan.hasNextLine()) {
			String word =scan.nextLine();
			System.out.println(word);
		}
		scan.close();
//		geneCount.close();
		
		
	}

}
