package pac_1;

import java.io.FileReader;
import com.opencsv.*;


public class baby_names {
	
	public static void tot_birth(String path)throws Exception {
		int xy=0,xx=0;			
		CSVReader read = new CSVReader(new FileReader(path));
		for(String[] line: read ) {
			String  gender=line[1];
			if(gender.contains("M")) {
				xy++;
			} 
			if(gender.contains("F")) {
				xx++;
			}
			
		}
		System.out.println("Number of boys names: "+xy+"\n");
		System.out.println("Number of girls names: "+xx+"\n");
		System.out.println("Total number of names: "+(xy+xx)+"\n");
		read.close();
	}
	
	
	public static void get_rank(String path,String getName,String gen)throws Exception {
		CSVReader read = new CSVReader(new FileReader(path));
		int i=1;
		boolean isnotfound=true;
		for(String[] line: read ) {
			
			String name=line[0], gender=line[1];
			if(gender.contains(gen)) {
				if(name.contains(getName)) {
					System.out.println("The name  \""+name+"\" is ranked "+i +", and the gender is "+gender+"\n");
					i++;
					isnotfound=false;
				}
				else i++ ;
			}
	
			
		}if(isnotfound) System.out.println("The name \""+getName+"\" does not exist in the data set "+"\n");
		read.close();

	}
	public static void  get_name(String path,int rank,String Gen)throws Exception {
		
		CSVReader read = new CSVReader(new FileReader(path));
		int i=1;
		boolean isnotfound=true;
		for(String[] line: read ) {	
			String name=line[0],gender=line[1];
			
			if(gender.contains(Gen)) {
				if(rank==i){
					System.out.println("Rank "+i+" belongs to the name  \""+name+"\", gender  "+Gen+"\n" );
					isnotfound=false;
					i++;
					
				}
				else i++ ;
			}
		}if(isnotfound) System.out.println("No name corresponds to the specified rank"+"\n");
		read.close();
	}
	
	
	public static void compare_csv(String path1,String path2,String getname)throws Exception{
		
		CSVReader read1 = new CSVReader(new FileReader(path1));
		CSVReader read2 = new CSVReader(new FileReader(path2));
		int i=1,j=0;	
		for(String[] line: read1 ) {	
			String name=line[0];
			
			if(name.contains(getname)) {
				j=i;
				break;
				
			}
			else i++ ;
		
		}
		
		
		int y=1;			
		for(String[] line: read2 ) {	
			String name=line[0];
				
				
				if(j==y){
					System.out.println("The name corresponding to \""+name + "\" in 1990 is \""+getname+"\""+"\n" );
					break;
					
				}else y++;
		}
		read1.close();
		read2.close();
	}


	public static void main(String[] args) {
		String path1="C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\baby name data\\yob1900.csv";	
		String path2="C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\baby name data\\yob1905.csv";	

		try {
			tot_birth(path1);
			
			get_rank(path1,"Norah","F");
			
			get_name(path1,7, "F");
			
			compare_csv(path1, path2,"Alice");
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		
	}

}
