package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void save(User user);
    User get(Long id);
    void delete(Long id);
}
