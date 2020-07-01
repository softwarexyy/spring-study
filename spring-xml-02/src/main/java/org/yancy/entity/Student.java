package org.yancy.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
    private String name;
    private List<String> books;
    private Map<String, String> cert;   // 证件类型、证件号
    private Set<String> hobbies;
    Properties properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Map<String, String> getCert() {
        return cert;
    }

    public void setCert(Map<String, String> cert) {
        this.cert = cert;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                ", cert=" + cert +
                ", hobbies=" + hobbies +
                ", properties=" + properties +
                '}';
    }
}
