import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String zipCode;
    public static HashMap<String,Gate> entryGates;
    public static HashMap<String,Gate> exitGates;
    public static HashMap<String,ParkingFloor> parkingFloors;
    public static HashMap<String,Ticket> tickets;

}
