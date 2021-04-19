package maciej.grochowski.user;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private boolean isRentalPaid;
    private boolean isActive;
    private String roles;

    public User() {
    }

    public User(Integer id, String userName, String address, boolean isRentalPaid, boolean isActive, String roles) {
        this.id = id;
        this.userName = userName;
        this.password = address;
        this.isRentalPaid = isRentalPaid;
        this.isActive = isActive;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRentalPaid() {
        return isRentalPaid;
    }

    public void setRentalPaid(boolean rentalPaid) {
        isRentalPaid = rentalPaid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isRentalPaid=" + isRentalPaid +
                ", isActive=" + isActive +
                ", roles='" + roles + '\'' +
                '}';
    }
}
