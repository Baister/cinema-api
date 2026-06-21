package com.Senai.Filmes.Security;

<<<<<<< HEAD
=======

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
<<<<<<< HEAD

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException
    {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
=======
    @Autowired private JwtUtil jwtUtil;                     //Injeta jwtutil, não jwtservice
    @Autowired private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
        throws ServletException, IOException{

        String authHeader = request.getHeader("Authorization");

        //Se não tem token ou não começa com "Bearer", segue sem autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
            filterChain.doFilter(request, response);
            return;
        }

        try {
<<<<<<< HEAD
            String token = authHeader.substring(7);
            String email = jwtUtil.extrairEmail(token);

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                if (jwtUtil.validarToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{\"status\":401,\"mensagem\":\"Token inválido ou expirado\"}");
                    return;
                }
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":401,\"mensagem\":\"Token inválido ou expirado\"}");
            return;
=======
            String token = authHeader.substring(7);// remove "Bearer"
            String email = jwtUtil.extrairEmail(token);

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                if (jwtUtil.validarToken(token, userDetails)){
                    var authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                    
                }
            }

        }catch (Exception e ){
            // Token inválido ou expirado: segue sem autenticação(não lança erro)
            // O Spring security vai retornar 401 se a rota precisar de autenticação
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
        }

        filterChain.doFilter(request, response);
    }
}
