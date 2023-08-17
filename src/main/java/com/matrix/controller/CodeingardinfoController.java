package com.matrix.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.matrix.entity.Codeinfo;
import com.matrix.entity.Codeingardinfo;
import com.matrix.po.CodePo;
import com.matrix.service.CodeinfoService;
import com.matrix.service.CodeingardinfoService;
import com.matrix.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Api(tags = "二维码扫描进入景区模块")
@RestController
@RequestMapping("/codeingardinfo")
@CrossOrigin
public class CodeingardinfoController {

    @Autowired
    private CodeinfoService codeinfoService;

    @Autowired
    private CodeingardinfoService codeingardinfoService;

    @ApiOperation(value = "二维码扫描进入")
    @PostMapping("/codeIn")
    public Result codeInGard(CodePo codePo) {
        System.out.println(codePo);
        Codeinfo codeinfo = codeinfoService.getOne(new LambdaQueryWrapper<Codeinfo>().eq(Codeinfo::getBiCode, codePo.getBiCode())
                .eq(Codeinfo::getValiCode, codePo.getValiCode()));
        if (codeinfo == null) {
            return Result.error("二维码信息或验证码有误，该码无效");
        } else if (codeinfo.getRingState().equals(2)) {
            return Result.error("该码已被冻结，请联系管理员");
        }
        int count = codeingardinfoService.count(new LambdaQueryWrapper<Codeingardinfo>().eq(Codeingardinfo::getCodeId, codeinfo.getCodeId()));
        if (codeinfo.getRingActiveStart().isAfter(LocalDateTime.now())) {
            return Result.error("该码尚未到使用时间");
        } else if (codeinfo.getRingActiveEnd().isBefore(LocalDateTime.now())) {
            return Result.error("该码已超过使用时间");
        } else if (count >= codeinfo.getRingMaxTimes()) {
            codeinfoService.updateById(codeinfo.setRingState(2));
            return Result.error("该码已达到最大使用次数");
        }
        codeingardinfoService.save(new Codeingardinfo(null, codeinfo.getCodeId(), codePo.getGateId(), LocalDateTime.now(), codePo.getUserId(), null));
        return Result.success("入园成功");
    }

    @ApiOperation(value = "景区管理人员管理接口")
    @PostMapping("/gardQuery")
    public Result gardQuery(Integer gateId, String date) {
        LocalDate start = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = start.plusDays(1);
        return Result.success("查询成功", codeingardinfoService.gardQuery(gateId, start, end));
    }

    @ApiOperation(value = "景区管理人员管理接口")
    @PostMapping("/gardAllQuery")
    public Result gardQuery(Integer gateId) {
        return Result.success("查询成功", codeingardinfoService.gardQuery(gateId, null, null));
    }

    @ApiOperation(value = "旅游局领导查询接口")
    @PostMapping("/managerQuery")
    public Result managerQuery(String start, String end) {
        LocalDate startTime = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endTime = LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusDays(1);
        return Result.success("查询成功", codeingardinfoService.managerQuery(startTime, endTime));
    }
}
