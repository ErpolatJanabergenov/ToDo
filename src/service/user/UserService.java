package service.user;

import model.User;
import service.BaseService;

public interface UserService extends BaseService<User> {
   User singIn(String username, String password);
}
