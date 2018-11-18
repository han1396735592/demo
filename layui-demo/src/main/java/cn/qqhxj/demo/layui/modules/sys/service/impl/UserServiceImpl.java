package cn.qqhxj.demo.layui.modules.sys.service.impl;

import cn.qqhxj.demo.layui.modules.sys.dao.SysUserDao;
import cn.qqhxj.demo.layui.modules.sys.domain.SysUser;
import cn.qqhxj.demo.layui.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author han xinjian
 * @date 2018/10/24 17:01
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
}
