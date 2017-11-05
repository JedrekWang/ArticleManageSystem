
package com.jedrek.mapper;

import com.jedrek.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return
     */
    User queryUser(Integer userId);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User queryUserByName(String username);

    /**
     * 删除指定用户
     * @param username
     * @return
     */
    int deleteUser(String username);

    /**
     * 修改用户密码
     * @param username
     * @param password
     * @return
     */
    int updateUserPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 列出所有用户
     * @return
     */
    List<User> queryUsers();

    /**
     * 验证用户的名字与密码
     * @param username
     * @param password
     * @return
     */
    User queryUserByNameAndPassword(@Param("username") String username,@Param("password") String password);

    /**
     * 通过用户名得到级别
     * @param username
     * @return
     */
    int queryDegreeByName(String username);


}