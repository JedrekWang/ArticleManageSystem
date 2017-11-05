package com.jedrek.web;

import com.jedrek.bean.User;
import com.jedrek.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private UserMapper userMapper;

    public MainController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }


    /**
     * 根据登录账号跳转对应页面
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String getMain(HttpServletRequest request, String username, String password) {
        User user;
        if((user = userMapper.queryUserByNameAndPassword(username, password)) != null) { //用户账号存在
            HttpSession session = request.getSession();
            session.setAttribute("currentUser","FUCKER");
            return "redirect:/users/"+username;
        }
        return "error";
    }

}
