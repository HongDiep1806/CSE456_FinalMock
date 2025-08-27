package vn.edu.eiu.cse456.fecse4562131200119review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tbl_User")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "UserName", columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String userName;
    @Column(name = "Password", columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;
    @Column(name = "Role", nullable = false)
    private int role;

    public User() {
    }

    public User(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
