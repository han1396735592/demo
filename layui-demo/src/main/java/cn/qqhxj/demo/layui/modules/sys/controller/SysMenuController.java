package cn.qqhxj.demo.layui.modules.sys.controller;

import cn.qqhxj.demo.layui.common.R;
import cn.qqhxj.demo.layui.modules.sys.domain.SysMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author han xinjian
 * @date 2018/10/25 14:36
 */
@Controller
@RequestMapping("modules/sys/sysMenu")
public class SysMenuController extends BaseSysController {

    @ResponseBody
    @GetMapping("tree")
    public R<List<SysMenu>> tree(Integer id) {
        return R.ok(this.sysMenuService.tree(id));
    }

}
