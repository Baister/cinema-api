package com.Senai.Filmes.Controller;

import com.Senai.Filmes.DTO.Request.CadastroRequest;
import com.Senai.Filmes.DTO.Request.LoginRequest;
import com.Senai.Filmes.DTO.Response.AuthReponse;
import com.Senai.Filmes.Service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
@Tag(name = "Autenticação", description = "Endpoint para cadastro e login de usuários")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastrar usuário", description = "Cadastra um novo usuário e retorna o JWT Token")
    public ResponseEntity<AuthReponse> cadastrar(@RequestBody CadastroRequest request){
        return new ResponseEntity<>(authenticationService.cadastrarUsuario(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Autentica o usuário e retorna um token JWT")
    public ResponseEntity<AuthReponse> login(@RequestBody LoginRequest request){
        return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
    }
}
