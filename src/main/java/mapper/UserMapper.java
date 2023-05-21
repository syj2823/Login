package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 测试用
    List<User> selectAll();

    // 根据用户名和密码查询
    User select(@Param("username") String username, @Param("password") String password);

    // 当根据用户名和密码查询为空时，调用它
    User selectByUsername(String username);

    // 没有账号，注册
    int save(User user);

    // 修改密码
    int update(User user);

    // 注销账号
    int deleteById(long id);

}
