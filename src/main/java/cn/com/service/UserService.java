package cn.com.service;

import cn.com.entity.User;
import cn.com.utils.Result;

import java.util.List;

/**
 * <pre>
 * Filename      :  UserService
 * Package       :  cn.com.service
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/13日
 * </pre>
 *
 * @author : yangdong.jia
 */
public interface UserService {
    /**
     * 登录
     * @param account
     * @param pwd
     * @return
     */
    User login(String account,String pwd);


    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer add(User user);


    /**
     * 查询用户
     * @param account
     * @return
     */
    Result<List<User>> query(Integer pageNum, Integer pageSize, String account);
}
