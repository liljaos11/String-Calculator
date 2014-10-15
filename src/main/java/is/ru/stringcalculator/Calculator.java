package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	//Takes in a string and adds the numbers in it
	public static int add(String text){
		String[] intList;
		if(text ==""){
			return 0;
		}
		else if(text.startsWith("//[")){
			StringBuilder symbol = new StringBuilder();
			List<String> symbolList = new ArrayList<String>();
			int count, symbolCount=0;
			for (count = 3; count < text.length();count++) {
				if(text.charAt(count)=='\n') break;
				else if(text.charAt(count)!='['&&text.charAt(count)!=']') symbol.append(text.charAt(count));
				if(text.charAt(count+1)==']'){
					symbolList.add(symbol.toString());
					symbol.setLength(0);
					symbolCount++;
				}
			}			
			StringBuilder s = new StringBuilder();
			//Get just the part of the string after /n
			s.append(text.substring(count+1, text.length()));
			for(int i = 0; i<symbolList.size();i++){
				String t = s.toString().replace(symbolList.get(i), ",");
				s.setLength(0);
				s.append(t);
			}
			
			intList = splitString(s.toString());
		}
		else if(text.startsWith("//"))	//If string has some delimiter other than ,
			intList = splitStringOnSymbol(text.substring(4), Character.toString(text.charAt(2)));
		else
			intList = splitString(text);
		return sum(intList);		//Calculate and return the sum
	}
	
	//Splits string on ,
	private static String[] splitString(String s){
		String newString = s.replace("\n", ",");
		String[] intList = newString.split(",");
		return intList;
	}
	
	//Splits string on any delimiter
	private static String[] splitStringOnSymbol(String s, String symbol){
		String[] intList = s.split(symbol);
		return intList;
	}
	
	private static int sum(String[] intList){
		int sum = 0;
			List<Integer> negativeList = new ArrayList<Integer>(); //For any negative values
			for(int i = 0; i < intList.length; i++){
				//If a number is negative it is added to the negative list
				if(Integer.valueOf(intList[i])<0) negativeList.add(Integer.valueOf(intList[i]));
				if(!(Integer.valueOf(intList[i])>1000)) sum = sum+Integer.parseInt(intList[i]);
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
