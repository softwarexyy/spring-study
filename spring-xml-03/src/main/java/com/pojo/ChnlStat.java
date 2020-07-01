package com.pojo;

public class ChnlStat {
    private String openTime;
    private String stat;

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "ChnlStat{" +
                "openTime='" + openTime + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
