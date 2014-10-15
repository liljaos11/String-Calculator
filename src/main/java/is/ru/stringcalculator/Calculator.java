package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	public static int add(String text){
		String[] intList;
		if(text ==""){
			return 0;
		}
		else if(text.startsWith("//"))
			intList = splitStringOnSymbol(text.substring(4), Character.toString(text.charAt(2)));
		else
			intList = splitString(text);
		return sum(intList);
	}
	
	private static String[] splitString(String s){
		String newString = s.replace("\n", ",");
		String[] intList = newString.split(",");
		return intList;
	}
	
	private static String[] splitStringOnSymbol(String s, String symbol){
		String[] intList = s.split(symbol);
		return intList;
	}
	
	private static int sum(String[] intList){
		int sum = 0;
			List<Integer> negativeList = new ArrayList<Integer>();
			for(int i = 0; i < intList.length; i++){
				if(Integer.valueOf(intList[i])<0) negativeList.add(Integer.valueOf(intList[i]));
				sum = sum+Integer.parseInt(intList[i]);
			}
			if(! negativeList.isEmpty()){
				StringBuilder sb = new StringBuilder();
				sb.append("Negatives not allowed: "+negativeList.get(0));
				for(int i=1; i<negativeList.size();i++){
					sb.append(","+negativeList.get(i));
				}
				throw new IllegalArgumentException(sb.toString());
			}
		return sum;
	}
}
