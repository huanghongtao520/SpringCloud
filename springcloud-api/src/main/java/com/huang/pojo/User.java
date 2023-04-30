package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class User implements Serializable {
    private int id;
    private String name;
    //这个数据存在哪个数据库的字段，一个服务对应一个数据库，同一个信息可能存在不同数据库
    private String db_source;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
