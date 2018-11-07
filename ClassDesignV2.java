import java.util.*;
import java.util.function.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	private String shoots;
	private int[] stats;
	
	//constructor
	public HockeyPlayer(String lastName, String position, String birthplace, String shoots, int... stats){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
		this.shoots = shoots;
		this.stats = stats;
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;	
	}
	
	public void setBirthplace(String birthplace){
		this.birthplace = birthplace;	
	}
	
	public void setShoots(String shoots){
		this.shoots = shoots;	
	}
	
	public void setStats(int... stats){
		this.stats = stats;	
	}
	
	//getters
	public String getLastName(){
		return lastName;
	}
	
	public String getPosition(){
		return position;	
	}
	
	public String getBirthplace(){
		return birthplace;	
	}
	
	public String getShoots(){
		return shoots;	
	}
	
	public int[] getStats(){
		return stats;	
	}
	
	//more methods
	public String toString(){
		return lastName; 	
	}
	
	public String printGeneralInfo(){
	 	return lastName + " is a " + position + " who was born in " + this.getBirthplace() + ".";	
	}
	
	public String rosterOutput(){
		return "POSITION: " + position+ "\tNAME: " + lastName;	
	}
	
	public boolean isPosition(String playerPosition){
		if(position.contains(playerPosition)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isShot(String leftRight){
		if(shoots.equals(leftRight)){
			return true;	
		}
		else{
			return false;	
		}
	}
	
	public boolean isBornHere(String country){
		if(birthplace.equals(country)){
			return true;		
		}
		else{
			return false;	
		}
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Goalie extends HockeyPlayer{
	//fields
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	
	//constructors
	public Goalie(String lastName, String position, String birthplace, String shoots, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position, birthplace, shoots, shotsAgainst, goalsAgainst, saves);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalie(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), hp.getShoots(), shotsAgainst, goalsAgainst, saves);	
	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;
	}	
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Skater extends HockeyPlayer{
	//fields
	private String shoots;
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	
	//constructors
	public Skater(String lastName, String position, String birthplace, String shoots, int goals, int assists, int points, int plusMinus){
		super(lastName, position, birthplace, shoots, goals, assists, points, plusMinus);
		this.shoots = shoots;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	public Skater(HockeyPlayer hp, String shoots, int goals, int assists, int points, int plusMinus){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), hp.getShoots(), goals, assists, points, plusMinus);	
	}
	
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setShoots(String shoots){
		this.shoots = shoots;	
	}
	
	//getters
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;	
	}
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public String getShoots(){
		return shoots;	
	}
	
	@Override
	public String toString(){
		return super.toString();	
	}
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Roster{
	//fields
	private ArrayList<HockeyPlayer> roster;

	//constructor
	public Roster(){
		setRoster();	
	}

	//setter
	public void setRoster(){
		roster = new ArrayList<HockeyPlayer>();
		roster.add(new Goalie("Holtby", "Goalie", "Canada", "NA", 1648, 153, 1495));
		roster.add(new Skater("Ovechkin", "Forward, LW", "Russia", "Right", 49, 38, 87, 3));
		roster.add(new Skater("Kuznetsov", "Forward, C", "Russia", "Left", 27, 56, 83, 3));
		roster.add(new Skater("Vrana", "Forward, LW", "Czech Republic", "Left", 13, 14, 27, 2));
		roster.add(new Skater("Gersich", "Forward, LW", "USA", "Left", 0, 1, 1, -1));
		roster.add(new Skater("Walker", "Forward, LW", "Wales", "Left", 1, 0, 1, 1));
		roster.add(new Skater("Burakovsky", "Forward, LW", "Austria", "Left", 12, 13, 25, 3));
		roster.add(new Skater("Backstrom", "Forward, C", "Sweden", "Left", 21, 50, 71, 5));
		roster.add(new Skater("Graovac", "Forward, C", "Canada", "Left", 0, 0, 0, -3));
		roster.add(new Skater("Boyd", "Forward, C", "USA", "Right", 0, 1, 1, 2));
		roster.add(new Skater("O'Brien", "Forward, C", "Canada", "Left", 0, 0, 0, 0));
		roster.add(new Skater("Eller", "Forward, C", "Denmark", "Left", 18, 20, 38, -6));
		roster.add(new Skater("Stephenson", "Forward, C", "Canada", "Left", 6, 12, 18, 13));
		roster.add(new Skater("Beagle", "Forward, C", "Canada", "Right", 7, 15, 22, 3));
		roster.add(new Skater("Oshie", "Forward, RW", "USA", "Right", 18, 29, 47, 2));
		roster.add(new Skater("Wilson", "Forward, RW", "Canada", "Right", 14, 21, 35, 10));
		roster.add(new Skater("Connolly", "Forward, RW", "Canada", "Right", 15, 12, 27, -6));
		roster.add(new Skater("Peluso", "Forward, RW", "Canada", "Right", 0, 0, 0, 0));
		roster.add(new Skater("Smith-Pelly", "Forward, RW", "Canada", "Right", 7, 9, 16, -6));
		roster.add(new Skater("Chiasson", "Forward, RW", "Canada", "Right", 9, 9, 18, 1));
		roster.add(new Skater("Carlson", "Defense", "USA", "Right", 15, 53, 68, 0));
		roster.add(new Skater("Orlov", "Defense", "Russia", "Left", 10, 21, 31, 10));
		roster.add(new Skater("Niskanen", "Defense", "USA", "Right", 7, 22, 29, 24));
		roster.add(new Skater("Djoos", "Defense", "Sweden", "Left", 3, 11, 14, 13));
		roster.add(new Skater("Bowey", "Defense", "Canada", "Right", 0, 12, 12, -3));
		roster.add(new Skater("Orpik", "Defense", "USA", "Left", 0, 10, 10, -9));
		roster.add(new Skater("Chorney", "Defense", "Canada", "Left", 1, 3, 4, 8));
		roster.add(new Skater("Jerabek", "Defense", "Czech Republic", "Left", 1, 3, 4, -1));
		roster.add(new Skater("Kempny", "Defense", "Czech Republic", "Left", 2, 1, 3, 1));
		roster.add(new Skater("Ness", "Defense", "USA", "Left", 0, 1, 1, 2));
		roster.add(new Goalie("Grubauer", "Goalie", "Germany", "NA", 953, 73, 880));	
	}
	
	//getter
	public ArrayList<HockeyPlayer> getRoster(){
		return roster;	
	}	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class LambdaSearch{
	//print method
	private static void print(ArrayList<HockeyPlayer> roster, Predicate<HockeyPlayer> predicate){
		try{
			for(HockeyPlayer player : roster){
				if(predicate.test(player)){
					System.out.print(player +  ", " );
				}
			}
			System.out.println();
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to print roster by position w/out lambda expressions
	public static void printRoster(String[] positions, ArrayList<HockeyPlayer> roster){
		System.out.println("2017 - 2018 Regular Season Roster:\n");
		try{
			for(String position : positions){
				for(HockeyPlayer h : roster){
					if(h.isPosition(position))
						System.out.println(h.rosterOutput());	
				}
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}	
	}
	
	//method to filter roster by position
	public static void printLambdaRoster(String[] positions, ArrayList<HockeyPlayer> roster){
		try{
			for(String position : positions){
				System.out.print(position.toUpperCase() + ": ");
				print (roster, h -> h.isPosition(position));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to filter players by country of birth
	public static void printLambdaBirthplaces(String[] bp, ArrayList<HockeyPlayer> roster){
		try{
			for(String country: bp){
				System.out.print("BORN IN " + country.toUpperCase() + ":  ");
				print (roster, h -> h.isBornHere(country));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	//method to filter skaters who shoot left/right
	public static void printLambdaShoots(String[] shoots, ArrayList<HockeyPlayer> roster){
		try{
			for(String shot : shoots){
				System.out.print("SHOOTS " + shot.toUpperCase() +":  ");
				print(roster, h -> h.isShot(shot));
			}
		}
		catch(NullPointerException np){
			System.out.println("Null Pointer Exception: " + np);	
		}
		catch(Exception e){
			System.out.println("Exception: " + e);	
		}
	}
	
	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Output{
	private BufferedReader reader;
	
	public Output(){
		setReader();
	}
	
	//setter
	public void setReader(){
		reader = new BufferedReader(new InputStreamReader(System.in));		
	}
	
	//getter
	public BufferedReader getReader(){
		return reader;
	}
	
	public int userChoice(){
		int userChoice = 0;
		try{
			System.out.print("Enter selection: ");
			userChoice = Integer.parseInt(reader.readLine());	
			System.out.println("********************************************************************");
		}
		catch(Exception e){
			System.out.println("Exception in userChoice method: " + e + ".");
		}
		return userChoice;
	}
	
	public void mainMenu(){
		Roster r = new Roster();
		System.out.println("\n********************************************************************");
		System.out.println("WELCOME TO HOCKEY DATA ANALYTICS!");
		System.out.println("\nMake a selection: \n\t1.) Roster \n\t2.) Player Bios \n\t3.) Players Grouped by Position \n\t4.) Skaters Grouped by Shoots L/R \n\t5.) Players Grouped by Country of Birth \n\t6.) Defensemen Points \n\t7.) Forwards' Goals \n\t8.) Goalie's Shots Against \n\n\t9.) EXIT\n");	
		int choice = userChoice();
		switch(choice){
		case 1: String[] positions = {"Forward, LW", "Forward, C", "Forward, RW", "Defense", "Goalie"};
			LambdaSearch.printRoster(positions, r.getRoster());
			break;
		case 2: System.out.println("**********************************************************************");
			System.out.println("\n**********************************************************************");
			System.out.println("(2017 - 2018 Regular Season Roster) Player Bios\n");
			for(HockeyPlayer o : r.getRoster()){
				System.out.println(o.printGeneralInfo());	
			}
			break;
		case 3: System.out.println("Players Grouped by Position: ");
			String[] p = {"Forward", "Forward, LW", "Forward, C", "Forward, RW", "Defense", "Goalie"};
			LambdaSearch.printLambdaRoster(p, r.getRoster());
			break;
		case 4: System.out.println("Skaters Grouped by Shoots L/R: ");
			String[] shoots = {"Left", "Right"};
			LambdaSearch.printLambdaShoots(shoots, r.getRoster());
			break;
		case 5: System.out.println("Players Grouped by Country of Birth");
			String[] birthplaces = {"Russia", "Czech Republic", "USA", "Canada", "Wales", "Austria", "Sweden", "Denmark", "Germany"};
			LambdaSearch.printLambdaBirthplaces(birthplaces, r.getRoster());
			break;
		case 6: System.out.println("Defensemen Points: ");
			for(HockeyPlayer player : r.getRoster()){
				if(player.isPosition("Defense")){
					System .out.println(player + "'s Points: " + player.getStats()[2]); 	
				}
			}
			break;
		case 7: System.out.println("Forwards' Goals: ");
			for(HockeyPlayer player : r.getRoster()){
				if(player.isPosition("Forward")){
					System .out.println(player + "'s Goals: " + player.getStats()[0]); 	
				}
			}
			break;
		case 8: System.out.println("Goalie's Shots Against: ");
			for(HockeyPlayer player : r.getRoster()){
				if(player.isPosition("Goalie")){
					System .out.println(player + "'s Shots Against: " + player.getStats()[0]); 	
				}
			}
			break;
		case 9: System.out.print("  You selected: EXIT");
			System.exit(0);
			break;
		default: mainMenu();
			break;
		}
		mainMenu();
	}
	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ClassDesignV2{
	public static void main(String... args){		
		Output output = new Output();
		output.mainMenu();
	}
}