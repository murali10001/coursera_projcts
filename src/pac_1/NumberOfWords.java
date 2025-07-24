package pac_1;
import java.io.*;
import java.util.*;

public class NumberOfWords {
	private ArrayList<String> words;
	private ArrayList<Integer> count;
	
	public NumberOfWords() {
		 words = new ArrayList<String>();
		 count=new ArrayList<Integer>();
	}
	
	public void FindUnique(String path)throws Exception {
		
		File file = new File(path);	
		FileReader sequ = new FileReader(file);
		BufferedReader geneCount = new BufferedReader(sequ);	
		String line;
		
		while((line=geneCount.readLine())!=null) {
			if(!line.trim().isEmpty()) {
				String[]  Splitwords =line.trim().split("\\s+");
				for(String word:Splitwords) {
					word=word.toLowerCase();
					int index=words.indexOf(word);
					if(index==-1){
						words.add(word);
						count.add(1);					
					}
					else {				
						int val=count.get(index);
						count.set(index, val+1);					
					}
					
				}
			}			
		}
		System.out.println("Number of unique words : "+words.size());
		
		
		int max=count.get(0);
		String maxW=null;;
		for(int i=0;i<words.size();i++){
			System.out.println(words.get(i)+" "+count.get(i));
			if(count.get(i)>max){
				max=count.get(i);
				maxW=words.get(i);
			}
		}
		System.out.println("Max occur "+maxW+" number o times "+max);
	
		geneCount.close();
	}
	
	public static void main(String[] args) throws Exception{
		String path="C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/romeo.txt";
		NumberOfWords f1= new NumberOfWords();
		f1.FindUnique(path);

	}
}