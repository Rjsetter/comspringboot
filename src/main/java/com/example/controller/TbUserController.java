package com.example.controller;
import com.example.bean.TbUser;
import com.example.service.UserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Controller层实现，User模块
 */
@Controller
@RequestMapping("tbuser")
public class TbUserController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);
    @Autowired
    private UserInterFace userInterFace;

    //对外访问接口，增加用户接口
    //http://localhost:8080/tbuser/add?userName=RJsetter&userPassword=123456&userSex=M&userEmail=1039339929@qq.com&userQq=1039339929
    @GetMapping("add")
    @ResponseBody
    public String add(String userName,String userPassword,String userSex,String userEmail,String userQq){
        TbUser tbUser = new TbUser();
        tbUser.setUserName(userName);
        tbUser.setUserPassword(userPassword);
        tbUser.setUserSex(userSex);
        tbUser.setUserEmail(userEmail);
        tbUser.setUserQq(userQq);
        userInterFace.insertUser(tbUser);
        return "插入成功";
    }

    //增加登录接口
    @PostMapping("login/{username}&{password}")
    @ResponseBody
    public String login(@PathVariable("username") String username,@PathVariable("password") String password){
        System.out.println(userInterFace.login(username,password));
        if(userInterFace.login(username,password)){
            return "登录成功！";
        }else{
            return "登陆失败！";
        }
    }

}
