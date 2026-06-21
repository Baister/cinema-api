package com.Senai.Filmes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

@SpringBootTest
class FilmesApplicationTests {

	@Test
	void contextLoads() {
	}

<<<<<<< HEAD
	@Test
	void gerarHashSenha() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Admin:   " + encoder.encode("Admin@123"));
		System.out.println("Usuario: " + encoder.encode("Usuario@123"));
	}

=======
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
