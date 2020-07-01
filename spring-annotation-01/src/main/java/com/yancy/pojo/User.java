package com.yancy.pojo;

public class User {
    private String name;
    private String crdlsNo;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrdlsNo() {
        return crdlsNo;
    }

    public void setCrdlsNo(String crdlsNo) {
        this.crdlsNo = crdlsNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", crdlsNo='" + crdlsNo + '\'' +
                ", age=" + age +
                '}';
    }
}
