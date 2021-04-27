package com.vip.zn.fitness_system.controller;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dbgenerator.mapper.SiteMapper;
import com.vip.zn.fitness_system.dto.GetSiteStatusReq;
import com.vip.zn.fitness_system.dto.SiteDto;
import com.vip.zn.fitness_system.service.SiteManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName SiteManageController
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 18:15
 */

@RestController
@RequestMapping(value = "/site")
@Api("场地管理接口")
public class SiteManageController {

    @Autowired
    SiteMapper siteMapper;

    @Autowired
    SiteManageService siteManageService;

    @RequestMapping(value = "/getSiteStatus", method = RequestMethod.POST)
    @ApiOperation("查看场地预约状态")
    public WebResult getSiteStatus(GetSiteStatusReq req) {
        return siteManageService.getSiteStatus(req);
    }

    @RequestMapping(value = "/bookSite",method = RequestMethod.POST)
    @ApiOperation(("预约场地"))
    public WebResult bookSite(SiteDto siteDto){
        return siteManageService.bookSite(siteDto);
    }
}
