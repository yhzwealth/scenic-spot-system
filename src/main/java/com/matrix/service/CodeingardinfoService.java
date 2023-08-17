package com.matrix.service;

import com.matrix.Bo.CodeInInfoGardBo;
import com.matrix.Bo.CodeInInfoManagerBo;
import com.matrix.entity.Codeingardinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
public interface CodeingardinfoService extends IService<Codeingardinfo> {
    CodeInInfoGardBo gardQuery(Integer gateId, LocalDate start, LocalDate end);
    CodeInInfoManagerBo managerQuery(LocalDate start, LocalDate end);
}
