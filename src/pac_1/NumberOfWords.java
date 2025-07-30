package pac_1;
import java.io.*;
import java.util.*;

public class NumberOfWords {
//	private ArrayList<String> words;
//	private ArrayList<Integer> count;
	private HashMap<String, Integer> record;
	
	public NumberOfWords() {
//		 words = new ArrayList<String>();
//		 count=new ArrayList<Integer>();
		record=new HashMap<String, Integer>();
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
					if(!record.containsKey(word)){
						record.put(word, 1);
					}else {
						record.put(word, record.get(word)+1);
					}
					
				}
			}			
		}
		System.out.println("Number of unique words : "+record.size());
		
		
//		int max=count.get(0);
//		String maxW=null;;
//		for(int i=0;i<words.size();i++){
//			System.out.println(words.get(i)+" "+count.get(i));
//			if(count.get(i)>max){
//				max=count.get(i);
//				maxW=words.get(i);
//			}
//		}
//		System.out.println("Max occur "+maxW+" number o times "+max);
//		System.out.println(record);
		Integer maxVal=0;
		String maxKey=null;
		for(Map.Entry<String,Integer> entry:record.entrySet()) {
			if(entry.getValue()>maxVal) {
				maxVal=entry.getValue();
				maxKey=entry.getKey();
				
			}
		}
		System.out.println("Max word : "+maxKey +" No of time occur "+maxVal);
		geneCount.close();
	}
	
	public static void main(String[] args) throws Exception{
		String path="C:/Users/Lenovo/eclipse-workspace/coursera_project/src/pac_1/other/romeo.txt";
		NumberOfWords f1= new NumberOfWords();
		f1.FindUnique(path);

	}
}