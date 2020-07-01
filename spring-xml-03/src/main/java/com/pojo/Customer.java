package com.pojo;

public class Customer {
    private int usrId;
    private String crdlsTyp;
    private String crdlsNo;

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getCrdlsTyp() {
        return crdlsTyp;
    }

    public void setCrdlsTyp(String crdlsTyp) {
        this.crdlsTyp = crdlsTyp;
    }

    public String getCrdlsNo() {
        return crdlsNo;
    }

    public void setCrdlsNo(String crdlsNo) {
        this.crdlsNo = crdlsNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "usrId=" + usrId +
                ", crdlsTyp='" + crdlsTyp + '\'' +
                ", crdlsNo='" + crdlsNo + '\'' +
                '}';
    }
}
