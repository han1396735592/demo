package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
* Message(Message)表实体类
*
* @author han xinjian
* @since 2020-05-27 22:19:52
*/
@EqualsAndHashCode(callSuper = true)
@TableName("message")
@Data
public class Message extends Model<Message> {

    /*
    * id
    */

    private Integer id;

    /*
    * sendUser
    */

    private String sendUser;

    /*
    * topic
    */

    private String topic;

    /*
    * sendDate
    */

    private Date sendDate;

    /*
    * str1
    */

    private String str1;

    /*
    * str2
    */

    private String str2;

    /*
    * addressUser
    */

    private String addressUser;

    /*
    * str3
    */

    private String str3;

    /*
    * str4
    */

    private String str4;

    /*
    * sendText
    */

    private String sendText;

    /*
    * resText
    */

    private String resText;

    /*
    * fileUrl
    */

    private String fileUrl;

    /*
    * str5
    */

    private String str5;

    /*
    * str6
    */

    private String str6;

    /*
    * str7
    */

    private String str7;


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
