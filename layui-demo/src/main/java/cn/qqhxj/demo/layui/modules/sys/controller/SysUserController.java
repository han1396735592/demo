package cn.qqhxj.demo.layui.modules.sys.controller;

import cn.qqhxj.demo.layui.common.R;
import cn.qqhxj.demo.layui.modules.sys.domain.SysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author han xinjian
 * @date 2018/11/6 13:01
 */
@RequestMapping("modules/sys/sysUser")
@Controller
@Slf4j
public class SysUserController extends BaseSysController {

    @ResponseBody
    @RequestMapping("add")
    public R<SysUser> add(SysUser sysUser) {
        if (this.sysUserService.save(sysUser)) {
            log.info("添加 {} 成功", sysUser);
            return R.ok(sysUser);
        } else {
            log.error("添加 {} 失败", sysUser);
            return R.err("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping("del")
    public R<String> del(Integer id) {
        if (this.sysUserService.removeById(id)) {
            log.info("删除 {} 成功", id);
            return R.ok(null);
        } else {
            log.error("删除  失败");
            return R.err("添加失败");
        }
    }

    @ResponseBody
    @PostMapping("update")
    public R<SysUser> update(SysUser sysUser) {
        if (this.sysUserService.updateById(sysUser)) {
            log.info("更新 {} 成功", sysUser);
            return R.ok(sysUser);
        } else {
            log.error("更新 失败");
            return R.err("更新失败");
        }
    }


    @ResponseBody
    @GetMapping("getAll")
    public R<List<SysUser>> getAll() {
        return R.ok(this.sysUserService.list(null));
    }


    @ResponseBody
    @GetMapping("page")
    public IPage page(Page page) {
        return this.sysUserService.page(page, null);
    }


}
