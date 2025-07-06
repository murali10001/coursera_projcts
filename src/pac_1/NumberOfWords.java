package pac_1;
import java.io.*;
import java.util.Scanner;

public class NumberOfWords {
	public static void main(String[] args) throws Exception{
//		File file = new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/romeo.txt");
//		FileReader sequ = new FileReader(file);
//		BufferedReader geneCount = new BufferedReader(sequ);
//		
//		
//		int NumberOfWords=0 ;
//		String line;
//		
//		while((line=geneCount.readLine())!=null) {
//			if(!line.trim().isEmpty()) {
//				String[] words =line.trim().split("\\s+");
//				NumberOfWords+=words.length;
//			}
//			
//		}
		Scanner scan =new Scanner(new File("romeo.txt"));
		int NumberOfWords=0 ;
		
		
		while(scan.hasNext()) {
			scan.next();
			NumberOfWords++;
		}
		scan.close();
//		geneCount.close();
		System.out.println("Total Number of words : "+NumberOfWords);
	}
}