package me.manishmahalwal.android.fms2;

public class CarpentComplaint {
    public String complaintNum, complaintType, complaintFrom, complaintTo, complaintRoom, ComplaintDescription;
    public int priority;

    public CarpentComplaint(String complaintNum, String complaintType, String complaintFrom, String complaintTo, String complaintRoom, int priority, String ComplaintDescription) {
        this.complaintNum = complaintNum;
        this.complaintType = complaintType;
        this.complaintFrom = complaintFrom;
        this.complaintTo = complaintTo;
        this.complaintRoom = complaintRoom;
        this.priority = priority;
        this.ComplaintDescription = ComplaintDescription;
    }
}