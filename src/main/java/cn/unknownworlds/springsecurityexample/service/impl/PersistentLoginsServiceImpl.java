package cn.unknownworlds.springsecurityexample.service.impl;

import cn.unknownworlds.springsecurityexample.entity.PersistentLoginsModel;
import cn.unknownworlds.springsecurityexample.mapper.PersistentLoginsMapper;
import cn.unknownworlds.springsecurityexample.service.PersistentLoginsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class PersistentLoginsServiceImpl extends ServiceImpl<PersistentLoginsMapper, PersistentLoginsModel> implements PersistentLoginsService {

}
