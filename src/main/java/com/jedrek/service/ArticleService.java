package com.jedrek.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jedrek.bean.Article;
import com.jedrek.mapper.ArticleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {
    private Logger log = LoggerFactory.getLogger(ArticleService.class);
    private ArticleMapper articleMapper;

    @Autowired
    public ArticleMapper getArticleMapper(ArticleMapper articleMapper) {
        return this.articleMapper = articleMapper;
    }

    /**
     * 保存公文
     * @param article
     * @return
     */
    public int saveArticle(Article article) {
        return articleMapper.saveArticle(article);
    }

    /**
     * 删除指定的公文
     * @param title
     * @return
     */
    public int deleteArticle(String title) {
        return articleMapper.deleteArticle(title);
    }

    /**
     * 根据公开程度显示公文列表
     * @param secret
     * @return
     */
    public PageInfo<Article> queryArticles(int currentPage, int pageSize, int secret) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articles = articleMapper.queryArticles(secret);
        PageInfo<Article> pages = new PageInfo<Article>(articles);
        return pages;
    }

    /**
     * 查询单个公文信息
     * @param title
     * @return
     */
    public Article queryArticle(String title) {
        return articleMapper.queryArticle(title);
    }

    /**
     * 查询自己提交的所有公文
     * @param writer
     * @return
     */
    public List<Article> queryArticlesByWriter(String writer) {
        List<Article> articles = articleMapper.queryArticlesByWriter(writer);
        return articles;
    }

    /**
     * 查询所有公开的公文
     * @return
     */
    public List<Article> queryArticleByPublic() {
        List<Article> articles = articleMapper.queryArticleByPublic();
        return articles;
    }
    /**
     * 更新公文的部门审批状态
     * @param articleId
     * @param departmentPass
     * @return
     */
    public int updateDepartmentPassStatus(String title,String departmentReview,
                                          Integer departmentPass,
                                          String departmentPassUser) {
        return articleMapper.updateDepartmentPassStatus(title, departmentReview, departmentPass, departmentPassUser);
    }
    /**
     * 更新公文的单位审批状态
     * @param articleId
     * @param unitPass
     * @return
     */
    public int updateUnitPassStatus(String title,String unitReview,Integer unitPass,
                                    String unitPassUner) {
        return articleMapper.updateUnitPassStatus(title, unitReview, unitPass, unitPassUner);
    }

    /**
     * 列出所有部门审核通过的公文
     * @return
     */
    public List<Article> queryDepartmentArticles() {
        return articleMapper.queryDepartmentArticles();
    }

    /**
     * 列出所有单位审核通过的公文
     * @return
     */
    public List<Article> queryUnitArticles() {
        return articleMapper.queryUnitArticles();
    }

    public List<Article> queryAllArticles() {
        return articleMapper.queryAllArticles();
    }
}
