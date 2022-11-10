/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* Constructor for Cafe building object
     * @param n name of building
     * @param a address
     * @param nCoffeeOunces ounces of coffee available in the cafe
     * @param nSugarPackets number of packets in cafe
     * @param nCreams number of creams in cafe
     * @param nCups number of cups in cafe
     */
    public Cafe(String n, String a, int nF, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(n, a, nF);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /*
     * Default constructor for Cafe
     */
    public Cafe(){
        this.name = "Campus Center Cafe";
        this.address = "Smith College Campus Center, 100 Elm St, Northampton, MA 01063";
    }

    /* Constructor for if stock is unknown*/
    public Cafe(String n, String a, int nF){
        super(n, a, nF);
    }

    /* removes products from inventory when a coffee is sold
     * @param size size of drink
     * @param nSugarPackets number of packets of sugar in drink
     * @param nCreams number of creams in drink
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups --;

        if(this.nCoffeeOunces < 0 || this.nSugarPackets < 0 || this.nCreams < 0 || this.nCups < 0){
            restock(100,100,100,100);
        }

    }

    /* Restocks cafe when inventory is low.
     * @param nCoffeeOunces number of ounces to add
     * @param nSugarPackets number of packets of sugar to add
     * @param nCreams number of creams to add
     * @param nCups number of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){

        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;

    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + Your café has: this.nCoffeeOunces ounces of coffee\n this.nSugarPackets number of sugar packets\n + this.nCreams + number of creams\n + this.nCups + number of cups");
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1) {
            throw new RuntimeException("Invalid floor number. Only employees are allowed past the first floor.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
    
    public static void main(String[] args) {

    }    
    
}
