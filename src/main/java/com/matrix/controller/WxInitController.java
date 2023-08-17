package com.matrix.controller;

import com.alibaba.fastjson.JSON;
import com.matrix.service.impl.WxServiceImpl;
import com.matrix.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 一个低端小气没档次的程序狗 JavaDog
 * blog.javadog.net
 *
 * @BelongsProject: springboot-wexin
 * @BelongsPackage: net.javadog.springbootwexin.controller
 * @Author: hdx
 * @CreateTime: 2020-02-14 14:52
 * @Description: 微信初始化接入Controller控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/wx")
public class WxInitController {

    @Autowired
    private WxServiceImpl wxServiceImpl;

    /**
     *@Author: hdx
     *@CreateTime: 20:39 2020/2/14
     *@param:  shareUrl 分享url地址
     *@Description: 初始化微信JSSDK Config信息
    1.先通过appId和appSecret参数请求指定微信地址 获取AccessToken
    2.在通过第一步中的AccessToken作为参数请求微信地址 获取jsapi_ticket临时票据(此处不考虑调用频率，使用者根据情况放入缓存或定时任务)
    3.通过第二步的JssdkGetticket和timestamp,nonceStr,url作为参数请求微信地址，获取签名signature
    4.将第三步获得的signature和jsapi_ticket,nonceStr,timestamp,url返回给前端，作为Config初始化验证的信息
     */
    @PostMapping("/JSSDK")
    public Result initWXJSConfig (@RequestBody String url) {
        url = JSON.parseObject(url).getString("url");
        System.out.println(url);
        //url = "https://wdlyb.xyz/#/";
        try {
            return Result.success(wxServiceImpl.initJSSDKConfig(url));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("校验错误");
    }
}