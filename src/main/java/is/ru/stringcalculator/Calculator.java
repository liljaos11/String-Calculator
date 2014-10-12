package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text ==""){
			return 0;
		}
		else if(text.contains(",")){	
			return splitString(text);
		}
		else return Integer.parseInt(text);
	}
	
	private static int splitString(String s){		
		return Integer.parseInt(s.split(",")[0])+Integer.parseInt(s.split(",")[1]);
	}
}