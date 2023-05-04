package huang.service;

import com.huang.pojo.User;

import java.util.List;

public interface UserService {
    public void add(User user);
    public List<User> queryAll();
}
