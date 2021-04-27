package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.dto.GetSiteStatusReq;
import com.vip.zn.fitness_system.dto.SiteDto;

public interface SiteManageService {

    /**
     * 查询场地占用情况 0可用  -1不可用
     */
    WebResult getSiteStatus(GetSiteStatusReq req);

    /**
     * 预约场地
     */
    WebResult bookSite(SiteDto siteDto);
}
