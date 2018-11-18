package cn.qqhxj.demo.layui.modules.sys.controller;

import cn.qqhxj.demo.layui.common.BaseController;
import cn.qqhxj.demo.layui.modules.sys.service.SysMenuService;
import cn.qqhxj.demo.layui.modules.sys.service.SysRoleService;
import cn.qqhxj.demo.layui.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author han xinjian
 * @date 2018/11/5 22:56
 */
public abstract class BaseSysController extends BaseController {

    @Autowired
    protected SysRoleService sysRoleService;

    @Autowired
    protected SysMenuService sysMenuService;

    @Autowired
    protected SysUserService sysUserService;
}
