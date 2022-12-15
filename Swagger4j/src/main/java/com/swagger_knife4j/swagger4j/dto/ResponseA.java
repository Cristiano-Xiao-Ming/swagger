package com.swagger_knife4j.swagger4j.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("ResponseA")
public class ResponseA {

    @ApiModelProperty("ResponseA.name属性")
    private Integer code;
    @ApiModelProperty("ResponseA.message属性")
    private String message;
    @ApiModelProperty("ResponseA.data属性")
    private Object data;
}
