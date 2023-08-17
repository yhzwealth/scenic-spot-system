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
@ApiModel(value="CodeInInfoGardVo对象", description="")
public class CodeInInfoGardVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "recId", type = IdType.AUTO)
    private Integer recId;

    @ApiModelProperty(value = "入园时间")
    @TableField(value = "inDateTime", fill = FieldFill.INSERT)
    private String valiCode;

    @ApiModelProperty(value = "入园时间")
    @TableField(value = "inDateTime", fill = FieldFill.INSERT)
    private LocalDateTime inDateTime;


    @ApiModelProperty(value = "用户名字")
    @TableField("userName")
    private String userName;

}
