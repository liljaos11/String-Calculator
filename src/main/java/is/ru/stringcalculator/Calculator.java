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
		String[] intList = s.split(",");
		int sum = 0;
		for(int i = 0; i < intList.length; i++){
			sum = sum+Integer.parseInt(intList[i]);
		}
		return sum;
	}
}