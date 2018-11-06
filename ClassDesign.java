import java.util.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String shoots;
	private String birthplace;
	
	//constructor
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
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
	
	public String toString(){
		return lastName + " is a " + position; 	
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Goalie extends HockeyPlayer{
	//fields
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	
	//constructors
	public Goalie(String lastName, String position, String birthplace, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position, birthplace);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalie(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), shotsAgainst, goalsAgainst, saves);	
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
		return super.toString() + " with " + saves + " saves."	;
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
		super(lastName, position, birthplace);
		this.shoots = shoots;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	public Skater(HockeyPlayer hp, String shoots, int goals, int assists, int points, int plusMinus){
		this(hp.getLastName(), hp.getPosition(), hp.getBirthplace(), shoots, goals, assists, points, plusMinus);	
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
		return super.toString() + " with " + goals + " goals. ";	
	}
	
	public String printGeneralInfo(){
	 	return super.toString() + " who was born in " + this.getBirthplace() + ".";	
	}
	
	public String printPositionInfo(){
		return toString();
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Roster{
	//fields
	private ArrayList<Object> roster;

	//constructor
	public Roster(){
		setRoster();	
	}

	//setter
	public void setRoster(){
		roster = new ArrayList<Object>();
		roster.add(new Goalie("Holtby", "Goalie", "Canada", 1648, 153, 1495));
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
		roster.add(new Goalie("Grubauer", "Goalie", "Germany", 953, 73, 880));	
	}
	
	//getter
	public ArrayList<Object> getRoster(){
		return roster;	
	}	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ClassDesign{
	public static void main(String... args){
		
		System.out.println("**********************************************************************");
		System.out.println("Class Inheritance Review\n");
		
		HockeyPlayer hp = new HockeyPlayer("Holtby", "Goalie", "Canada");
		HockeyPlayer g = new Goalie(hp, 1648, 153, 1495);
		HockeyPlayer s = new Skater("Ovechkin", "Forward, LW", "Russia", "Right", 49, 38, 87, 3);
		Skater sk = new Skater("Kuznetsov", "Forward, C", "Russia", "Left", 27, 56, 83, 3);
		Skater d = new Skater("Djoos", "Defense", "Sweden", "Left", 3, 11, 14, 13);
		HockeyPlayer df = new Skater("Djoos", "Defense", "Sweden", "Left", 3, 11, 14, 13);	
		
		System.out.println(hp.toString());
		System.out.println(g.toString());
		System.out.println(s.toString());
		System.out.println(sk.toString());
		System.out.println(sk.printGeneralInfo());
		System.out.println(sk.printPositionInfo());
		System.out.println(d.printGeneralInfo());
		System.out.println(d.printPositionInfo());
		System.out.println(df.toString());
		
		System.out.println("\n**********************************************************************");
		System.out.println("Differentiate among Positions\n");
		Roster r = new Roster();
		for(Object o : r.getRoster()){
			System.out.println(o.toString());	
		}
	}
}