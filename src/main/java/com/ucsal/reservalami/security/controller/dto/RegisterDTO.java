package com.ucsal.reservalami.security.controller.dto;

import com.ucsal.reservalami.security.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}