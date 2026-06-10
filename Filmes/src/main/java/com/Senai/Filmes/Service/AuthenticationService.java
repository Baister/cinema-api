package com.Senai.Filmes.Service;

import com.Senai.Filmes.DTO.Request.CadastroRequest;
import com.Senai.Filmes.DTO.Request.LoginRequest;
import com.Senai.Filmes.DTO.Response.AuthReponse;
import com.Senai.Filmes.Model.Enums.Cargo;
import com.Senai.Filmes.Model.Usuario;
import com.Senai.Filmes.Repository.IUsuarioRepository;
import com.Senai.Filmes.Security.JwtUtil;
import com.Senai.Filmes.Security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    //Cadastrar(novo usuário)
//    public void cadastrarUsuario(CadastroRequest request){
//        // Regra de negócio> Verificar se o email já existe (opcional, mas recomendado)
//        if (usuarioRepository.findByEmail(request.email()).isPresent()){
//            throw new IllegalArgumentException("Este email já está em uso!");
//        }
//        // Criado o usuário em branco e preenchemoscom os dados do DTO
//        Usuario novoUsuario = new Usuario();
//        novoUsuario.setNome(request.nome());
//        novoUsuario.setEmail(request.email());
//
//        // A mágica acontece aqui: pegamos a senha em texto ("1234") e transformamos
//        // naquele código maluco (BCrypt) ANTES de salvar no banco de dados!
//
//        novoUsuario.setSenha(passwordEncoder.encode(request.senha()));
//
//        novoUsuario.setCargo(Cargo.USUARIO);
//        //novoUsuario.setCargo(Cargo.valueOf(request.cargo())); // depende de como é o meu enum Cargo
//        usuarioRepository.save(novoUsuario);
//
//    }
    public AuthReponse cadastrarUsuario(CadastroRequest cadastroRequest){
        if(usuarioRepository.existsByEmail(cadastroRequest.email())){
            throw new RuntimeException("E-mail já cadastrado");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(cadastroRequest.nome());
        novoUsuario.setEmail(cadastroRequest.email());
        novoUsuario.setSenha(passwordEncoder.encode(cadastroRequest.senha()));
        novoUsuario.setCargo(Cargo.USUARIO);

        usuarioRepository.save(novoUsuario);

        String token = jwUtil.gerarToken(novoUsuario);
        return new AuthReponse(token, novoUsuario.getNome(), novoUsuario.getCargo().name());
    }

    //Login
    public AuthReponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha())
        );

        Usuario usuario =  usuarioRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.email());

        String token = jwUtil.gerarToken(userDetails);
        return new AuthReponse(token, usuario.getNome(), usuario.getCargo().name());
    }
}
