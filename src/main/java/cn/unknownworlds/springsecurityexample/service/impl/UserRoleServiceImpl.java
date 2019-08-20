package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.UserRoleModel;
import cn.unknownworlds.springsecurityexample.mapper.UserRoleMapper;
import cn.unknownworlds.springsecurityexample.service.UserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleModel> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleModel> listByUserId(Integer id) {

        QueryWrapper<UserRoleModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserRoleModel::getUserId, id);
        return this.userRoleMapper.selectList(queryWrapper);
    }
}
