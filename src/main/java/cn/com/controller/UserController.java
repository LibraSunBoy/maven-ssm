package cn.com.controller;

import cn.com.entity.User;
import cn.com.exception.CustomException;
import cn.com.service.UserService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <pre>
 * Filename      :  UserController
 * Package       :  cn.com.controller
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/13日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public Result<User> login(HttpServletRequest request,String account, String pwd){
        User login = userService.login(account, pwd);
        request.getSession().setAttribute("LOGIN_USER",login.getAccount());
        return new Result<>(CustomException.CodeEnum.OK,login);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> add(@RequestBody User user){
        Integer userId = userService.add(user);
        return new Result<>(CustomException.CodeEnum.OK,userId);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<List<User>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize, String account){
        Result<List<User>> list = userService.query(pageNum, pageSize, account);
        return list;
    }
}
