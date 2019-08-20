package cn.unknownworlds.springsecurityexample.service;

import cn.unknownworlds.springsecurityexample.entity.UserRoleModel;
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
public interface UserRoleService extends IService<UserRoleModel> {

    List<UserRoleModel> listByUserId(Integer id);
}
