package pl.coderslab.handyman.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;


    @Column(name = "email")
    @Email(message = "Proszę wpisz prawidołowy adres e-mailowy")
    @NotEmpty
    private String email;


    @Column(name = "password")
    @Length(min = 5, message = "Twoje hasło musi mieć co najmniej 5 znaków")
    @NotEmpty
    private String password;


    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany
    //(mappedBy = "handyman", cascade = CascadeType.ALL)
    private List<OrderUser> orders;
}
