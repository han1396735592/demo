package cn.qqhxj.demo.layui.modules.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author han xinjian
 * @date 2018/10/24 16:58
 */
@Data
public class SysUser {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private Integer createId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}
