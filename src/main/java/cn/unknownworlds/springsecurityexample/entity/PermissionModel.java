package cn.unknownworlds.springsecurityexample.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author scottluo
 * @since 2019-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class PermissionModel extends Model<PermissionModel> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("url")
    private String url;

    @TableField("role_id")
    private Integer roleId;

    @TableField("permission")
    private String permission;


    public static final String ID = "id";

    public static final String URL = "url";

    public static final String ROLE_ID = "role_id";

    public static final String PERMISSION = "permission";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
