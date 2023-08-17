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
@ApiModel(value="Gardgate对象", description="")
public class Gardgate implements Serializable {

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


}
