package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text ==""){
			return 0;
		}
		else if(text.contains(",")){	
			return Integer.parseInt(text.split(",")[0])+Integer.parseInt(text.split(",")[1]);
		}
		else return Integer.parseInt(text);
	}
}