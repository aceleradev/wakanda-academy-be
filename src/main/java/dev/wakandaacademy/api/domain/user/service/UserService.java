package dev.wakandaacademy.api.domain.user.service;

import dev.wakandaacademy.api.domain.user.controller.dto.UserCreationFormDto;
import dev.wakandaacademy.api.domain.user.model.User;

public interface UserService {
    User create(UserCreationFormDto dto) throws Exception;
}
