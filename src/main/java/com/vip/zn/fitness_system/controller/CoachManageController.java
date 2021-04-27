package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import com.vip.zn.fitness_system.dto.CoachDto;
import com.vip.zn.fitness_system.service.CoachManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TrainManageController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 18:14
 */

@RestController
@RequestMapping(value = "/coach")
@Api("私教管理接口")
public class CoachManageController {

    @Autowired
    CoachManageService coachManageService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增私教信息")
    public WebResult addCoachInfo(AddCoachInfoReq req) {
        return coachManageService.addCoach(req);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改私教信息")
    public WebResult updateCoachInfo(CoachDto coachDto) {
        return coachManageService.updateCoachInfo(coachDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation("删除私教信息")
    public WebResult deleteCoachInfo(Integer id) {
        return coachManageService.deleteCoachInfo(id);
    }

    @RequestMapping(value = "/getCoachInfoByCoachId", method = RequestMethod.GET)
    @ApiOperation("按照私教id模糊查询私教信息")
    public WebResult getCoachInfoByCoachId(String coachId) {
        return coachManageService.getCoachInfoByCoachId(coachId);
    }

    @RequestMapping(value = "/getCoachInfoByName", method = RequestMethod.GET)
    @ApiOperation("按照私教姓名模糊查询私教信息")
    public WebResult getCoachInfoByName(String coachName) {
        return coachManageService.getCoachInfoByName(coachName);
    }

    @RequestMapping(value = "/getCoachInfoByPhoneNum", method = RequestMethod.GET)
    @ApiOperation("按照电话模糊查询私教信息")
    public WebResult getCoachInfoByPhoneNum(String phoneNum) {
        return coachManageService.getCoachInfoByPhoneNum(phoneNum);
    }
}
