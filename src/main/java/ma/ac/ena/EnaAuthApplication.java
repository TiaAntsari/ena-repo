package ma.ac.ena;

import java.text.ParseException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.ac.ena.dao.EtudiantRepository;
import ma.ac.ena.entities.Etudiant;

@SpringBootApplication
public class EnaAuthApplication implements CommandLineRunner {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(EnaAuthApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);

		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// etudiantRepository.save(new Etudiant("Ravo", "Odilon",
		// df.parse("2003-19-07")));
		// etudiantRepository.save(new Etudiant("Agharra", "Zackaria",
		// df.parse("2001-11-01")));
		// etudiantRepository.save(new Etudiant("Kong", "Marc",
		// df.parse("2002-15-02")));
		// etudiantRepository.save(new Etudiant("netd1", "petd1",
		// df.parse("2000-19-07")));
		// etudiantRepository.save(new Etudiant("netd2", "petd2",
		// df.parse("2000-19-07")));
		// etudiantRepository.save(new Etudiant("netd3", "netd3",
		// df.parse("2000-19-07")));

		List<Etudiant> etds = etudiantRepository.findAll();

		etds.forEach(e -> System.out.println(e.getNom()));

		/*
		 * for (Etudiant e : etds) { System.out.println(e.getNom()); }
		 */

		// PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		// System.out.println("1 --------------------------------------------------");
		// System.out.println("b =>" + passwordEncoder.encode("b"));
		//
		// System.out.println("2 --------------------------------------------------");
		// System.out.println("b =>" + passwordEncoder.encode("b"));
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	// ******************* ++++++ *****************

	// @Autowired
	// private UsersRolesService usersRolesService;
	// @Autowired
	// private UserService usersService;
	// @Autowired
	// private RoleService roleService;

	@Override
	public void run(String... args) throws Exception {
		// Role r = new Role();
		// r.setRole("USER");
		// // r.setDescription("administrateur");
		// roleService.saveRole(r);
		//
		// User u = new User();
		// u.setUsername("sco");
		// u.setPassword("sco");
		// usersService.saveUser(u);

		// usersRolesService.addRoleToUser("bb", "USER");
		// usersRolesService.addRoleToUser("admin", "ADMIN");

	}

}
