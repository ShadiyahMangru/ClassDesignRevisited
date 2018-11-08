import java.util.*;
import java.util.function.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	private String shoots;
	
	//constructor
	public HockeyPlayer(String lastName, String position, String birthplace, String shoots){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
		this.shoots = shoots;
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
	private double savePercentage;
	
	//constructors
	public Goalie(String lastName, String position, String birthplace, String shoots, int goalsAgainst, int saves){
		super(lastName, position, birthplace, shoots);
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
		setShotsAgainst();
		this.shotsAgainst = getShotsAgainst();
		setSavePercentage();
		this.savePercentage = getSavePercentage();
	}
	
	public Goalie(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), hp.getShoots(), goalsAgainst, saves);	
	}
	
	//setters
	public void setShotsAgainst(){
		shotsAgainst = goalsAgainst + saves;
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;
	}	
	
	public void setSavePercentage(){
		try{
			if(shotsAgainst > 0){
				savePercentage = ((double)saves/(double)shotsAgainst)*100;	
			}
			else{
				savePercentage = 0;	
			}
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}
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
	
	public double getSavePercentage(){
		return savePercentage;	
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Skater extends HockeyPlayer{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private int shots;
	private double shootingPercentage;
	
	//constructors
	public Skater(String lastName, String position, String birthplace, String shoots, int goals, int assists, int plusMinus, int shots){
		super(lastName, position, birthplace, shoots);
		this.goals = goals;
		this.assists = assists;
		this.plusMinus = plusMinus;
		this.shots = shots;
		setPoints();
		this.points = getPoints();
		setShootingPercentage();
		this.shootingPercentage = getShootingPercentage();
	}
	
	public Skater(HockeyPlayer hp, String shoots, int goals, int assists, int plusMinus, int shots){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), hp.getShoots(), goals, assists, plusMinus, shots);	
	}
	
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setShots(int shots){
		this.shots = shots;	
	}
	
	public void setShootingPercentage(){
		try{
			if(shots > 0){
				shootingPercentage = ((double)goals/(double)shots)*100;	
			}
			else{
				shootingPercentage = 0;	
			}
		}
		catch(ArithmeticException ae){
			System.out.println("Exception: " + ae + ".");	
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");	
		}
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
	
	public int getShots(){
		return shots;	
	}
	
	public double getShootingPercentage(){
		return shootingPercentage;	
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
		roster.add(new Goalie("Holtby", "Goalie", "Canada", "NA", 153, 1495));
		roster.add(new Skater("Ovechkin", "Forward, LW", "Russia", "Right", 49, 38, 3, 355));
		roster.add(new Skater("Kuznetsov", "Forward, C", "Russia", "Left", 27, 56, 3, 187));
		roster.add(new Skater("Vrana", "Forward, LW", "Czech Republic", "Left", 13, 14, 2, 133));
		roster.add(new Skater("Gersich", "Forward, LW", "USA", "Left", 0, 1, -1, 4));
		roster.add(new Skater("Walker", "Forward, LW", "Wales", "Left", 1, 0, 1, 4));
		roster.add(new Skater("Burakovsky", "Forward, LW", "Austria", "Left", 12, 13, 3, 84));
		roster.add(new Skater("Backstrom", "Forward, C", "Sweden", "Left", 21, 50, 5, 165));
		roster.add(new Skater("Graovac", "Forward, C", "Canada", "Left", 0, 0, -3, 1));
		roster.add(new Skater("Boyd", "Forward, C", "USA", "Right", 0, 1, 2, 2));
		roster.add(new Skater("O'Brien", "Forward, C", "Canada", "Left", 0, 0, 0, 1));
		roster.add(new Skater("Eller", "Forward, C", "Denmark", "Left", 18, 20, -6, 161));
		roster.add(new Skater("Stephenson", "Forward, C", "Canada", "Left", 6, 12, 13, 36));
		roster.add(new Skater("Beagle", "Forward, C", "Canada", "Right", 7, 15, 3, 65));
		roster.add(new Skater("Oshie", "Forward, RW", "USA", "Right", 18, 29, 2, 127));
		roster.add(new Skater("Wilson", "Forward, RW", "Canada", "Right", 14, 21, 10, 123));
		roster.add(new Skater("Connolly", "Forward, RW", "Canada", "Right", 15, 12, -6, 67));
		roster.add(new Skater("Peluso", "Forward, RW", "Canada", "Right", 0, 0, 0, 0));
		roster.add(new Skater("Smith-Pelly", "Forward, RW", "Canada", "Right", 7, 9, -6, 103));
		roster.add(new Skater("Chiasson", "Forward, RW", "Canada", "Right", 9, 9, 1, 59));
		roster.add(new Skater("Carlson", "Defense", "USA", "Right", 15, 53, 0, 237));
		roster.add(new Skater("Orlov", "Defense", "Russia", "Left", 10, 21, 10, 125));
		roster.add(new Skater("Niskanen", "Defense", "USA", "Right", 7, 22, 24, 120));
		roster.add(new Skater("Djoos", "Defense", "Sweden", "Left", 3, 11, 13, 60));
		roster.add(new Skater("Bowey", "Defense", "Canada", "Right", 0, 12, -3, 47));
		roster.add(new Skater("Orpik", "Defense", "USA", "Left", 0, 10, -9, 54));
		roster.add(new Skater("Chorney", "Defense", "Canada", "Left", 1, 3, 8, 14));
		roster.add(new Skater("Jerabek", "Defense", "Czech Republic", "Left", 1, 3, -1, 11));
		roster.add(new Skater("Kempny", "Defense", "Czech Republic", "Left", 2, 1, 1, 32));
		roster.add(new Skater("Ness", "Defense", "USA", "Left", 0, 1, 2, 2));
		roster.add(new Goalie("Grubauer", "Goalie", "Germany", "NA", 73, 880));	
	}
	
	//getter
	public ArrayList<HockeyPlayer> getRoster(){
		return roster;	
	}	
	
	//method to print roster by position w/out lambda expressions
	public void printRoster(String[] positions, ArrayList<HockeyPlayer> roster){
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
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
interface FilterData{
	//print method
	public static void print(ArrayList<HockeyPlayer> roster, Predicate<HockeyPlayer> predicate){
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
	
	//method to filter skater-specific stats
	String [] statOptions = {"Goals", "Assists", "Points", "+/-", "Shots", "Shooting Percentage"};
	public static void printSkaterStat(int indexOfStat, ArrayList<HockeyPlayer> roster){
		System.out.println("Skater's " + statOptions[indexOfStat] + ": ");
			for(HockeyPlayer player : roster){
				if(player.isPosition("Defense") || player.isPosition("Forward")){
					Skater skater = (Skater)player;
					switch(indexOfStat){
					case 0: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getGoals()); 
						break;
					case 1: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getAssists()); 
						break;
					case 2: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getPoints());
						break;
					case 3: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getPlusMinus());
						break;
					case 4: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getShots());
						break;
					case 5: System.out.println(skater + "'s " + statOptions[indexOfStat] + ": " + skater.getShootingPercentage()); 
						break;
					}
				}
			}
	}
	
	//method to filter goalie-specific stats
	String [] gStatOptions = {"Shots Against", "Goals Against", "Saves", "Save Percentage"};
	public static void printGoalieStat(int indexOfStat, ArrayList<HockeyPlayer> roster){
		System.out.println("Goalie's " + gStatOptions[indexOfStat] + ": ");
			for(HockeyPlayer player : roster){
				if(player.isPosition("Goalie")){
					Goalie goalie = (Goalie)player;
					switch(indexOfStat){
					case 0: System.out.println(goalie + "'s " + gStatOptions[indexOfStat] + ": " + goalie.getShotsAgainst()); 
						break;
					case 1: System.out.println(goalie + "'s " + gStatOptions[indexOfStat] + ": " + goalie.getGoalsAgainst());
						break;
					case 2: System.out.println(goalie + "'s " + gStatOptions[indexOfStat] + ": " + goalie.getSaves()); 
						break;
					case 3: System.out.println(goalie + "'s " + gStatOptions[indexOfStat] + ": " + goalie.getSavePercentage() + " -OR- " + goalie.getSavePercentage()/100.00 + " (the latter because this stat sometimes reported like this...)"); 
						break;
					}
				}
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
		catch(NumberFormatException nfe){
			System.out.println("NumberFormatException in userChoice method: " + nfe + ".");	
		}
		catch(IOException ie){
			System.out.println("IOException in userChoice method: " + ie + ".");	
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
		System.out.println("\nMake a selection: \n\t1.) Roster \n\t2.) Player Bios \n\t3.) Players Grouped by Position \n\t4.) Skaters Grouped by Shoots L/R " +
			"\n\t5.) Players Grouped by Country of Birth \n\t6.) Skater's Goals \n\t7.) Skater's Assists \n\t8.) Skater's Points \n\t9.) Skater's +/- \n\t10.) Skater's Shots \n\t11.) Skater's Shooting Percentage " + 
			"\n\t12.) Goalie's Shots Against \n\t13.) Goalie's Goals Against \n\t14.) Goalie's Saves \n\t15.) Goalie's Save Percentage \n\n\t16.) EXIT\n");	
		int choice = userChoice();
		switch(choice){
		case 1: String[] positions = {"Forward, LW", "Forward, C", "Forward, RW", "Defense", "Goalie"};
			r.printRoster(positions, r.getRoster());
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
			FilterData.printLambdaRoster(p, r.getRoster());
			break;
		case 4: System.out.println("Skaters Grouped by Shoots L/R: ");
			String[] shoots = {"Left", "Right"};
			FilterData.printLambdaShoots(shoots, r.getRoster());
			break;
		case 5: System.out.println("Players Grouped by Country of Birth");
			String[] birthplaces = {"Russia", "Czech Republic", "USA", "Canada", "Wales", "Austria", "Sweden", "Denmark", "Germany"};
			FilterData.printLambdaBirthplaces(birthplaces, r.getRoster());
			break;
		case 6: FilterData.printSkaterStat(0, r.getRoster());
			break;
		case 7: FilterData.printSkaterStat(1, r.getRoster());
			break;
		case 8: FilterData.printSkaterStat(2, r.getRoster());
			break;
		case 9: FilterData.printSkaterStat(3, r.getRoster());
			break;
		case 10: FilterData.printSkaterStat(4, r.getRoster());
			break;
		case 11: FilterData.printSkaterStat(5, r.getRoster());
			break;
		case 12: FilterData.printGoalieStat(0, r.getRoster());
			break;
		case 13: FilterData.printGoalieStat(1, r.getRoster());
			break;
		case 14: FilterData.printGoalieStat(2, r.getRoster());
			break;
		case 15: FilterData.printGoalieStat(3, r.getRoster());
			break;
		case 16: System.out.print("  You selected: EXIT");
			System.exit(0);
			break;
		default: mainMenu();
			break;
		}
		mainMenu();
	}
	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ClassDesignV3{
	public static void main(String... args){		
		Output output = new Output();
		output.mainMenu();
	}
}