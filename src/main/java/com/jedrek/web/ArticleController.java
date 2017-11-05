package com.jedrek.web;

import com.jedrek.bean.Article;
import com.jedrek.bean.User;
import com.jedrek.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
/**
  显示制定公文title的公文页面
*/
    @RequestMapping("articles/{title}")
    public String showSingleArticle(HttpServletRequest request, @PathVariable String title, Model model) {
        Article article = articleService.queryArticle(title);
        model.addAttribute("article",article);
        HttpSession session = request.getSession();
        session.setAttribute("sessionArticle",article);
        return "articlePage";
    }
/**
显示创建公文的页面
*/
    @RequestMapping(value = "articles",method = RequestMethod.GET)
    public String showCreateArticle() {
        return "article";
    }

/**
保存新建的公文
*/
    @RequestMapping(value = "articles",method = RequestMethod.POST)
    public String submitArticle(Article article) throws Exception {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        article.setSubmitDate(d);
        int i = articleService.saveArticle(article);
        if(i >= 1) {
            return "redirect:/users/Lsy";
        }
        throw new Exception("新建公文失败");
    }

/**
显示删除公文的页面
*/
    @RequestMapping(value = "articles/delete",method = RequestMethod.GET)
    public String showDeleteArticle() {
        return "deleteArticle";
    }

/**
删除公文
*/
    @RequestMapping(value = "articles/delete",method = RequestMethod.POST)
    public String deleteArticle(String title) {
        Article article = articleService.queryArticle(title);
        if(article != null) {
            int deleteArticle = articleService.deleteArticle(title);
            if(deleteArticle >= 1) {
                return "redirect:/users/Jeese";
            }
        }
        return "error";
    }

/**
显示部门审批页面
*/
    @RequestMapping(value = "articles/departmentReview",method = RequestMethod.GET)
    public String showReview() {
        return "review";
    }
/**
更新部门审批结果
*/
    @RequestMapping(value = "articles/departmentReview",method = RequestMethod.POST)
    public String submitReview(HttpServletRequest request,String title,String departmentPassUser,
                               String departmentReview,String departmentPass) {
        Integer departmentPass2 = Integer.parseInt(departmentPass);
        int i = articleService.updateDepartmentPassStatus(title, departmentReview, departmentPass2, departmentPassUser);
        if(i >= 1) {
            User user = (User)request.getSession().getAttribute("user");
            return "redirect:/users/"+user.getUsername();
        }
        return "error";
    }
/**
显示单位领导的审批页面
*/
    @RequestMapping(value = "articles/unitReview",method = RequestMethod.GET)
    public String showReview2() {
        return "review2";
    }
/**
更新单位领导的审批结果
*/
    @RequestMapping(value = "articles/unitReview",method = RequestMethod.POST)
    public String submitReview2(HttpServletRequest request,String title,String unitPassUser,
                                String unitReview,String unitPass) {
        Integer unitPass2 = Integer.parseInt(unitPass);
        int i = articleService.updateUnitPassStatus(title,unitReview,unitPass2,unitPassUser);
        if(i >= 1) {
            User user = (User)request.getSession().getAttribute("user");
            return "redirect:/users/"+user.getUsername();
        }
        return "error";
    }
}
