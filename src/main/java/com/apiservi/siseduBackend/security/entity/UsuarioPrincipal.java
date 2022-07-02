package com.apiservi.siseduBackend.security.entity;

import com.apiservi.siseduBackend.entity.Persona;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    /*implemetar los privilegios de cada usuario*/
    private Persona nIdPersona;
    private String sUsername;
    private String sPassword;
    private String sCorreo;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(Persona nIdPersona, String sUsername, String sPassword, String sCorreo, Collection<? extends GrantedAuthority> authorities) {
        this.nIdPersona = nIdPersona;
        this.sUsername = sUsername;
        this.sPassword = sPassword;
        this.sCorreo = sCorreo;
        this.authorities = authorities;
    }

    /*metodo estatico que se llama build, que asigna los privilegios a los usuarios*/
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(
                    rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())
                ).collect(Collectors.toList());

        return new UsuarioPrincipal(usuario.getNIdPersona(), usuario.getSUsername(), usuario.getSPassword(), usuario.getSCorreo(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return sPassword;
    }

    @Override
    public String getUsername() {
        return sUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getsCorreo() {
        return sCorreo;
    }
}
