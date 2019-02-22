package com.example.controller;
import com.example.bean.TbUser;
import com.example.dao.UserDao;
import com.example.service.UserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("login")
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
    @GetMapping("/getAll")
    @ResponseBody
    public List<TbUser> getAll(){
        return userInterFace.getAllUser();
    }
}
