package com.mc.studyhelper.domain;

import java.util.Map;

public record StudyPlan(
        String difficulty,
        String period,
        String firststepLanguage,
        String recommandedProject
) {
    public static StudyPlan fromMap(Map<String, Object> map) {
        return new StudyPlan((String) map.get("difficulty"),
                (String) map.get("period"),
                (String) map.get("firststepLanguage"),
                (String) map.get("recommandedProject")
        );
    }
}
