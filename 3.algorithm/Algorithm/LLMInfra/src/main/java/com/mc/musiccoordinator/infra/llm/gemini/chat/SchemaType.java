package com.mc.musiccoordinator.infra.llm.gemini.chat;

public class SchemaType {
    public static final SchemaType BOOLEAN = new SchemaType("BOOLEAN");
    public static final SchemaType STRING = new SchemaType("STRING");
    public static final SchemaType NUMBER = new SchemaType("NUMBER");
    public static final SchemaType ARRAY = new SchemaType("ARRAY");
    public static final SchemaType OBJECT = new SchemaType("OBJECT");

    private final String type;

    public SchemaType(String type) {
        super();
        this.type = type;
    }
}
