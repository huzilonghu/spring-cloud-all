package com.miao.car.base.common.base;



import com.miao.car.base.entity.ErrorEntity;
import com.miao.car.base.erro.FieldValidator;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

import lombok.Data;


@Data
public class BaseDto implements Serializable {

    public Long id = 0l;

    private String channel;

    private String version;

    private int pageNow = 1;

    private int pageSize = ConstantsMsg.PAGE_SIZE;
    /**
     * 渠道统一的编码
     */
    private Long companyAppId = 0l;
    /**
     * 基金经理 渠道管理员的userId
     */
    private Long sysUserId = 0l;
    /**
     * 需要特殊处理的基金经理的角色, 就是渠道的管理员,数据过滤时就放开该字段
     * 标记数据权限
     * 0  就是普通的基金经理   1  管理员
     */
    private int sysUserType = 0;


    /**
     * Ui Object Validation .
     *
     * @see this.validate()
     */



    public ErrorEntity validate() {
        return new FieldValidator()
                .validatedField(this.channel, ConstantsMsg.PARAMETER_CHANELID_EMPTY)
                .validatedField(this.version, ConstantsMsg.API_VERSION_EMPTY)
                .validate();
    }

    public String like(String target) {
        if (StringUtils.isBlank(target)) {
            return null;
        } else {
            return "%".concat(target).concat("%");
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public <T extends BaseDto> T toBaseDto(T t) {
        t.setChannel(getChannel());
        t.setVersion(getVersion());

        t.setPageNow(getPageNow());
        t.setPageSize(getPageSize());

        t.setSysUserId(getSysUserId());
        t.setSysUserType(getSysUserType());

        t.setId(getId());
        t.setCompanyAppId(getCompanyAppId());
        return t;
    }

}
