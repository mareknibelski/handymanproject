package pl.coderslab.handyman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.handyman.entity.OrderUser;
import pl.coderslab.handyman.entity.User;

import java.util.List;

public interface OrderUserRepository extends JpaRepository<OrderUser, Long> {

    List<OrderUser> findByUser(User user);

}
