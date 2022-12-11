package br.com.uniamerica.pregao.pregaoapi.helper;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public final class UserValidation {

    private UserValidation (){

    }

    public static boolean validateId(Long id, Authentication authentication){
        Long idAuth = Long.valueOf((String) authentication.getPrincipal());
        if(idAuth != id)
            return false;

        return true;
    }


}
