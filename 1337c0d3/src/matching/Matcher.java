/*
 * I know it sucks being in noob teams in a row, but can't we have a better match maker?
 * Or WG just doesn't want us to have such thing?
 */

package matching;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Matcher {
	final static int playerNumberInGame = 30;
	static List<Player> playersInGame = new ArrayList<Player>();
	static List<Player> redTeam = new ArrayList<Player>();
	static List<Player> greenTeam = new ArrayList<Player>();
	static float count_total = 0, count_imba = 0;
	static Random random = new Random();
	
	public static void main(String[] args){
		InputStream is = System.in;
		Scanner scan = new Scanner(is);
		String command = "";
		while (true) {
			playersInGame.clear();
			redTeam.clear();
			greenTeam.clear();
			random = new Random();
			System.out
					.println("please input level of tank that you want to play: ");
			
			while(!scan.hasNextInt()){
				System.out.println("Invalid number. Please enter again.\n");
				command = scan.next();
				if(command.equalsIgnoreCase("q")){
					System.out.println("count_total: "+count_total+", count_imba: "
							+count_imba+"; "+(count_imba * 100.0f)/count_total+"%");
					return;
				}
			} 
			int lvInput = scan.nextInt();
			do {
				Player[] players = playerGenerator();
				List<Player> pickedPlayers = playerPicker(lvInput, players);
				System.out.println(pickedPlayers.toString());
				System.out.println(pickedPlayers.size());
				if (pickedPlayers.size() < playerNumberInGame) {
					System.out
							.println("proper players are not enough, please try to generate again by inputting \"g\"");
					boolean cc = commandChecker(scan, command);
					if(!cc){
						return;
					}
				} else {
					for (int i = 0; i < playerNumberInGame; i++) {
						playersInGame.add(pickedPlayers.get(i));
					}
					count_total++;
					break;
				}
			} while (true);
			System.out
					.println("proper palyers are enough, system is matching a game...");
			//matchingGame(playersInGame);
			matchingGame2(playersInGame);
			Collections.sort(redTeam, Player.Comparators.LVL);
			Collections.sort(greenTeam, Player.Comparators.LVL);
			System.out.println("red team: " + redTeam.toString());
			System.out.println(redTeam.size()+"; total SR:"+totalSr(redTeam)+"; averageSr:"+averageSr(redTeam));
			System.out.println("green team: " + greenTeam.toString());
			System.out.println(greenTeam.size()+"; total SR:"+totalSr(greenTeam)+"; averageSr:"+averageSr(greenTeam));
			if( Math.abs(averageSr(redTeam) - averageSr(greenTeam)) > 200 ){
				System.out.println("Unfair match!!!!");
				count_imba++;
			}
		}
	}
	
	static boolean commandChecker(Scanner scan, String command){
		while (true) {
			command = scan.next();
			if (command.equalsIgnoreCase("g")) {
				return true;
			}else if(command.equalsIgnoreCase("q")){
				System.out.println("count_total: "+count_total+", count_imba: "
						+count_imba+"; "+(count_imba * 100.0f)/count_total+"%");
				return false;
			}
			else {
				System.out.println("Please input valid command");
			}
		}
	}
	
	static Player[] playerGenerator(){
		System.out.println("System is generating players...");
		int playerNum = random.nextInt(200-50+1)+50;
		Player[] playerList = new Player[playerNum];
		for(int i = 0; i<playerNum; i++){
			int lvlNum = random.nextInt(10-1+1)+1;
			int sr = random.nextInt(2000+1-200)+200;
			Player p = new Player(lvlNum, sr);
			playerList[i] = p;
		}
		return playerList;
	}
	
	static List<Player> playerPicker(int lv, Player[] playerList){
		List<Player> result = new ArrayList<Player>();
		if(lv == 1){
			for(Player i : playerList){
				if(i.lvl>=1 && i.lvl <=3){
					result.add(i);
				}
			}
		}
		else if(lv == 10){
			for(Player i: playerList){
				if(i.lvl >= 8 && i.lvl <=10){
					result.add(i);
				}
			}
		}
		else{
			for(Player i : playerList){
				if(i.lvl>= lv-1 && i.lvl<= lv+1){
					result.add(i);
				}
			}
		}
		return result;
	}
	// around 30% unfair matches
	static void matchingGame(List<Player> input){
		Collections.sort(input, Player.Comparators.LVL);
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
	//Much more fair! Trash MM, Trash WG!
	static void matchingGame2(List<Player> input){
		if(input.size()<30){
			System.out.println("Less than 30 players in MM.");
			System.exit(0);
		}
		Collections.sort(input, Player.Comparators.LVL);
		//higher == 1 means red team total service record is higher currently.
		boolean higher = input.get(0).serviceRecord>input.get(1).serviceRecord;
		int g = 0,r = 0;
		redTeam.add(input.get(0));
		r+=input.get(0).serviceRecord;
		greenTeam.add(input.get(1));
		g+=input.get(1).serviceRecord;
		for(int i = 2; i<input.size(); i+=2){
			Player p1 = input.get(i);
			Player p2 = input.get(i+1);
			//Red team is higher
			if(higher){
				if(p1.serviceRecord>p2.serviceRecord){
					greenTeam.add(p1);
					g+=p1.serviceRecord;
					redTeam.add(p2);
					r+=p2.serviceRecord;
					
				}else{
					greenTeam.add(p2);
					g+=p2.serviceRecord;
					redTeam.add(p1);
					r+=p1.serviceRecord;
				}
			//Red team is not higher
			}else{
				if(p1.serviceRecord<p2.serviceRecord){
					greenTeam.add(p1);
					g+=p1.serviceRecord;
					redTeam.add(p2);
					r+=p2.serviceRecord;
					
				}else{
					greenTeam.add(p2);
					g+=p2.serviceRecord;
					redTeam.add(p1);
					r+=p1.serviceRecord;
				}
			}
			higher = r>g;
		}
		
	}
	
	static int totalSr(List<Player> team){
		int sum = 0;
		for(Player p:team) sum += p.serviceRecord;
		return sum;
	}
	
	static int averageSr(List<Player> team){
		return totalSr(team)/team.size();		
	}
	
	static class Player{
		public int lvl;
		public int serviceRecord;
		public Player(int lv, int sr){
			lvl = lv;
			serviceRecord = sr;
		}
		
	    public int compareTo(Player o) {
	        return Comparators.LVL.compare(this, o);
	    }
	    
	    public static class Comparators {
	        public static final Comparator<Player> LVL = (Player o1, Player o2) -> Integer.compare(o1.lvl, o2.lvl);
	    }
	    
	    @Override
	    public String toString() {
	        return lvl+":"+serviceRecord;
	    }
	}
}
