package com.matrix.Vo;

import lombok.Data;

/**
 * 用于微信用户验证 暂时无效
 */
@Data
public class OAuthInfo {
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;
}
