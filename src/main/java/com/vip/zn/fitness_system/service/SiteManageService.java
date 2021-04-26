package com.vip.zn.fitness_system.service;

import com.vip.zn.fitness_system.dto.SiteDto;

public interface SiteManageService {
    /**
     * 查询场地占用情况 1可用  -1不可用
     * @return
     */
    int getSiteStatus();

    /**
     * 预约场地
     * @param siteDto
     */
    void bookSite(SiteDto siteDto);
}
