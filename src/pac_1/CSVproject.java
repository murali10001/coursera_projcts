package pac_1;

import java.io.*;
import com.opencsv.*;

public class CSVproject {

	public static void main(String[] args) {
		
		try {
			CSVReader reader= new CSVReader(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/exportdata.csv"));
			
			String[] line;
			reader.readNext(); //to skip header 
			int i=0;

			while(( line = reader.readNext())!=null) {
				
				String country=line[0],exports =line[1],money=line[2];
			
				if(exports.contains("cotton")&&exports.contains("flowers")) { 
					System.out.println("Country that exports both flower and cotton : "+country+"\n");

				}
//				
//				if(exports.contains("cocoa")) {
//					i++;
//				}
//				
//				if(country.contains("India")) {  
//					System.out.println("India exports : "+exports+"\n");
//				}
//				
//				int len=money.length();
//				if(len>16) {  
//					System.out.println(country+"  exports one or more trillion dollars \n");
//				}
				
			}
			
//			System.out.println("Total number of countries that export cocoa : "+i);
			
			reader.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
