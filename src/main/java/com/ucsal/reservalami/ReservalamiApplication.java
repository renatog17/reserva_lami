package com.ucsal.reservalami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ucsal.reservalami.domain.Lami;
import com.ucsal.reservalami.domain.Reservante;
import com.ucsal.reservalami.repositories.LamiRepository;
import com.ucsal.reservalami.repositories.ReservanteRepository;
import com.ucsal.reservalami.security.domain.User;
import com.ucsal.reservalami.security.domain.UserRole;
import com.ucsal.reservalami.security.repository.UserRepository;

@SpringBootApplication
public class ReservalamiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReservalamiApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	ReservanteRepository reservanteRepository;
	@Autowired
	LamiRepository lamiRepository;
	
	@Override
	public void run(String... args) throws Exception {
		String senha = new BCryptPasswordEncoder().encode("123");
		User userAdmin = new User("admin", senha, UserRole.ADMIN);
		userRepository.save(userAdmin);
		
		User userComum = new User("12345678911", senha, UserRole.USER);
		Reservante reservante = new Reservante(senha, "12345678911");
		reservante.setUser(userComum);
		userRepository.save(userComum);
		reservanteRepository.save(reservante);
		
		Lami lami = new Lami("400b", "1", "Lami com Mac", 15);
		lamiRepository.save(lami);
	}
}
