package com.isteyft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//响应码，200 代表成功; 401 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static Result success(){
        return new Result(200,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(200,"success",data);
    }
    // 返回复合对象
    public static Result success(Map<String, Object> dataMap) {
        return new Result(200, "success", dataMap);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(401,msg,null);
    }
}
