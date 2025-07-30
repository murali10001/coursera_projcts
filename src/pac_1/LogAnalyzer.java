package pac_1;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class LogAnalyzer {
	private ArrayList<logEntry> records;	
	public  LogAnalyzer() {
		records=new ArrayList<logEntry>();
	}	
	public void readFile(String path)throws Exception {		
		Scanner scan=new Scanner(new FileReader(path));	
		while(scan.hasNextLine()) {
			String line=scan.nextLine();
			logEntry le=WebLogParser.parseEntry(line);
			records.add(le);
			
		}		
		scan.close();
	}

	
	public int DateCompare() {
		SimpleDateFormat daymonF= new SimpleDateFormat("dd MMM",Locale.US);
		String tar="30 sep";
		int count=0;
		for(logEntry le:records) {
			Date d=le.getime();
			String date=daymonF.format(d).toLowerCase();
			if(date.equals(tar)) {
				count++;
			}	
		}
		return count;
	}
	
	
	public HashMap<String, Integer> CountVisits(){
		
		HashMap<String, Integer> counts =new HashMap<String, Integer>();
		for(logEntry le:records) {
			String ip=le.getip();
			if(!counts.containsKey(ip)){
				counts.put(ip, 1);
			}else {
				counts.put(ip, counts.get(ip)+1);
			}
		}
		
		Integer maxVal=0;
		String maxKey=null;
		for(Map.Entry<String,Integer> entry:counts.entrySet()) {
			if(entry.getValue()>maxVal) {
				maxVal=entry.getValue();
				maxKey=entry.getKey();
				
			}
		}
		System.out.println("Max word : "+maxKey +" No of time occur "+maxVal);
		return counts;
	}
	
	public void time_ip() {		
		HashMap<String, Integer> counts =new HashMap<String, Integer>();
		SimpleDateFormat daymonF= new SimpleDateFormat("dd MMM",Locale.US);
		String tar="17 mar";	
		for(logEntry le:records) {
			Date d=le.getime();
			String date=daymonF.format(d).toLowerCase();
			if(tar.equals(date)) {
				String ip=le.getip();
				if(!counts.containsKey(ip)){
					counts.put(ip, 1);
				}else {
					counts.put(ip, counts.get(ip)+1);
				}
			}
		}
		
		Integer maxVal=0;
		String maxKey=null;
			
		for(logEntry le:records) {
				for(Map.Entry<String,Integer> entry:counts.entrySet()) {
					if(entry.getValue()>maxVal ) {
						maxVal=entry.getValue();
						maxKey=entry.getKey();
					}				
				}				
				
		}
		System.out.println("Max occur ip : "+maxKey+" times : "+maxVal );	
	}
	
	
	public static void main(String[] args)throws Exception {

		LogAnalyzer la=new LogAnalyzer();
		la.readFile("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/logentry/weblog1_log.txt");
//		System.out.println(la.CountVisits());
//		la.MaxOccur();
//		System.out.println( la.DateCompare());
		la.time_ip();
		
	}
}