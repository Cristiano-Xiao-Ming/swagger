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
@ApiModel("SkillStudyPlanDTO实体类")
public class SkillStudyPlanDTO {

    @ApiModelProperty("SkillStudyPlanDTO.name属性")
    private String name;
    @ApiModelProperty("SkillStudyPlanDTO.age属性")
    private Integer age;
}
