package com.proyecto.clinicaodontologica.security;
import com.proyecto.clinicaodontologica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/templates/odontologos/odontologoGuardar.html").hasRole("ADMIN")
                .antMatchers("/templates/odontologos/odontologoActualizar.html").hasRole("ADMIN")
                .antMatchers("/templates/odontologos/odontologoEliminar.html").hasRole("ADMIN")
                .antMatchers("/templates/pacientes/**").hasRole("ADMIN")
                .antMatchers("/templates/turnos/turnoEliminar.html").hasRole("ADMIN")
                .antMatchers("/templates/turnos/turnoActualizar.html").hasRole("ADMIN")
                .antMatchers("/templates/turnos/turnoListar.html").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/templates/acceso-denegado.html")
                .and()
                .formLogin()
                .and()
                .logout();
    }
}