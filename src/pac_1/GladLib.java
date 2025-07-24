package pac_1;

import java.util.*;
import java.io.*;

public class GladLib {
	
	private ArrayList<String> nameL;
	private ArrayList<String> countryL;
	private Random random;

	public GladLib() {
		nameL=new ArrayList<String>();
		Collections.addAll(nameL,"Abc","Def","Mno","Xyz","Amn");

		countryL=new ArrayList<String>();
		Collections.addAll(countryL, "Brazil","Russia","India","China","South Africa");
		random = new Random();
	}
	public String getWord(String s){
		int idx;
		if(s.equals("name")) {
			idx=random.nextInt(nameL.size());
			return nameL.get(idx);
		}
		if(s.equals("country")) {
			idx=random.nextInt(countryL.size());
			return countryL.get(idx);
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
					//System.out.println(rep);
					word.replace(x, y+1, rep);
				}
			}
		}
		return word.toString();
	}
	
	public static void main(String[] args) {
		try {
			File file=new File("C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/rand_story.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String word=br.readLine();	
			
			GladLib glib=new GladLib();
			for(int i=1;i<=5;i++) {
				System.out.println(i+")"+glib.getStr(word));
			}
			br.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
