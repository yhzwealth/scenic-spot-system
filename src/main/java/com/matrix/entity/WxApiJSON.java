package com.matrix.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@EqualsAndHashCode()
@Accessors(chain = true)
@ApiModel(value="WxApiJSON对象", description="")
public class WxApiJSON {

    private String appId;

    private Long timestamp;

    private String nonceStr;

    private String signature;

    private String jsapi_ticket;
}
