package cn.qqhxj.demo.layui.modules.sys.service;

import cn.qqhxj.demo.layui.modules.sys.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author han xinjian
 * @date 2018/10/25 14:34
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * id
     *
     * @param id id
     * @return list
     */
    List<SysMenu> tree(@Param("id") Integer id);
}
