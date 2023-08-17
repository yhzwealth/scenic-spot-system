package com.matrix.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Codeinfo对象", description="")
public class Codeinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "二维码id")
    @TableId(value = "codeId", type = IdType.AUTO)
    private Integer codeId;

    @ApiModelProperty(value = "二维码编码")
    @TableField("biCode")
    private String biCode;

    @ApiModelProperty(value = "随机数编码")
    @TableField("valiCode")
    private String valiCode;

    @ApiModelProperty(value = "编码状态")
    @TableField("ringState")
    private Integer ringState;

    @ApiModelProperty(value = "生效时间")
    @TableField("ringActiveStart")
    private LocalDateTime ringActiveStart;

    @ApiModelProperty(value = "失效时间")
    @TableField("ringActiveEnd")
    private LocalDateTime ringActiveEnd;

    @ApiModelProperty(value = "最大游览次数")
    @TableField("ringMaxTimes")
    private Integer ringMaxTimes;

    @ApiModelProperty(value = "备注")
    @TableField("ringComments")
    private String ringComments;


}
