package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private String firstName, lastName, phoneNumber, zipCode, state, gender;
    private FroggerID froggerID;

    public Frogger(Road road, int position, Records records, String firstName, String lastName, String phoneNumber,
    String zipCode, String state, String gender) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = new FroggerID(firstName, lastName, phoneNumber, zipCode, state, gender);
        
        // this.firstName = firstName;
        // this.lastName = lastName;
        // this.phoneNumber = phoneNumber;
        // this.zipCode = zipCode;
        // this.state = state;
        // this.gender = gender;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (!isValid(nextPosition) || road.getOccupied(nextPosition)) {
        // frog donot need to checkOccupied
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    // // TODO: Do you notice any issues here?
    // public boolean isOccupied(int position) {
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }

    // Heavy usage of one class’ data from another (“feature envy”, 
    // “inappropriate intimacy”; poor coupling)
    //  public boolean isOccupied(int position) {
    //     // boolean[] occupied = this.road.getOccupied();
    //     // return occupied[position];
    //     return this.road.getOccupied(position);   
    // }

    
    public boolean isValid(int position) {
        if (position < 0) return false;
        //boolean[] occupied = this.road.getOccupied();
        int length = this.road.getRoadLength();
        //return position < occupied.length;
        return position < length;
    }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
      // boolean success = records.addRecord(firstName, lastName, phoneNumber, zipCode, state, gender);
      boolean success = records.addRecord(froggerID);
      return success;
    }
}
