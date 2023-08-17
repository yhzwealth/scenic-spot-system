package com.matrix.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Usergate对象", description="")
public class Usergate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "recId", type = IdType.AUTO)
    private Integer recId;

    @ApiModelProperty(value = "用户编号")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "入口编号")
    @TableField("gateId")
    private Integer gateId;

    @ApiModelProperty(value = "备注")
    @TableField("ugComments")
    private String ugComments;


}
