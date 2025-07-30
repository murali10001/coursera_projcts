package pac_1;


import java.util.Date;

public class logEntry {
	private  String ipaddress;
	private Date accessTime;
	private String Request;
	private int statusCode;
	private int byteReturn;
	
	public logEntry(String ip,Date time,String req,int Status,int Bytes) {
		ipaddress=ip;
		accessTime=time;
		Request=req;
		statusCode=Status;
		byteReturn=Bytes;
	}
	public String getip() {
		return ipaddress;
	}
	public Date getime() {
		return accessTime;
	}
	public String getreq() {
		return Request;
	}
	public int getStatus() {
		return statusCode;
	}
	public int getbyte() {
		return byteReturn;
	}
	
	public String toString() {
		return ipaddress+" "+accessTime+" "+Request+" "+statusCode+" "+byteReturn;
	}
}
