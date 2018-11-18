package cn.qqhxj.demo.layui.modules.sys.service.impl;

import cn.qqhxj.demo.layui.modules.sys.dao.SysMenuDao;
import cn.qqhxj.demo.layui.modules.sys.domain.SysMenu;
import cn.qqhxj.demo.layui.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author han xinjian
 * @date 2018/10/25 14:34
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    /**
     * id
     *
     * @param id id
     * @return 列表
     */
    @Override
    public List<SysMenu> tree(Integer id) {
        SysMenu sysMenu = this.getById(id);
        List<SysMenu> menus;
        if (sysMenu == null) {
            menus = this.list(new QueryWrapper<SysMenu>().isNull("parent_id"));
        } else {
            menus = this.list(new QueryWrapper<SysMenu>().eq("parent_id", sysMenu.getId()));
        }
        if (!menus.isEmpty()) {

            for (SysMenu menu : menus) {
                List<SysMenu> tree = tree(menu.getId());
                menu.setChildren(tree);
            }
        }
        return menus;
    }
}
