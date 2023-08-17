package com.matrix.mapper;

import com.matrix.Vo.CodeInInfoGardVo;
import com.matrix.Vo.CodeInInfoManagerVo;
import com.matrix.entity.Codeingardinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Repository
public interface CodeingardinfoMapper extends BaseMapper<Codeingardinfo> {
    List<CodeInInfoGardVo> gardQuery(Integer gateId, LocalDate start, LocalDate end);
    List<CodeInInfoManagerVo> managerQuery(LocalDate start, LocalDate end);
}
