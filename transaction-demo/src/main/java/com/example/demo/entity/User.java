package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
/**
* User(User)表实体类
*
* @author han xinjian
* @since 2020-05-27 22:19:54
*/
@EqualsAndHashCode(callSuper = true)
@TableName("user")
@Data
public class User extends Model<User> {
        
    /*
    * id
    */        
    
    private Integer id;
        
    /*
    * name
    */        
    
    private String name;
        
    /*
    * username
    */        
    
    private String username;
        
    /*
    * password
    */        
    
    private String password;
        
    /*
    * cols
    */        
    
    private String cols;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    
}