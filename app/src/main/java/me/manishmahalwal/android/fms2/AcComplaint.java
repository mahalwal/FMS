package me.manishmahalwal.android.fms2;

public class AcComplaint {
    public String complaintNum, complaintType, complaintFrom, complaintTo, complaintRoom, ComplaintDescription;
    public int priority;

    public AcComplaint(String complaintNum, String complaintType, String complaintFrom, String complaintTo, String complaintRoom,int priority, String complaintDescription) {
        this.complaintNum = complaintNum;
        this.complaintType = complaintType;
        this.complaintFrom = complaintFrom;
        this.complaintTo = complaintTo;
        this.complaintRoom = complaintRoom;
        this.ComplaintDescription = complaintDescription;
        this.priority = priority;
    }

}
