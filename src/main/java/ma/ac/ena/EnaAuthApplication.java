package ma.ac.ena;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EnaAuthApplication implements CommandLineRunner {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(EnaAuthApplication.class, args);
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
	// @Autowired
	// private UsersRolesService usersRolesService;

	@Override
	public void run(String... args) throws Exception {
		// OK *************** Add Role ****************
		// Role r = new Role();
		// r.setRole("USER");
		// // r.setDescription("administrateur");
		// roleService.saveRole(r);

		// OK *************** Add User ***************
		// User u = new User();
		// u.setUsername("sco");
		// u.setPassword("sco");
		// usersService.saveUser(u);

		// OK *************** Add Role To User **************
		// usersRolesService.addRoleToUser("bb", "USER");
		// usersRolesService.addRoleToUser("admin", "ADMIN");

		// OK *********** test find Role By Username *********************
		// Collection<Role> roles = usersRolesService.findRoleByUsername("admin");
		// for (Role e : roles) {
		// System.out.println(e.getRole());
		// }

	}

}
