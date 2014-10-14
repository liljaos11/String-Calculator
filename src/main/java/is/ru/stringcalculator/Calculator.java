package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text ==""){
			return 0;
		}
		else if(text.startsWith("//")){
			return splitStringOnSymbol(text.substring(4), Character.toString(text.charAt(2)));
		}
		else return splitString(text);
	}
	
	private static int splitString(String s){
		String newString = s.replace("\n", ",");
		String[] intList = newString.split(",");
		return sum(intList);
	}
	
	private static int splitStringOnSymbol(String s, String symbol){
		String[] intList = s.split(symbol);
		return sum(intList);
	}
	
	private static int sum(String[] intList){
		int sum = 0;
		for(int i = 0; i < intList.length; i++){
			sum = sum+Integer.parseInt(intList[i]);
		}
		return sum;
	}
}