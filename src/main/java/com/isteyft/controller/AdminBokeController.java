package com.isteyft.controller;

import com.github.pagehelper.PageInfo;
import com.isteyft.pojo.Boke;
import com.isteyft.pojo.Pl;
import com.isteyft.pojo.Result;
import com.isteyft.service.BokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v2/boke")
public class AdminBokeController {

    @Autowired
    private BokeService bokeService;
    //删除博客
    @DeleteMapping("/sc")
    public void delbk(String bokeId){
        bokeService.delbk(bokeId);
    }
    //上传博客
    @PostMapping("/upload")
    public Result handleUpload
            (@RequestParam("title") String title,@RequestParam("imgurl") String imgurl, @RequestParam("txt") String txt, @RequestParam("username") String username,@RequestParam("top") Boolean top) {
        String bokeid = UUID.randomUUID().toString();
        String istop = new String();
        if (top) {
            istop = "yes";
        }else {
            istop = "no";
        }
        return Result.success(bokeService.uploadbk(bokeid,title,txt,username,istop,imgurl));
    }
    //更新博客
    @PutMapping("/update")
    public Result handleUpdate
            (@RequestParam("bokeId") String bokeid, @RequestParam("title") String title,@RequestParam("imgurl") String imgurl, @RequestParam("txt") String txt, @RequestParam("username") String username, @RequestParam("top") Boolean top){
        String istop = new String();
        if (top) {
            istop = "yes";
        }else {
            istop = "no";
        }
        return Result.success(bokeService.updatebk(bokeid,title,txt,username,istop,imgurl));
    }
    //根据评论id获取评论，用于修改
    @GetMapping("/plid")
    public Result getplid(String plid){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("pinlun", bokeService.getplid(plid));
        return Result.success(dataMap);
    }
    //管理页面用于查找评论
    @GetMapping("/pls")
    public Result getpls( @RequestParam int pageNum,
                          @RequestParam int pageSize, @RequestParam(defaultValue = "") String ss){

        log.info("pageNum: {}, pageSize: {},ss:{}", pageNum, pageSize,ss);
        Integer plss = bokeService.getplss(ss);
        PageInfo<Pl> pinlun = bokeService.getpls(pageNum, pageSize,ss);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("pinlunlist", pinlun);
        dataMap.put("count", plss);
        return Result.success(dataMap);
    }
    //更新评论
    @PutMapping("/updatepl")
    public Result updatepl
    (@RequestParam("plid") String plid,
     @RequestParam("username") String username,
     @RequestParam("txt") String txt){
        return Result.success(bokeService.updatepl(plid,txt,username));
    }
    //删除评论
    @DeleteMapping("/scpl")
    public void delpl(String plid){
        bokeService.delpl(plid);
    }
}
