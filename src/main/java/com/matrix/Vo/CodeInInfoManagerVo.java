package com.matrix.Vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CodeInInfoManagerVo对象", description="")
public class CodeInInfoManagerVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入口编号")
    @TableId(value = "gateId", type = IdType.AUTO)
    private Integer gateId;

    @ApiModelProperty(value = "景区名称")
    @TableField("gardenName")
    private String gardenName;

    @ApiModelProperty(value = "入口名称")
    @TableField("gateName")
    private String gateName;

    @ApiModelProperty(value = "景区地址")
    @TableField("gateAddress")
    private String gateAddress;

    @ApiModelProperty(value = "备注")
    @TableField("gardComments")
    private String gardComments;

    @ApiModelProperty(value = "访问次数")
    @TableField("views")
    private Integer views;
}
