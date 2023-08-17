package com.matrix.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.matrix.entity.Usergate;
import com.matrix.service.GardgateService;
import com.matrix.service.UsergateService;
import com.matrix.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Api(tags = "管理人员-景区模块")
@RestController
@RequestMapping("/usergate")
@CrossOrigin
public class UsergateController {

    @Autowired
    private UsergateService usergateService;

    @Autowired
    private GardgateService gardgateService;

    @ApiOperation(value = "管理人员-景区")
    @PostMapping("/getGate")
    private Result getGateList(Integer userId) {
        List<Usergate> usergates = usergateService.list(new LambdaQueryWrapper<Usergate>().eq(Usergate::getUserId, userId));
        if(usergates.isEmpty()){
            return Result.error("该用户下无管理的入口，请重新输入");
        }
        ArrayList<Integer> gateIds = new ArrayList<>();
        for (Usergate usergate : usergates) {
            gateIds.add(usergate.getGateId());
        }
        return Result.success("查询成功", gardgateService.listByIds(gateIds));
    }

}

