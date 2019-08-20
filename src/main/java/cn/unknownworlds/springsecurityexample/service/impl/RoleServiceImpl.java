package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.RoleModel;
import cn.unknownworlds.springsecurityexample.mapper.RoleMapper;
import cn.unknownworlds.springsecurityexample.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleModel selectById(Integer roleId) {
        return this.roleMapper.selectById(roleId);
    }
}
