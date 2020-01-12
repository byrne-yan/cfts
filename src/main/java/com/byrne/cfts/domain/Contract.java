package com.byrne.cfts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Document
public class Contract {
    @Id
    private String code;
    @NotNull
    @Indexed(unique = false)
    private String productCode;//交易品种

    @NotNull
    private Integer contractMonth;//合约交割月份
    //List<Duration> tradeDuration;//交易时间
    @NotNull
    private Date lastDay;//最后交易日
    @NotNull
    private Date deliveryDay;//交割日期

    public String getProductCode() {
        return productCode;
    }
}
