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

	
	public void CountVisits(){
		
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
		System.out.println("The IP address with the most occurances in March is "+maxKey +" which appears "+maxVal);
		System.out.println("The number of unique IP address in March is "+counts.size());
		
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
			
	
		for(Map.Entry<String,Integer> entry:counts.entrySet()) {
			if(entry.getValue()>maxVal ) {
				maxVal=entry.getValue();
				maxKey=entry.getKey();
			}				
		}				
		
		
		System.out.println("On "+ tar+" the Most frequently occuring IP address is "+maxKey+" with "+maxVal+" occurrences" );	
	}
	
	public void DateCompare() {
		HashMap<String,Integer> counts=new HashMap<>();
		
		SimpleDateFormat daymonF= new SimpleDateFormat("dd MMM",Locale.US);
		String tar="15 mar";
		
		String ip;
		for(logEntry le:records) {
			Date d=le.getime();
			ip=le.getip();
			String date=daymonF.format(d).toLowerCase();
			
			if(date.equals(tar)) {
				if(!counts.containsKey(ip)){
					counts.put(ip, 1);
				}else {
					counts.put(ip, counts.get(ip)+1);
				}
			}	
		}
		System.out.println("On "+tar+" there are "+counts.size()+" unique IP addresses");
	}
	
	
	public static void main(String[] args)throws Exception {

		LogAnalyzer la=new LogAnalyzer();
		la.readFile("C:/Users/manis/eclipse-workspace/coursera_project/src/pac_1/logentry/weblog1_log.txt");
		la.CountVisits();
		la.time_ip();
		la.DateCompare();
		
		
	}
}