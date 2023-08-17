package com.matrix.Bo;

import com.matrix.Vo.CodeInInfoGardVo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CodeInInfoGardBo对象", description="")
public class CodeInInfoGardBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer totalViews;

    private Integer views;

    private List<CodeInInfoGardVo> vos;
}
