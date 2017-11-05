package com.jedrek.web;

import com.github.pagehelper.PageInfo;
import com.jedrek.bean.Article;
import com.jedrek.bean.User;
import com.jedrek.service.ArticleService;
import com.jedrek.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PipedOutputStream;
import java.util.*;

@Controller
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private ArticleService articleService;

    @Autowired
    public UserController(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    /**
     * 跳转到相关角色的页面
     * @param request
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("users/{username}")
    public String getUserOffer(HttpServletRequest request, @PathVariable String username, Model model) {
        User user = userService.queryUserByName(username);
        List<Article> articlesByWriter = articleService.queryArticlesByWriter(user.getUsername());
        List<Article> articles = articleService.queryArticleByPublic();
        List<Article> departmentArticles = articleService.queryDepartmentArticles();
        List<Article> unitArticles = articleService.queryUnitArticles();
        List<Article> articleList = articleService.queryAllArticles();
        List<User> allUsers = userService.queryUsers();

        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        model.addAttribute("articlesByWriter",articlesByWriter);
        model.addAttribute("articles",articles);
        model.addAttribute("user",user);
        model.addAttribute("departmentArticles",departmentArticles);
        model.addAttribute("unitArticles",unitArticles);
        model.addAttribute("articleList",articleList);
        model.addAttribute("allUsers",allUsers);
        int degree = userService.queryDegreeByName(username);
        if(degree == 2) {  // 角色为普通职员
            return "employee";
        } else if(degree == 3) {
            return "department";
        } else if(degree == 4) {
            return "admin";
        } else if(degree == 5) {
            return "unit";
        }
        return "error";
    }

    /**
     * 跳转到更改密码的页面
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "users/password",method = RequestMethod.GET)
    public String showPassword(@RequestParam String username, Model model) {
        User user = userService.queryUserByName(username);
        model.addAttribute("user",user);
        return "password";
    }

    /**
     * 修改密码
     * @param username
     * @param password1
     * @return
     */
    @RequestMapping(value = "users/password",method = RequestMethod.POST)
    public String changePassword(@RequestParam String username, String password1) {
        int i = userService.updateUserPassword(username, password1);
        if(i >= 1) { //修改成功
            return "redirect:/";
        }
        return "error";
    }

    /**
     * 显示添加用户的页面
     * @return
     */
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public String showSubmitUser() {
        return "user";
    }

    /**
     * 提交新的用户，保存于数据库
     * @param user
     * @return
     */
    @RequestMapping(value = "users",method= RequestMethod.POST)
    public String submitUser(User user) {
        try {
            int saveUser = userService.saveUser(user);
            if (saveUser >= 1) {
                return "redirect:/users/Jeese";
            }
        } catch (Exception e) {
            throw e;
        }
        return "error";
    }

    /**
     * 显示删除用户的页面
     * @return
     */
    @RequestMapping(value = "users/delete", method = RequestMethod.GET)
    public String showDeleteUser() {
        return "deleteUser";
    }

    /**
     * 删除制定的用户
     * @param request
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "users/delete",method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request, String username,Model model) {
        HttpSession session = request.getSession();
        Object sessionAttribute = session.getAttribute("user");
        model.addAttribute("user",sessionAttribute);
        User user = userService.queryUserByName(username);
        if(user != null) {
            int deleteUser = userService.deleteUser(username);
            if(deleteUser >= 1) {
                return "redirect:/users/Jeese";
            }
        }
        return "error";
    }
}
