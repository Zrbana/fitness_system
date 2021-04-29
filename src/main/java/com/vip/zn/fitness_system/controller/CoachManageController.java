package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.AddCoachInfoReq;
import com.vip.zn.fitness_system.dto.CoachDto;
import com.vip.zn.fitness_system.service.CoachManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public WebResult addCoachInfo(@RequestBody AddCoachInfoReq req) {
        return coachManageService.addCoach(req);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("修改私教信息")
    @ResponseBody
    public WebResult updateCoachInfo(@RequestBody CoachDto coachDto) {
        return coachManageService.updateCoachInfo(coachDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation("删除私教信息")
    @ResponseBody
    public WebResult deleteCoachInfo(@RequestBody Integer id) {
        return coachManageService.deleteCoachInfo(id);
    }

    @RequestMapping(value = "/getCoachInfoByCoachId", method = RequestMethod.GET)
    @ApiOperation("按照私教id查询私教信息")
    @ResponseBody
    public WebResult getCoachInfoByCoachId(@RequestBody String coachId) {
        return coachManageService.getCoachInfoByCoachId(coachId);
    }

    @RequestMapping(value = "/getCoachInfoByName", method = RequestMethod.GET)
    @ApiOperation("按照私教姓名查询私教信息")
    @ResponseBody
    public WebResult getCoachInfoByName(@RequestBody String coachName) {
        return coachManageService.getCoachInfoByName(coachName);
    }

    @RequestMapping(value = "/getCoachInfoByPhoneNum", method = RequestMethod.GET)
    @ApiOperation("按照电话查询私教信息")
    @ResponseBody
    public WebResult getCoachInfoByPhoneNum(@RequestBody String phoneNum) {
        return coachManageService.getCoachInfoByPhoneNum(phoneNum);
    }
}
