package cn.unknownworlds.springsecurityexample.security;

import cn.unknownworlds.springsecurityexample.entity.PermissionModel;
import cn.unknownworlds.springsecurityexample.entity.RoleModel;
import cn.unknownworlds.springsecurityexample.service.PermissionService;
import cn.unknownworlds.springsecurityexample.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        // 获取到用户的权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // 遍历用户权限
        for (GrantedAuthority authority : authorities) {

            // 获取角色名
            String roleName = authority.getAuthority();

            // 获取角色id
            RoleModel roleModel = this.roleService.selectByName(roleName);

            Integer roleId = roleModel.getId();

            // 获取到角色对应的权限
            List<PermissionModel> permissionModelList = this.permissionService.selectByRoleId(roleId);

            // 遍历权限集
            for (PermissionModel permissionModel : permissionModelList) {


                String permissionStr = permissionModel.getPermission();
                List permissionList = Arrays.asList(permissionStr.split(","));

                if(targetDomainObject.equals(permissionModel.getUrl()) && permissionList.contains(permission)){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
