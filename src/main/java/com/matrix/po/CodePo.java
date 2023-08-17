package com.matrix.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CodePo对象", description="")
public class CodePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号")
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "入口编号")
    @TableId(value = "gateId", type = IdType.AUTO)
    private Integer gateId;

    @ApiModelProperty(value = "二维码编码")
    @TableField("biCode")
    private String biCode;

    @ApiModelProperty(value = "随机数编码")
    @TableField("valiCode")
    private String valiCode;

    @Override
    public String toString() {
        return "CodePo{" +
                "userId=" + userId +
                ", gateId=" + gateId +
                ", biCode='" + biCode + '\'' +
                ", valiCode='" + valiCode + '\'' +
                '}';
    }
}
