package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.PermissionModel;
import cn.unknownworlds.springsecurityexample.mapper.PermissionMapper;
import cn.unknownworlds.springsecurityexample.service.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionModel> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionModel> selectByRoleId(Integer roleId) {

        QueryWrapper<PermissionModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PermissionModel::getRoleId,roleId);

        return this.permissionMapper.selectList(queryWrapper);

    }
}
