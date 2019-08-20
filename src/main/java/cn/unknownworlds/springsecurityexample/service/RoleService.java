package cn.unknownworlds.springsecurityexample.service;

import cn.unknownworlds.springsecurityexample.entity.RoleModel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
public interface RoleService extends IService<RoleModel> {

    RoleModel selectById(Integer roleId);
}
