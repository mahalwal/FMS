package me.manishmahalwal.android.fms2;

public class CleanComplaint {
    public String complaintNum, complaintType, complaintFrom, complaintTo, complaintRoom, ComplaintDescription, locationBuilding;
    public int priority;
    public String completed;
    public CleanComplaint(String complaintNum, String complaintType, String complaintFrom, String complaintTo, String complaintRoom,int priority, String complaintDescription, String completed, String locationBuilding) {
        this.complaintNum = complaintNum;
        this.complaintType = complaintType;
        this.complaintFrom = complaintFrom;
        this.complaintTo = complaintTo;
        this.complaintRoom = complaintRoom;
        this.ComplaintDescription = complaintDescription;
        this.priority = priority;
        this.completed = completed;
        this.locationBuilding = locationBuilding;
    }
    public CleanComplaint(){

    }
}