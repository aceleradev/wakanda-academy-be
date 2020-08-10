package dev.wakandaacademy.api.user.service;

import dev.wakandaacademy.api.user.controller.dto.UserCreationFormDto;
import dev.wakandaacademy.api.user.model.User;

public interface UserService {
    User create(UserCreationFormDto dto) throws Exception;
}
