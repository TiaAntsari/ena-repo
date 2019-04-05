package ma.ac.ena;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.ac.ena.dao.EtudiantRepository;
import ma.ac.ena.entities.Etudiant;

@SpringBootApplication
public class EnaAuthApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(EnaAuthApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("Ravo", "Odilon", df.parse("2003-19-07")));
		etudiantRepository.save(new Etudiant("Agharra", "Zackaria", df.parse("2001-11-01")));
		etudiantRepository.save(new Etudiant("Kong", "Marc", df.parse("2002-15-02")));
		etudiantRepository.save(new Etudiant("netd1", "petd1", df.parse("2000-19-07")));
		etudiantRepository.save(new Etudiant("netd2", "petd2", df.parse("2000-19-07")));
		etudiantRepository.save(new Etudiant("netd3", "netd3", df.parse("2000-19-07")));

		List<Etudiant> etds = etudiantRepository.findAll();

		etds.forEach(e -> System.out.println(e.getNom()));

		/*
		 * for (Etudiant e : etds) { System.out.println(e.getNom()); }
		 */

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		System.out.println("1 --------------------------------------------------");
		System.out.println("b =>" + passwordEncoder.encode("b"));

		System.out.println("2 --------------------------------------------------");
		System.out.println("b =>" + passwordEncoder.encode("b"));
	}

}
