package com.bushmaster.architecture.service.impl;

import com.bushmaster.architecture.domain.entity.ScenarioResultInfo;
import com.bushmaster.architecture.mapper.ScenarioResultInfoMapper;
import com.bushmaster.architecture.service.ScenarioResultService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ScenarioResultServiceImpl implements ScenarioResultService{
    @Autowired
    private ScenarioResultInfoMapper resultMapper;

    @Override
    public ScenarioResultInfo getScenarioResultInfo(Integer id) {
        ScenarioResultInfo scenarioResultInfo = resultMapper.getScenarioResultInfo(id);
        if (Objects.nonNull(scenarioResultInfo))
            return scenarioResultInfo;
        else
            return null;
    }

    @Override
    public Map<String, Object> getScenarioResultInfoByScenarioId(Integer offset, Integer limit, Integer scenarioId) {
        Map<String, Object> result = new HashMap<>();
        Page<Object> page = PageHelper.offsetPage(offset, limit);
        List<ScenarioResultInfo> scenarioResultInfoList = resultMapper.getScenarioResultInfoListByScenarioId(scenarioId);
        result.put("total", page.getTotal());
        result.put("rows", scenarioResultInfoList);
        return result;
    }

    @Override
    public Map<String, Object> getScenarioResultInfoList(Integer offset, Integer limit) {
        Map<String, Object> result = new HashMap<>();
        Page<Object> page = PageHelper.offsetPage(offset, limit);
        List<ScenarioResultInfo> scenarioResultInfoList = resultMapper.getScenarioResultInfoList();
        result.put("total", page.getTotal());
        result.put("rows", scenarioResultInfoList);
        return result;
    }

    @Override
    public Map<String, Object> addScenarioResultInfo(ScenarioResultInfo scenarioResultInfo) {
        Map<String, Object> result = new HashMap<>();
        int insertFlag = resultMapper.insertScenarioResultInfo(scenarioResultInfo);
        if (insertFlag > 0) {
            result.put("status", "Success");
            result.put("message", "结果存储建立成功");
            result.put("resultId", scenarioResultInfo.getId());
        } else {
            result.put("status", "Fail");
            result.put("message", "结果存储建立失败");
        }
        return result;
    }

    @Override
    public Map<String, Object> delScenarioResultInfo(Integer id) {
        Map<String, Object> result = new HashMap<>();
        int deleteFlag = resultMapper.deleteScenarioResultInfo(id);
        if (deleteFlag > 0) {
            result.put("status", "Success");
            result.put("message", "结果存储删除成功");
        } else {
            result.put("status", "Fail");
            result.put("message", "结果存储删除失败");
        }
        return result;
    }
}
