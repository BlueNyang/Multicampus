package com.mc.musiccoordinator.infra.llm;

public interface BaseModel {
    BaseResponse invoke(BaseRequest req);
}
