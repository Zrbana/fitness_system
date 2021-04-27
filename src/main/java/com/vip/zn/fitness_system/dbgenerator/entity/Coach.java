package com.vip.zn.fitness_system.dbgenerator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author na.zhao
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 私教id
     */
    private String coachId;

    /**
     * 私教姓名
     */
    private String coachName;

    /**
     * 私教电话
     */
    private String phoneNumber;

    /**
     * 在职情况 0离职 1正常
     */
    private Integer status;


}
