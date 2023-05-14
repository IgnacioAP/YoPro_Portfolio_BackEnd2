
package com.portfolioBackEnd.Login.controller;

import com.portfolioBackEnd.Login.model.UsuarioDTO;
import com.portfolioBackEnd.Login.security.JwtAuthenticationResponse;
import com.portfolioBackEnd.Login.service.UsuarioService;
import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginApi")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) throws AuthenticationException{
        String token=usuarioService.authenticate(usuarioDTO.getEmail(), usuarioDTO.getPassword());
                return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
    
}
