package cn.unknownworlds.springsecurityexample.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("persistent_logins")
public class PersistentLoginsModel extends Model<PersistentLoginsModel> {

    private static final long serialVersionUID=1L;

    @TableField("username")
    private String username;

    @TableId(value = "series", type = IdType.AUTO)
    private String series;

    @TableField("token")
    private String token;

    @TableField("last_used")
    private LocalDateTime lastUsed;


    public static final String USERNAME = "username";

    public static final String SERIES = "series";

    public static final String TOKEN = "token";

    public static final String LAST_USED = "last_used";

    @Override
    protected Serializable pkVal() {
        return this.series;
    }

}
