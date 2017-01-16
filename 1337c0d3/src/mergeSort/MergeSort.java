package mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {
	public static void main(String args[]){
		for (int j = 0; j < 10; j++) {
			Random random = new Random();
			int size = 100;
			List<Integer> testIntegers = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				int val = random.nextInt(100 - 1 + 1) + 1;
				testIntegers.add(val);
			}
			System.out.println("input: " + testIntegers.toString());
			List<Integer> sortedList = split(testIntegers);
			System.out.println("output: " + sortedList.toString());
		}
	}
	
	public static List<Integer> split(List<Integer> input){
		if(input.size()<=1) return input;
		List<Integer> leftIntegers = new ArrayList<Integer>();
		List<Integer> rightIntegers = new ArrayList<Integer>();
		int mid = input.size()/2;
		for(int i = 0; i < mid; i++){
			leftIntegers.add(input.get(i));
		}
		for(int j = mid; j<input.size();j++){
			rightIntegers.add(input.get(j));
		}
		leftIntegers = split(leftIntegers);
		rightIntegers = split(rightIntegers);
		return merge(leftIntegers, rightIntegers);
	}
	
	public static List<Integer> merge(List<Integer> inputOne, List<Integer> inputTwo){
		List<Integer> tempIntegers = new ArrayList<Integer>();
		while (inputOne.size() > 0 && inputTwo.size() > 0) {
			if(inputOne.get(0) < inputTwo.get(0)){
				tempIntegers.add(inputOne.get(0));
				inputOne.remove(0);
			}
			else{
				tempIntegers.add(inputTwo.get(0));
				inputTwo.remove(0);
			}
		}
		if(inputOne.size()>0){
			for(int i : inputOne){
				tempIntegers.add(i);
			}
		}
		if(inputTwo.size()>0){
			for(int i : inputTwo){
				tempIntegers.add(i);
			}
		}
		return tempIntegers;
	}
}
