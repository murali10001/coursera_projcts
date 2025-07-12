package pac_1;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class CSV_temperature {
	
	static double max=0.0,min=Double.MAX_VALUE,tot_temp=0;
	static String dayM,dayMI,dayH;
	static int H_min=Integer.MAX_VALUE,i=1,tot_hum=0;
	
	public static void LargestTemp(String path)throws Exception {
		CSVReader reader= new CSVReader(new FileReader(path));
		String[] line;
		
		
		reader.readNext(); 
		
		while(( line = reader.readNext())!=null) {
			
			String x=line[13],T=line[1],humidity=line[3];
			double temp=Double.parseDouble(T);
			int humi=Integer.parseInt(humidity);
			
			if(temp>max) {
				max=temp;
				dayM=x;
				
			}
			if(temp<min) {
				min=temp;
				dayMI=x;
				
			}
			if(humi<H_min) {
				H_min=humi;
				dayH=x;
			}
			
			tot_temp+=temp;
			tot_hum+=humi;
			i++;
			
		}
		
		reader.close();
	}

	public static void main(String[] args)throws Exception {

		String[] path={"C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-01.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-02.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-03.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-04.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-05.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-06.csv","C:\\Users\\Lenovo\\eclipse-workspace\\coursera_project\\src\\pac_1\\weather_data\\weather-2015-01-07.csv"};
		
		
		for(int j=0;j<path.length;j++){
			LargestTemp(path[j]);	
			
		}		
	
		
		System.out.println("Number of days : "+path.length);
		System.out.println("Maximum temperature : "+ max +"°F on "+ dayM +" UTC");
		System.out.println("Minimum temperature : "+ min +"°F on "+ dayMI+" UTC" );
		System.out.println("Average Temperature : "+tot_temp/i+"°F"+"\n"+"Average Humidity : "+tot_hum/i+"%");
		
	

	}

}
