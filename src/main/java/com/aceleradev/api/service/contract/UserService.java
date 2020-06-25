package com.aceleradev.api.service.contract;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;

public interface UserService {

    User create(UserCreationFormDto dto) throws Exception;

}
