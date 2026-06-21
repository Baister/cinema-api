package com.Senai.Filmes.Security;

import com.Senai.Filmes.Model.Usuario;
import com.Senai.Filmes.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
<<<<<<< HEAD

=======
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
<<<<<<< HEAD
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

=======
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

                //IMPORTANTE: o Spring Security exige o prefixo "ROLE_" nas authorities
                // Por isso "ROLE_" + cargo.name() resulta em "ROLE_ADMIN" ou "ROLE_USUARIO"
                // iSSO PERMITE USAR @PreAuthorize("hasRole('ADMIN')") nos Controllers
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
        return new User(
                usuario.getEmail(),
                usuario.getSenha(),
                List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getCargo().name()))
        );
<<<<<<< HEAD
=======

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    }
}
