package com.matrix.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.matrix.entity.Userinfo;
import com.matrix.service.UserinfoService;
import com.matrix.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-07-04
 */
@Api(tags = "用户信息模块")
@RestController
@RequestMapping("/userinfo")
@CrossOrigin
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody Userinfo userinfo) {
        if (userinfoService.count(new LambdaQueryWrapper<Userinfo>()
                .eq(Userinfo::getUserName, userinfo.getUserName())
                .eq(Userinfo::getPassword, userinfo.getPassword())
                .eq(Userinfo::getRoleName, "gard")) > 0) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("用户名", userinfo.getUserName());
            map1.put("角色", "gard");
            return Result.success("登陆成功,用户为景区管理人员", map1);
        } else if (userinfoService.count(new LambdaQueryWrapper<Userinfo>()
                .eq(Userinfo::getUserName, userinfo.getUserName())
                .eq(Userinfo::getPassword, userinfo.getPassword())
                .eq(Userinfo::getRoleName, "manager")) > 0) {
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("用户名", userinfo.getUserName());
            map2.put("角色", "manager");
            return Result.success("登陆成功,用户为旅游局管理人员", map2);
        }
        return Result.error("用户名或密码错误！");
    }

    @ApiOperation(value = "获取用户信息")
    @PostMapping("/getInfo")
    public Result getInfo(Integer userId) {
        Userinfo info = userinfoService.getById(userId);
        if(info == null){
            return Result.error("userId有误");
        }
        info.setPassword(null);
        return Result.success("获取成功", info);
    }

    @ApiOperation(value = "设置头像")
    @PostMapping("/setImg")
    public Result setHeadImg(Integer userId, Integer imgId) {
        Userinfo userinfo = new Userinfo().setUserId(userId).setHeadImgId(imgId);
        userinfoService.updateById(userinfo);
        return Result.success("更改成功");
    }


    @ApiOperation(value = "设置用户名")
    @PostMapping("/setUserName")
    public Result setUserName(Integer userId, String userName) {
        if (userinfoService.count(new LambdaQueryWrapper<Userinfo>().eq(Userinfo::getUserName, userName)) == 0) {
            Userinfo userinfo = new Userinfo().setUserId(userId).setUserName(userName);
            userinfoService.updateById(userinfo);
            return Result.success("更改成功");
        }
        return Result.error("该用户名已存在");
    }

    @ApiOperation(value = "重设密码")
    @PostMapping("/setPwd")
    public Result setPwd(Integer userId, String oldPwd, String pwd) {
        if (!userinfoService.getById(userId).getPassword().equals(oldPwd)) {
            return Result.error("旧密码输入错误");
        }
        Userinfo userinfo = new Userinfo().setUserId(userId).setPassword(pwd);
        userinfoService.updateById(userinfo);
        return Result.success("更改成功");
    }
}
