package com.example.myapplication2;

/**
 * Created by Нигина on 28.01.2017.
 */
public class Grant {

    //свойства
    private String grantName;
    private String grantDescription;
    private String grantData;
    private String nechto = "gagaga";

    //конструктор для Firebase
    public Grant() {
    }

    //конструктор
    public Grant(String grantName, String grantDescription, String grantData) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.grantData = grantData;
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

    public String getGrantData() {
        return grantData;
    }

    public void setGrantData(String grantData) {
        this.grantData = grantData;
    }

    public String getNechto() {
        return nechto;
    }

    public void setNechto(String nechto) {
        this.nechto = nechto;
    }
}
