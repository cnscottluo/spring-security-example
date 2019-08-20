package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.RoleModel;
import cn.unknownworlds.springsecurityexample.mapper.RoleMapper;
import cn.unknownworlds.springsecurityexample.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired} )
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public RoleModel selectById(Integer roleId) {
        return this.roleMapper.selectById(roleId);
    }

    @Override
    public RoleModel selectByName(String roleName) {

        QueryWrapper<RoleModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleModel::getName,roleName);
        return this.roleMapper.selectOne(queryWrapper);

    }
}
