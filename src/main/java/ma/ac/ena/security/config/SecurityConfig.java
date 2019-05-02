package ma.ac.ena.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder); // new BCryptPasswordEncoder() ,
															// NoOpPasswordEncoder.getInstance()
		return provider;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.formLogin().loginPage("/login").defaultSuccessUrl("/accueil.html");
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/img/**").permitAll();
		http.authorizeRequests().antMatchers("/login*").permitAll(); // , "/etudiants/**"
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/register/**", "/editUser/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/register/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();

		// 1
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// 2
		// http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		// 3
		// http.addFilterBefore(new JWTAuthorizationFilter(),
		// UsernamePasswordAuthenticationFilter.class);

	}
	//// Http..formLogin().loginPage("/login.html").loginProcessingUrl("/login").successHandler(myAuthenticationSuccessHandler());
	// @Bean("authenticationManager")
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// return super.authenticationManagerBean();
	// }
	//
	// @Bean
	// public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
	// return new MySimpleUrlAuthenticationSuccessHandler();
	// }
}
