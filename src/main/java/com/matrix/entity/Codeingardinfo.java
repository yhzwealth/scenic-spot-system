package com.matrix.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Codeingardinfo对象", description="")
public class Codeingardinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "recId", type = IdType.AUTO)
    private Integer recId;

    @ApiModelProperty(value = "二维码编号")
    @TableField("codeId")
    private Integer codeId;

    @ApiModelProperty(value = "入口编号")
    @TableField("gateId")
    private Integer gateId;

    @ApiModelProperty(value = "入园时间")
    @TableField(value = "inDateTime", fill = FieldFill.INSERT)
    private LocalDateTime inDateTime;

    @ApiModelProperty(value = "扫描的用户的编号")
    @TableField("scanUserId")
    private Integer scanUserId;

    @ApiModelProperty(value = "备注")
    @TableField("inGardComments")
    private String inGardComments;


}
