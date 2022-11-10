/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building { 

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /* Constructor for the Library class
     * @param n name of building
     * @param a address
     * @param number of floors
     */
    public Library(String n, String a, int nF, boolean hE) {
      super(n, a, nF);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hE;
      System.out.println("You have built a library: 📖");
    }

    /* Default constructor for Library as Neilson Library */
    public Library(){
      this.name = "Neilson Library";
      this.address = "7 Neilson Drive, Northampton, MA 01063";
      this.nFloors = 4;
    }

    /* Constructor for unknown address and floor number */
    public Library(String a) {
      this.address = a;
    }

    /* Adds a book to the library's collection
     * @param title is the title to add to the library
     */
    public void addTitle(String title){

      collection.put(title, true);

    }

    /* Takes a title away from the library's collection
     * @param title is the title to be removed
     * @return String returns the title that has been removed.
     */
    public String removeTitle(String title){

      collection.remove(title);
      return "You have removed" + title;

    }

    /* Makes a books availability false
     * @param title is the title getting checked out
     */
    public void checkOut(String title){

      collection.replace(title, false);

    }

    /* Retruns a book and sets availability as true
     * @param title is the title being returned
     */
    public void returnBook(String title){

      collection.replace(title, true);

    }

    /* Tells if a title is in the collection
     * @param title to check if is in the collection
     * @return boolean returns t/f if title is in the collection
     */
    public boolean containsTitle(String title){

      if(collection.containsKey(title))
        return true;
      else
        return false;

    }

    /* returns if a book is available for checkout 
     * @param title is the title being checked
     * @return boolean t/f if the title is available for checkout
     */
    public boolean isAvailable(String title){

      if(collection.get(title))
        return true;
      else
        return false;

    }

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + Your library contains: + printcollection()")
    ;
  }

    /*
     * prints the collection in the library in Hashtable form
     */
    public void printCollection(){

      System.out.println(collection);

    }

    /* Allows moving from one floor to another
     * @param floorNum is the floor the user is going to
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      if(this.hasElevator){
        System.out.println("You took the elevator to floor #" + floorNum + " of " + this.name);
      }
      else{
        System.out.println("You took the stairs to floor #" + floorNum + " of " + this.name);
      }
      this.activeFloor = floorNum;
  }
  
    public static void main(String[] args) {
      
    }
  
  }