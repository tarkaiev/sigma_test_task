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

    public void update(User user) {
        User userFromDb = findByLogin(user.getLogin());
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setDateOfBirth(user.getDateOfBirth());
        userFromDb.setAbout(user.getAbout());
        userFromDb.setAddress(user.getAddress());
        userFromDb.setPassword(user.getPassword());
        userDao.update(userFromDb);
    }

    public void delete(User user) {
        User userFromDb = findByLogin(user.getLogin());
        userFromDb.setDeleted(true);
        userDao.update(userFromDb);
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
