import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    public String id;
    public String floor;
    public HashMap<String,ParkingSpot> parkingSpots;
    public int freeSmall;
    public int freeMedium;
    public int freeLarge;
    public int freeXlarge;
    public int totalSmall;
    public int totalMedium;
    public int totalLarge;
    public int totalXlarge;

    public Ticket assignVehicle(Vehicle vehicle,Type type){
        Ticket ticket =null;
        for(Map.Entry<String,ParkingSpot> spot:parkingSpots.entrySet()){
            if(spot.getValue().spotType==type && spot.getValue().isSpotFree()){
                if(type==Type.SMALL){
                    freeSmall=-1;
                }
                if(type==Type.MEDIUM){
                    freeMedium=-1;
                }
                if(type==Type.LARGE){
                    freeLarge=-1;
                }
                if(type==Type.XLARGE){
                    freeXlarge=-1;
                }
                ticket=spot.getValue().assignVehicleToSpot(vehicle);
                ticket.spot=spot.getValue();
            }
        }
        return ticket;

    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.put(parkingSpot.id,parkingSpot);
        switch(parkingSpot.spotType){
            case SMALL:{
                this.totalSmall=this.totalSmall+1;
            }
            case MEDIUM:{
                this.totalMedium=this.totalMedium+1;
            }
            case LARGE:{
                this.totalLarge=this.totalLarge+1;
            }
            case XLARGE:{
                this.totalXlarge=this.totalXlarge+1;
            }
        }
    }
    public void removeParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.remove(parkingSpot.id);
        switch(parkingSpot.spotType){
            case SMALL:{
                this.totalSmall=this.totalSmall-1;
            }
            case MEDIUM:{
                this.totalMedium=this.totalMedium-1;
            }
            case LARGE:{
                this.totalLarge=this.totalLarge-1;
            }
            case XLARGE:{
                this.totalXlarge=this.totalXlarge-1;
            }
        }
    }

}
