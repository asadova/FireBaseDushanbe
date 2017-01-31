package com.example.myapplication2;

/**
 * Created by Нигина on 28.01.2017.
 */
public class Grant {

    //свойства
    private String grantName;
    private String grantDescription;
    private String deadline;
    private String tag;
    private String place;

    //конструктор для Firebase
    public Grant() {    }

    //конструктор
    public Grant(String grantName, String grantDescription, String deadline, String tag, String place) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.deadline = deadline;
        this.tag = tag;
        this.place = place;
    }


    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getGrantDescription() {
        return grantDescription;
    }

    public void setGrantDescription(String grantDescription) {
        this.grantDescription = grantDescription;
    }

    public String getDeadline() { return deadline;  }

    public void setDeadline(String deadline) { this.deadline = deadline;  }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
