package com.matrix.service.impl;

import com.matrix.entity.WxApiJSON;
import com.matrix.utils.WxUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 一个低端小气没档次的程序狗 JavaDog
 * blog.javadog.net
 *
 * @BelongsProject: springboot-wexin
 * @BelongsPackage: net.javadog.springbootwexin.service
 * @Author: hdx
 * @CreateTime: 2020-02-14 20:43
 * @Description: 微信相关service
 */
@Service
public class WxServiceImpl {

    @Value("${wx.appId}")
    private String AppId;

    /**
     *@Author: hdx
     *@CreateTime: 20:46 2020/2/14
     *@param:  shareUrl 分享的url
     *@Description: 初始化JSSDKConfig
     */
    public WxApiJSON initJSSDKConfig(String url) throws Exception {
        //获取AccessToken
        String accessToken = WxUtils.getJSSDKAccessToken();
        //获取JssdkGetticket
        String jsapiTicket = WxUtils.getJssdkGetticket(accessToken);
        Long timestamp = System.currentTimeMillis() / 1000;
        String nonceStr = UUID.randomUUID().toString();

        String signature = WxUtils.buildJSSDKSignature(jsapiTicket,String.valueOf(timestamp),nonceStr,url);

        return new WxApiJSON(AppId, timestamp, nonceStr, signature, jsapiTicket);
    }
}
