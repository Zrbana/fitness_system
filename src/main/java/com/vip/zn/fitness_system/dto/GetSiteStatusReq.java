package com.vip.zn.fitness_system.dto;

import lombok.Data;

/**
 * @ClassName GetSiteStatusReq
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/26 18:19
 */

@Data
public class GetSiteStatusReq {
    private String siteName;
    private Integer status;
}
