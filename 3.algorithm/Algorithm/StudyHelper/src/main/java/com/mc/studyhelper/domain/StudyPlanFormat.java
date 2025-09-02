package com.mc.studyhelper.domain;

import com.mc.musiccoordinator.infra.llm.Format;
import com.mc.musiccoordinator.infra.llm.gemini.chat.SchemaType;

public record StudyPlanFormat(
        SchemaType difficulty,
        SchemaType period,
        SchemaType firststepLanguage,
        SchemaType recommandedProject
) implements Format {
    public static final StudyPlanFormat INSTANCE = new StudyPlanFormat(
            SchemaType.STRING,
            SchemaType.STRING,
            SchemaType.STRING,
            SchemaType.STRING
    );
}
