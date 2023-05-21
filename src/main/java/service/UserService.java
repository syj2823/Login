package service;

import entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    List<User> selectAll();

    User select(String username, String password);

    User selectByUsername(String username);

    boolean save(User user);

    boolean update(User user);

    boolean deleteById(long id);
}
