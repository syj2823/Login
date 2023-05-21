package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import controller.util.Code;
import controller.util.Result;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping
//    public Result get() {
//        List<User> users = userService.selectAll();
//        return new Result(Code.SELECT_OK, users, "ok");
//    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping
    public Result select(String username, String password) {
        // 先根据用户名和密码进行查询
        User user1 = userService.select(username, password);
        // 如果返回null,再查询username
        if (user1 == null) {
            User user2 = userService.selectByUsername(username);
            // 如果查询仍为空，则说明用户名不存在
            if (user2 == null) {
                return new Result(Code.SELECT_ERR, null, "用户名不存在，请先注册");
            }else {
                // 否则说明密码错误
                return new Result(Code.SELECT_ERR, null, "密码错误，请重新输入密码");
            }
        } else if (user1.getStatus() == 0) {
            return new Result(Code.SELECT_ERR, null, "您的账号已被禁用！");
        }else {
            return new Result(Code.SELECT_OK, user1,  user1.getUsername() + "您好");
        }


    }

    @PostMapping
    public Result save(@RequestBody User user) {
        String username1 = user.getUsername();
        // 先查询数据库中该用户是否注册
        User user1 = userService.selectByUsername(username1);
        if (user1 != null) {
            return new Result(Code.INSERT_ERR, "null", "该用户以存在，请重新注册");
        }

        boolean save = userService.save(user);

        Integer code = save ? Code.INSERT_OK : Code.INSERT_ERR;
        String msg = save ? "恭喜您注册成功！" : "注册失败，请重新注册！";

        return new Result(code, user, msg);
    }
}
