package cn.com.service.impl;

import cn.com.entity.User;
import cn.com.entity.UserExample;
import cn.com.exception.CustomException;
import cn.com.mapper.UserMapper;
import cn.com.service.UserService;
import cn.com.utils.MD5Util;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Filename      :  UserServiceImpl
 * Package       :  cn.com.service.impl
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/13日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String account, String pwd){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andStatusEqualTo(1);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)){
            throw new CustomException(CustomException.CodeEnum.ACCOUNT_ERROR);
        }
        String dbPwd = users.get(0).getPwd();
        if (!MD5Util.MD5EncodeUtf8(pwd).equals(dbPwd)){
            throw new CustomException(CustomException.CodeEnum.PWD_ERROR);
        }
        return users.get(0);
    }

    @Override
    public Integer add(User user) {
        user.setPwd(MD5Util.MD5EncodeUtf8(user.getPwd()));
        user.setStatus(1);
        user.setCreateDate(new Date());
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public Result<List<User>> query(Integer pageNum, Integer pageSize, String account) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample example = new UserExample();
        if (!StringUtils.isEmpty(account)){
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(account);
        }
        List<User> userList = userMapper.selectByExample(example);
        return new Result<>(userList.size(),userList);
    }
}
