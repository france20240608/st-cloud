package com.st.cloud.module.agent.controller;

import com.st.cloud.common.core.CommonResult;
import com.st.cloud.module.agent.pojo.ob.SystemResourceDO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/permission")
public class SystemResourceController {

    @PostMapping("/list")
    public CommonResult<List<SystemResourceDO>> list() {
        CommonResult<List<SystemResourceDO>> result = new CommonResult<>();
        return result;
    }

    @PostMapping("/get/{id}")
    public CommonResult<SystemResourceDO> get(@PathVariable Long id) {
        CommonResult<SystemResourceDO> result = new CommonResult<>();
        return result;
    }

    @PostMapping("/update/{id}")
    public CommonResult<Boolean> update(@RequestBody SystemResourceDO vo) {
        CommonResult<Boolean> result = new CommonResult<>();
        return result;
    }

    @PostMapping("/delete/{id}")
    public CommonResult<Boolean> delete(@PathVariable Long id) {
        CommonResult<Boolean> result = new CommonResult<>();
        return result;
    }
}
