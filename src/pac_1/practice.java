package pac_1;

public  class practice {
	
	private String alphabet,lalphabet;
	private String Calphabet,Clalphabet;
	
	public practice(int key) {
		alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Calphabet=alphabet.substring(key)+alphabet.substring(0,key);
		lalphabet="abcdefghijklmnopqrstuvwxyz";
		Clalphabet=lalphabet.substring(key)+lalphabet.substring(0,key);
	}
	

	
	public  void Enc(String s) {
		StringBuilder res=new StringBuilder(s);
	
		for(int i=0;i<s.length();i++) {
			
			char currchar=res.charAt(i);
			if(Character.isUpperCase(currchar)) {
				int idx=alphabet.indexOf(currchar);
				if(idx!=-1) {
					char nc=Calphabet.charAt(idx);	
					res.setCharAt(i,nc);
				}
			}
			
			else if(Character.isLowerCase(currchar)) {
				int idx=lalphabet.indexOf(currchar);	
				if(idx!=-1) {
					char nc=Clalphabet.charAt(idx);	
					res.setCharAt(i,nc);
				}
			}
			
		}
		res.toString();
		System.out.println(res);
	}
	
	public static void main(String argd[]) throws Exception{		
		String s="Hello";
		int key=23;
		practice p=new practice(key);
		p.Enc(s);
		
	}

}
