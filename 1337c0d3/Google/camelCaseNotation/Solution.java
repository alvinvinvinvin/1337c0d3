/**
 * 
 */
package camelCaseNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hanchen
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( 'Z' - 97);
		List<String> inputList = new ArrayList<String>();
		inputList.add("HelloWorld");
		inputList.add("HelloWorldMars");
		inputList.add("HelloMars");
		inputList.add("HeHo");
		inputList.add("hello");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		List<String> result = test(input,inputList);
		for(String res: result){
			System.out.println(res);
		}
		sc.close();
//		Pattern pat = Pattern.compile("^H[a-z]*W[a-z]*$");
//		Matcher matcher = pat.matcher("HelloWorld");
//		System.out.println(matcher.find());

	}
	
	public static List<String> test(String pattern, List<String> inputList){
		List<String> result = new ArrayList<String>();
		if(inputList != null && pattern != "null"){
			String[] splitedStrs = pattern.split("(?=\\p{Lu})"); 
			String reg = "^";
			for(String splitedStr : splitedStrs){
				reg += splitedStr+"[a-z]*";
			}
			Pattern pat = Pattern.compile(reg);	
			for(String input: inputList){
				Matcher matcher = pat.matcher(input);
				if(matcher.find()){
					result.add(input);
				}
			}
		}
		return result;
	}

}
