package pl.coderslab.handyman.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orderuser")
public class OrderUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @Size(min = 5, max = 1200)
    private String orderText;

    private LocalDateTime time;
    @Column(precision = 10, scale = 2)
    private double price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Handyman handyman;
}
