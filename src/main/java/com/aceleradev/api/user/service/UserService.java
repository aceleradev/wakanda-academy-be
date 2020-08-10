package com.aceleradev.api.user.service;

import com.aceleradev.api.user.controller.dto.UserCreationFormDto;
import com.aceleradev.api.user.model.User;

public interface UserService {
    User create(UserCreationFormDto dto) throws Exception;
}
