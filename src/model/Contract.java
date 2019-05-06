package model;

import java.util.*;

public class Contract {

    int clientID;
    String startDate;
    String finishDate;

    public Contract(int clientID, String startDate, String finishDate) {
        this.clientID = clientID;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getClientID() {
        return this.clientID;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getFinishDate() {
        return this.finishDate;
    }

}
