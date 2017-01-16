package matching;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Matcher {
	final static int playerNumberInGame = 30;
	static List<Integer> playersInGame = new ArrayList<Integer>();
	static List<Integer> redTeam = new ArrayList<Integer>();
	static List<Integer> greenTeam = new ArrayList<Integer>();
	static Random random = new Random();
	
	public static void main(String[] args){
		InputStream is = System.in;
		Scanner scan = new Scanner(is);
		while (true) {
			playersInGame.clear();
			redTeam.clear();
			greenTeam.clear();
			random = new Random();
			System.out
					.println("please input level of tank that you want to play: ");
			int lvInput = scan.nextInt();
			do {
				int[] players = playerGenerator();
				List<Integer> pickedPlayers = playerPicker(lvInput, players);
				System.out.println(pickedPlayers.toString());
				System.out.println(pickedPlayers.size());
				if (pickedPlayers.size() < playerNumberInGame) {
					System.out
							.println("proper players are not enough, please try to generate again by inputting \"g\"");
					commandChecker(scan);
				} else {
					for (int i = 0; i < playerNumberInGame; i++) {
						playersInGame.add(pickedPlayers.get(i));
					}
					break;
				}
			} while (true);
			System.out
					.println("proper palyers are enough, system is matching a game...");
			matchingGame(playersInGame);
			Collections.sort(redTeam);
			Collections.sort(greenTeam);
			System.out.println("red team: " + redTeam.toString());
			System.out.println(redTeam.size());
			System.out.println("green team: " + greenTeam.toString());
			System.out.println(greenTeam.size());
		}
	}
	
	static void commandChecker(Scanner scan){
		while (true) {
			String command = scan.next();
			if (command.equalsIgnoreCase("g")) {
				return;
			} else {
				System.out.println("Please input valid command");
			}
		}
	}
	
	static int[] playerGenerator(){
		System.out.println("System is generating players...");
		int playerNum = random.nextInt(100-50+1)+50;
		int[] playerList = new int[playerNum];
		for(int i = 0; i<playerNum; i++){
			int lvlNum = random.nextInt(10-1+1)+1;
			playerList[i] = lvlNum;
		}
		return playerList;
	}
	
	static List<Integer> playerPicker(int lv, int[] playerList){
		List<Integer> result = new ArrayList<Integer>();
		if(lv == 1){
			for(int i : playerList){
				if(i>=1 && i <=3){
					result.add(i);
				}
			}
		}
		else if(lv == 10){
			for(int i: playerList){
				if(i >= 8 && i <=10){
					result.add(i);
				}
			}
		}
		else{
			for(int i : playerList){
				if(i>= lv-1 && i<= lv+1){
					result.add(i);
				}
			}
		}
		return result;
	}
	
	static void matchingGame(List<Integer> input){
		Collections.sort(input);
		int lastPosition;
		redTeam.add(input.get(0));
		lastPosition = 1;
		for(int i = 1; i<input.size(); i++){
			if(lastPosition == 1){
				greenTeam.add(input.get(i));
				lastPosition = 2;
			}else{
				redTeam.add(input.get(i));
				lastPosition = 1;
			}
		}
	}
}
