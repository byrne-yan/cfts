package com.byrne.cfts.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Document
public class Commodity {
    @Id
    private String code;//交易代码
    @NotBlank
    @Indexed(unique = true)
    private String name;//交易品种
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
//    private String tradeUnit;//交易单位
//    private String pricingUnit;//报价单位
//    private Float tickSize;//最小变动价位
//    private Integer limit;//最大波动限制
    @NotBlank
    @NotNull
    private Integer minMargin;//最低交易保证金

    private String deliveryGrade;//交割等级
    private String deliveryPlace;//交割地点
    private String deliveryMode;//交割方式
    @NotBlank
    @Indexed(unique = false)
    private String exchangeCode;//上市交易所

    public String getExchangeCode() {
        return exchangeCode;
    }
    public void setExchangeCode(String code) {
        this.exchangeCode = code;
    }
}

