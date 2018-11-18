package cn.qqhxj.demo.layui.modules.sys.controller;

import cn.qqhxj.demo.layui.common.R;
import cn.qqhxj.demo.layui.modules.sys.domain.SysRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author han xinjian
 * @date 2018/11/5 22:52
 */
@RequestMapping("modules/sys/sysRole")
@Controller
public class SysRoleController extends BaseSysController {

    @ResponseBody
    @GetMapping("getAll")
    public R<List<SysRole>> getAll() {
        return R.ok(this.sysRoleService.list(null));
    }

}
