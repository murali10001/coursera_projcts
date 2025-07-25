package pac_1;

import java.util.*;
import java.io.*;

public class GladLib {
	
	private ArrayList<String> nameL;
	private ArrayList<String> countryL;
	private ArrayList<String> colourL;
	private ArrayList<String> animalL;
	private ArrayList<String> nounL;
	private ArrayList<String> verbL;
	private ArrayList<String> fruitL;
	private ArrayList<String> adjectiveL;
	private ArrayList<String> timeframeL;	
	private Random random;

	public GladLib()throws Exception {
		String line;
		nameL=new ArrayList<String>();
		Scanner scan1=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/name.txt"));
		while(scan1.hasNextLine()) {
			line=scan1.nextLine();
			nameL.add(line);
		}scan1.close();
		
		countryL=new ArrayList<String>();
		Scanner scan2=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/country.txt"));
		while(scan2.hasNextLine()) {
			line=scan2.nextLine();
			countryL.add(line);
		}scan2.close();
		
		adjectiveL=new ArrayList<String>();
		Scanner scan3=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/adjective.txt"));
		while(scan3.hasNextLine()) {
			line=scan3.nextLine();
			adjectiveL.add(line);
		}scan3.close();
		
		animalL=new ArrayList<String>();
		Scanner scan4=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/animal.txt"));
		while(scan4.hasNextLine()) {
			line=scan4.nextLine();
			animalL.add(line);
		}scan4.close();
		
		colourL=new ArrayList<String>();
		Scanner scan5=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/color.txt"));
		while(scan5.hasNextLine()) {
			line=scan5.nextLine();
			colourL.add(line);
		}scan5.close();
		
		fruitL=new ArrayList<String>();
		Scanner scan6=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/fruit.txt"));
		while(scan6.hasNextLine()) {
			line=scan6.nextLine();
			fruitL.add(line);
		}scan6.close();
		
		nounL=new ArrayList<String>();
		Scanner scan7=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/noun.txt"));
		while(scan7.hasNextLine()) {
			line=scan7.nextLine();
			nounL.add(line);
		}scan7.close();
		
		
		verbL=new ArrayList<String>();
		Scanner scan8=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/verb.txt"));
		while(scan8.hasNextLine()) {
			line=scan8.nextLine();
			verbL.add(line);
		}scan8.close();
				
		timeframeL=new ArrayList<String>();
		Scanner scan9=new Scanner(new FileReader("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/timeframe.txt"));
		while(scan9.hasNextLine()) {
			line=scan9.nextLine();
			timeframeL.add(line);
		}scan9.close();
		
		random = new Random();
	
	}
	public String getWord(String s){
		int idx;
		if(s.equals("name")) {
			idx=random.nextInt(nameL.size());
			return nameL.get(idx);
		}
		else if(s.equals("country")) {
			idx=random.nextInt(countryL.size());
			return countryL.get(idx);
		}
		else if(s.equals("adjective")) {
			idx=random.nextInt(adjectiveL.size());
			return adjectiveL.get(idx);
		}
		else if(s.equals("animal")) {
			idx=random.nextInt(animalL.size());
			return animalL.get(idx);
		}
		else if(s.equals("color")) {
			idx=random.nextInt(colourL.size());
			return colourL.get(idx);
		}
		else if(s.equals("fruit")) {
			idx=random.nextInt(fruitL.size());
			return fruitL.get(idx);
		}
		else if(s.equals("noun")) {
			idx=random.nextInt(nounL.size());
			return nounL.get(idx);
		}
		else if(s.equals("timeframe")) {
			idx=random.nextInt(timeframeL.size());
			return timeframeL.get(idx);
		}
		else if(s.equals("verb")) {
			idx=random.nextInt(verbL.size());
			return verbL.get(idx);
		}
		
		return "Unkonown";
	}
	
	public  String getStr(String str){
		StringBuffer word=new StringBuffer(str);		
		while(word.indexOf("<")!=-1 && word.indexOf(">")!=-1) {
			int x=word.indexOf("<");
			int y=word.indexOf(">");
			if(x!=-1) {
				if(y!=-1) {
					String rep =getWord(word.substring(x+1,y));
					word.replace(x, y+1, rep);
				}
			}
		}
		return word.toString();
	}
	
	public static void main(String[] args) {
		try {
			File file=new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/datalong/madtemplate2.txt");
			FileReader fr=new FileReader(file);	
			GladLib glib=new GladLib();
			String line;
			Scanner scan=new Scanner(fr);
			while(scan.hasNextLine()) {
				line=scan.nextLine();
				System.out.println(glib.getStr(line));
			}scan.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
