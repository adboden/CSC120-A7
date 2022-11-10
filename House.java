/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /* Constructor for House object
   * @param n name
   * @param a address
   * @param nF number of floors
   * @param hDR whether or not house has a dining room
   */
  public House(String n, String a, int nF, boolean hDR) {
    super(n, a, nF);
    hasDiningRoom = hDR;
    this.residents = new ArrayList<String>();
  }

  /* Constructor for if dining room is unknown */
  public House (String n, String a, int nF) {
    super(n, a, nF);
    this.residents = new ArrayList<String>();
  }

  /* Returns if house has dining room
   * @return boolean t/f if room has dining room
   */
  public boolean hasDiningRoom(){

    return hasDiningRoom;

  }

  /*
   * @return int number of residents
   */
  public int nResidents(){

    return this.residents.size();

  }

  /* Adds a resident to a house
   * @param name of resident to add to house
   */
  public void moveIn(String name){

    this.residents.add(name);

  }

  /* Moves a resident out of a house
   * @param name of resident moving out
   * @return String name of resident moving out
   */
  public String moveOut(String name){ 

    this.residents.remove(name);
    return name + " has moved out of " + getName() + ".";

  }

  /* Navigation methods */
  public Building enter() {
    if (activeFloor != -1) {
        throw new RuntimeException("You are already inside this Building.");
    }
    this.activeFloor = 1;
    if(this.name.equals("Jordan House")){
      System.out.println("You are now inside " + this.name + " on the second floor.");
    }
    else
    System.out.println("You are now inside " + this.name + " on the ground floor.");
    return this; // Return a pointer to the current building
}

  /* Tells user if someone is a resident in a house
   * @param name of resident checking to see if lives in house
   * @return boolean t/f is name is a resident in house
   */
  public boolean isResident(String name){
    if(this.residents.contains(name))
      return true;
    else
      return false;
  }

  /*
   * Displays options for house.
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    if(this.hasDiningRoom){
      System.out.println("This house has a dining room.");
    }
    else{
      System.out.println("This house does not have a dining room.");
    }
}

  public static void main(String[] args) {
    
  }

}