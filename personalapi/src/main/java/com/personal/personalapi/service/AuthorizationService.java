package com.personal.personalapi.service;

import com.personal.personalapi.exception.BusinessException;
import com.personal.personalapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public void checkUserAccess(User loggedUser, Long userId) {

        boolean isOwner = loggedUser.getId().equals(userId);
        boolean isPersonal = loggedUser.getRole().name().equals("PERSONAL");

        if (!isOwner && !isPersonal) {
            throw new RuntimeException("Acesso negado: você não tem permissão para acessar este recurso.");
        }
    }

    public void checkIsPersonal(User loggedUser) {
        boolean isPersonal = loggedUser.getRole().name().equals("PERSONAL");

        if (!isPersonal) {
            throw new BusinessException("Acesso negado");
        }
    }
}
