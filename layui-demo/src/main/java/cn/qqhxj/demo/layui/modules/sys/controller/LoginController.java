package cn.qqhxj.demo.layui.modules.sys.controller;

import cn.qqhxj.demo.layui.modules.sys.domain.SysMenu;
import cn.qqhxj.demo.layui.modules.sys.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author han xinjian
 * @date 2018/10/24 17:19
 */
@Controller
@Slf4j
public class LoginController extends BaseSysController {

    @GetMapping("login")
    public String login(HttpServletRequest request, String username) {
        SysUser user = this.sysUserService.getById(1);

        log.info("{} 登陆成功", user.getUsername());
        request.setAttribute("user", user);

        return "index";
    }

    @GetMapping("index")
    public String index(HttpServletRequest request, String username) {
        SysUser user = sysUserService.getById(1);
        log.info("{} 登陆成功",user.getUsername());
        request.setAttribute("user",user);

        List<SysMenu> sysMenus = this.sysMenuService.tree(0);
        request.setAttribute("menus", sysMenus);
        return "index";
    }


}
