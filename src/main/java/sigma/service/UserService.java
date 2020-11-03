package sigma.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sigma.dao.UserDao;
import sigma.model.User;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
