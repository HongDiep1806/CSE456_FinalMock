package vn.edu.eiu.cse456.fecse4562131200119review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.fecse4562131200119review.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User searchUserByUserNameIgnoreCase(String username);

}
