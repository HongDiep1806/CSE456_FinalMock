package vn.edu.eiu.cse456.fecse4562131200119review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse4562131200119review.model.User;
import vn.edu.eiu.cse456.fecse4562131200119review.repository.UserRepo;

import java.util.List;

@Service
public class UserService{
    @Autowired
    UserRepo userRepo;
    public void save (User user){
        userRepo.save(user);
    }
    public User findByUserName(String username){
        return userRepo.searchUserByUserNameIgnoreCase(username);
    }
}
