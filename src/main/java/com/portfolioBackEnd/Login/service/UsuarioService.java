package com.portfolioBackEnd.Login.service;

import com.portfolioBackEnd.Login.model.Usuario;
import com.portfolioBackEnd.Login.repository.UsuarioRepository;
import com.portfolioBackEnd.Login.security.JwtTokenProvider;
import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    
    public String authenticate(String email, String password) throws AuthenticationException{
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario==null){
            throw new AuthenticationException("Email y/o Contraseña invalidos");
        }        
        if(!passwordEncoder.matches(password, passwordEncoder.encode(usuario.getPassword()))){    
            throw new AuthenticationException("Email y/o Contraseña invalidos");
        }   
        
        String token=jwtTokenProvider.createToken(usuario.getName());
        return token;
    }
}
