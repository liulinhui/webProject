package com.learn.codeGather.choujiang;

public class Gift {
    private int index;
    private String gitfId;
    private String giftName;
    private double probability;

    public Gift(String giftName, double probability) {
        this.giftName = giftName;
        this.probability = probability;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Gift [index=" + index + ", gitfId=" + gitfId + ", giftName=" + giftName + ", probability=" + probability + "]";
    }

}
