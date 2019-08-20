package cn.unknownworlds.springsecurityexample.service;

import cn.unknownworlds.springsecurityexample.entity.PermissionModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
public interface PermissionService extends IService<PermissionModel> {

    List<PermissionModel> selectByRoleId(Integer roleId);
}
