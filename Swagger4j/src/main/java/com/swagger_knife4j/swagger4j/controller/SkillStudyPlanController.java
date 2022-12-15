package com.swagger_knife4j.swagger4j.controller;

import com.swagger_knife4j.swagger4j.common.Result;
import com.swagger_knife4j.swagger4j.dto.ResponseA;
import com.swagger_knife4j.swagger4j.dto.ResponseB;
import com.swagger_knife4j.swagger4j.dto.SkillStudyPlanDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "技术学习规划表-控制器")//@Api：用在类上，说明该类的作用
@RestController
@RequestMapping("/skillStudyPlan")
public class SkillStudyPlanController {



    @ApiOperation("插入技术学习规划")//@ApiOperation：注解来给API增加方法说明
    @PostMapping("insertPlan")
    @ApiResponses({
		@ApiResponse(code = 200, message = "请求成功",response = Result.class),
		@ApiResponse(code = 400, message = "404错误",response = Result.class),
		@ApiResponse(code = 404, message = "路径不存在",response = Result.class)
	})
    public Result<ResponseB> insertPlan(@ApiParam @RequestBody(required = false) SkillStudyPlanDTO skillStudyPlanDTO) {
        ResponseB build = ResponseB.builder().message("ss").code(200).data("data").build();
        System.out.println(skillStudyPlanDTO);
        return new Result<>(200,"ok",build);
    }

    @ApiOperation("查询所有技术学习规划")
    @GetMapping("selectAll")
    public String selectAll(@RequestParam String name,@RequestParam(required = false) Integer age) {
        System.out.print(name);
        System.out.print(age);
        return "success";
    }

    @PostMapping("pageHelp")
    @ApiOperation(value = "分页获取标签列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo",value="请求页数",required = false,dataType="Integer",paramType="query"
            ),
            @ApiImplicitParam(name="pageSize",value="请求页大小",required = false,dataType="Integer",paramType="query"),
    })
    //header：请求头
    //query：?param=value的形式
    //path：路径，Restful风格接口
    //body：请求体
    //form：以form表单的形式提交
   @ApiResponses({
		@ApiResponse(code = 200, message = "请求成功",response = Result.class),
		@ApiResponse(code = 400, message = "请求参数没填好",response = Result.class),
		@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对",response = Result.class)
	})
    public Result<ResponseA> pageHelp(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        ResponseA build = ResponseA.builder().message("ss").code(200).data("data").build();
        return new Result<>(200,"ok",build);
    }
}
