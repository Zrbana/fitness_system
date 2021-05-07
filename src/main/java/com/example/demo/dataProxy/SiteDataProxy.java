package com.example.demo.dataProxy;

import com.example.demo.entity.Site;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * @ClassName SiteDataProxy
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/5/7 16:27
 */

@Service
public class SiteDataProxy implements DataProxy<Site> {
    /**
     * 新增场地信息之前，校验该时间段该场地是否已经被预约过
     * @param site
     */
    @Override
    public void beforeAdd(Site site) {
    }

    @Override
    public void afterAdd(Site site) {

    }
}
