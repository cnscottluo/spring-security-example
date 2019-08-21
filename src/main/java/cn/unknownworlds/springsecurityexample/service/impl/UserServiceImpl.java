package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.UserModel;
import cn.unknownworlds.springsecurityexample.mapper.UserMapper;
import cn.unknownworlds.springsecurityexample.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel selectByName(String username) {
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserModel::getName, username);
        return this.userMapper.selectOne(queryWrapper);
    }

    @Override
    public UserModel selectByPhone(String phone) {
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserModel::getPhone, phone);
        return this.userMapper.selectOne(queryWrapper);
    }
}
