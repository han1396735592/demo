package cn.qqhxj.demo.layui.modules.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author han xinjian
 * @date 2018/10/25 14:29
 */
@Data
public class SysMenu {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String url;

    private Integer parentId;

    private Integer type;

    private Integer status;

    private Integer createId;

    private Date createDate;

    private String icon;

    private Integer permissionId;

    @TableField(exist = false)
    private List<SysMenu> children;

}
