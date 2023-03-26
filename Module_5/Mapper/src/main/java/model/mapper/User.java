package model.mapper;

import model.mapper.Role;

import java.util.List;

public class User {
    private String fullName;
    private String password;
    private Integer age;

    private List<Role> roles;

    public User(String fullName, String password, Integer age, List<Role> roles) {
        this.fullName = fullName;
        this.password = password;
        this.age = age;
        this.roles = roles;
    }

    public User() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder rolesStr = new StringBuilder("");
        for (Role role: roles){
            rolesStr.append(role.toString());
        }
        return "User{" +
               "fullName='" + fullName + '\'' +
               ", password='" + password + '\'' +
               ", age=" + age + '\'' +
                ",roles= " + rolesStr +
               '}';
    }
}
