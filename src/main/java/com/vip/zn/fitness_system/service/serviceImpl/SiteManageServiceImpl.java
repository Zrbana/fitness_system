package com.vip.zn.fitness_system.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vip.zn.fitness_system.common.WebResult;
import com.vip.zn.fitness_system.db.entity.Place;
import com.vip.zn.fitness_system.db.mapper.PlaceMapper;
import com.vip.zn.fitness_system.dto.GetSiteStatusReq;
import com.vip.zn.fitness_system.dto.SiteDto;
import com.vip.zn.fitness_system.exception.BizException;
import com.vip.zn.fitness_system.service.SiteManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SiteManageServiceImpl
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:12
 */

@Service
public class SiteManageServiceImpl implements SiteManageService {

    @Autowired
    PlaceMapper placeMapper;

    @Override
    public WebResult getSiteStatus(GetSiteStatusReq req) {
        if (req == null || StringUtils.isBlank(req.getPlaceName())) {
            return WebResult.buildFail("查询条件为空");
        }
        Integer siteStatus;
        try {
            siteStatus = placeMapper.selectOne(new QueryWrapper<Place>().eq("placeName", req.getPlaceName())).getStatus();
        } catch (BizException e) {
            return WebResult.buildFail("查询失败");
        }
        return WebResult.buildSucc("查询场地状态成功", "200", siteStatus);
    }

    @Override
    public WebResult bookSite(SiteDto siteDto) {

        return null;
    }
}
