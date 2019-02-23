package com.example.controller;
import com.example.bean.TbUser;
import com.example.service.UserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


/**
 * Controller层实现，User模块
 */
@Controller
@RequestMapping("user")
public class TbUserController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);
    @Autowired
    private UserInterFace userInterFace;

    //登录页面
    @GetMapping("login")
    public String login(){
        return "login/login";
    }

    //验证登录
    @PostMapping("/loginVerify")
    public String loginVerify(String username, String password){
        TbUser user = new TbUser();
        user.setUserName(username);
        user.setUserPassword(password);
        logger.info("开始判断登录验证，登录名："+username+"，密码："+password);
        boolean verify = userInterFace.verifyLogin(user);
        logger.info("判断登录验证是否成功："+verify);
        if (verify) {
        //session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            logger.info("登录成功，进入主页！");
            return "login/index";
        } else {
            logger.info("登录失败，重定向到登录页面！");
            return "login/error";
        }
    }
    //注销页面
    @GetMapping("/logout")
    public String logout(){
    //session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        logger.info("用户退出登录！");
        return "redirect:/user/login";
    }

    //登录页面
    @GetMapping("/register")
    public String register(){
        return "login/register";
    }
    //注册接口
    @PostMapping("/registers")
    public String register(String username,String password,String usersex,String useremail,String userqq){
        TbUser tbUser = new TbUser();
        tbUser.setUserName(username);
        tbUser.setUserPassword(password);
        tbUser.setUserSex(usersex);
        tbUser.setUserEmail(useremail);
        tbUser.setUserQq(userqq);
        logger.info("注册用户信息为："+tbUser.toString());
        userInterFace.insertUser(tbUser);
        return "login/login";
    }


    //对外访问接口，增加用户接口
    //http://localhost:8080/tbuser/add?userName=RJsetter&userPassword=123456&userSex=M&userEmail=1039339929@qq.com&userQq=1039339929
//    @GetMapping("/add")
//    @ResponseBody
//    public String add(String userName,String userPassword,String userSex,String userEmail,String userQq){
//        TbUser tbUser = new TbUser();
//        tbUser.setUserName(userName);
//        tbUser.setUserPassword(userPassword);
//        tbUser.setUserSex(userSex);
//        tbUser.setUserEmail(userEmail);
//        tbUser.setUserQq(userQq);
//        userInterFace.insertUser(tbUser);
//        return "插入成功";
//    }

    //增加登录接口
    @GetMapping("logins")
    public ModelAndView login(String username, String password){
        //传递参数
        ModelAndView mv = new ModelAndView();
        if(userInterFace.login(username,password)){
            mv.addObject("username", username);
            mv.setViewName("redirect:/user/selectOne");
            return mv;
        }else{
            mv.setViewName("redirect:/user/getAll");
            return mv;
        }
    }


    //增加按姓名查询接口
    @GetMapping("selectOne")
    @ResponseBody
    public String selectOne(String username){
        TbUser user = userInterFace.selectOneByUserName(username);
        return user.toString();
    }

    //增加更新接口
    @GetMapping("update")
    @ResponseBody
    public String update(String userName,String userPassword,String userSex,String userEmail,String userQq) {
        TbUser updateUser = userInterFace.selectOneByUserName(userName);
        updateUser.setUserName(userName);
        updateUser.setUserPassword(userPassword);
        updateUser.setUserSex(userSex);
        updateUser.setUserEmail(userEmail);
        updateUser.setUserQq(userQq);
        userInterFace.update(updateUser);
        return "";
    }

    //查询所有用户接口
    @PostMapping("/getAll")
    @ResponseBody
    public List<TbUser> getAll(){
        return userInterFace.getAllUser();
    }


}
