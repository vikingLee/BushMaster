package com.bushmaster.architecture.service;

import com.bushmaster.architecture.domain.entity.ScenarioResultInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ScenarioResultService {
    ScenarioResultInfo getScenarioResultInfo(Integer id);

    Map<String, Object> getScenarioResultInfoByScenarioId(Integer offset, Integer limit, Integer scenarioId);

    Map<String, Object> getScenarioResultInfoList(Integer offset, Integer limit);

    Map<String, Object> addScenarioResultInfo(ScenarioResultInfo scenarioResultInfo);

    Map<String, Object> delScenarioResultInfo(Integer id);
}
