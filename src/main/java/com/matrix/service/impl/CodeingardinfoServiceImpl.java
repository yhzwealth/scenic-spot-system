package com.matrix.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.matrix.Bo.CodeInInfoGardBo;
import com.matrix.Bo.CodeInInfoManagerBo;
import com.matrix.Bo.CodeInInfoManagerItemBo;
import com.matrix.Vo.CodeInInfoGardVo;
import com.matrix.Vo.CodeInInfoManagerVo;
import com.matrix.entity.Codeingardinfo;
import com.matrix.mapper.CodeingardinfoMapper;
import com.matrix.service.CodeingardinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Service
public class CodeingardinfoServiceImpl extends ServiceImpl<CodeingardinfoMapper, Codeingardinfo> implements CodeingardinfoService {

    @Override
    public CodeInInfoGardBo gardQuery(Integer gateId, LocalDate start, LocalDate end) {
        List<CodeInInfoGardVo> vos = this.baseMapper.gardQuery(gateId, start, end);
        return new CodeInInfoGardBo(this.baseMapper.selectCount(new LambdaQueryWrapper<Codeingardinfo>().eq(Codeingardinfo::getGateId, gateId)), vos.size(), vos);
    }

    @Override
    public CodeInInfoManagerBo managerQuery(LocalDate start, LocalDate end) {
        List<CodeInInfoManagerVo> vos = this.baseMapper.managerQuery(start, end);
        CodeInInfoManagerVo pre = null;
        List<CodeInInfoManagerItemBo> lists = new ArrayList<>();
        ArrayList<CodeInInfoManagerVo> list = new ArrayList<>();
        int totalViews = 0, views = 0;
        for (CodeInInfoManagerVo vo : vos) {
            if (!vo.getGardenName().equals(pre != null ? pre.getGardenName() : null)) {
                if (!list.isEmpty()) {
                    lists.add(new CodeInInfoManagerItemBo(views, list));
                    views = 0;
                }
                list = new ArrayList<>();
            }
            list.add(vo);
            pre = vo;
            views += vo.getViews();
            totalViews += vo.getViews();
        }
        lists.add(new CodeInInfoManagerItemBo(views, list));
        return new CodeInInfoManagerBo(totalViews, lists);
    }
}
