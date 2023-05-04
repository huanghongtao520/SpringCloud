package huang.dao;

import com.huang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public void add(User user);
    public List<User> queryAll();
}
