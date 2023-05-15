package com.portfolioBackEnd.Login.model;

public class UsuarioDTO {
    private String email;
    private String password;

    public UsuarioDTO(){
        
    }
    
    public UsuarioDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    
}
