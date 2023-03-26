package model.mapper;

public class Role {
    private ERole role;

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Role() {
    }

    public Role(ERole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
               "role=" + role +
               '}';
    }
}
