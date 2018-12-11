package pl.coderslab.handyman.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "handyman")
public class Handyman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String password;
    @Column(unique = true)
    @Email
    private String email;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @ManyToMany
//            (cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();
    @OneToMany
            //(mappedBy = "handyman", cascade = CascadeType.ALL)
    private List<OrderUser> orders;
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Tool> tools = new ArrayList<>();
//    @OneToMany(mappedBy = "handyman", cascade = CascadeType.ALL)
//    private List<Message> messages;

    private double rating;
}
