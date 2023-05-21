package mapper;

import config.SpringConfig;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void select(){
        User user = userMapper.select("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void selectByUsername(){
        User user = userMapper.selectByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("123456");
        user.setPhone("13212123425");
        user.setEmail("wangwu@qq.com");
        user.setIdNumber("123456123456133457");
        user.setAddress("黑龙江省哈尔滨市");
        user.setGender(0);

        int i = userMapper.save(user);

        System.out.println(i);
    }
}
