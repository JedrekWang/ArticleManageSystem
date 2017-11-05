package com.jedrek.mapper;

import com.jedrek.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 保存公文
     * @param article
     * @return
     */
    int saveArticle(Article article);

    /**
     * 删除指定的公文
     * @param title
     * @return
     */
    int deleteArticle(String title);

    /**
     * 根据公开程度显示公文列表
     * @param secret
     * @return
     */
    List<Article> queryArticles(int secret);

    /**
     * 查询单个公文信息
     * @param title
     * @return
     */
    Article queryArticle(String title);

    Article queryArticleById(Integer articleId);

    /**
     * 查询自己提交的所有公文
     * @param writer
     * @return
     */
    List<Article> queryArticlesByWriter(String writer);

    /**
     * 查询所有公开的公文
     * @return
     */
    List<Article> queryArticleByPublic();

    /**
     * 更新公文的部门审批状态
     * @param title
     * @param departmentReview
     * @param departmentPass
     * @param departmentPassUser
     * @return
     */
    int updateDepartmentPassStatus(@Param("title") String title,@Param("departmentReview") String departmentReview,
                                   @Param("departmentPass") Integer departmentPass,
                                   @Param("departmentPassUserId") String departmentPassUser);

    /**
     * 更新公文的单位审批状态
     * @param title
     * @param unitReview
     * @param unitPass
     * @param unitPassUser
     * @return
     */
    int updateUnitPassStatus(@Param("title") String title,@Param("unitReview") String unitReview,
                             @Param("unitPass") Integer unitPass,@Param("unitPassUserId") String unitPassUser);

    /**
     * 列出所有部门审核通过的公文
     * @return
     */
    List<Article> queryDepartmentArticles();

    /**
     * 列出所有单位审核通过的公文
     * @return
     */
    List<Article> queryUnitArticles();

    /**
     * 列出所有的公文
     * @return
     */
    List<Article> queryAllArticles();

}
