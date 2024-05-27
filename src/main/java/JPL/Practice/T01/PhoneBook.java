package JPL.Practice.T01;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class PhoneBook implements Serializable {
    private String name;
    private Set<String> phoneNumber;
    private String email;
    private String address;
    private String group;
    private Date date;

    public PhoneBook(String name, Set<String> phoneNumber, String email, String address, String group, Date date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.group = group;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                '}';
    }

    public boolean findByName(String name){
        return this.name.equals(name);
    }

    public boolean isGroup(String group) {
        return this.group.equals(group);
    }
}
