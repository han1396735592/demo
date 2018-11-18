package cn.qqhxj.demo.layui.modules.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;

/**
 * @author han xinjian
 * @date 2018/11/5 22:45
 */
@Getter
public class SysRole {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String remark;

    private Integer status;
}
