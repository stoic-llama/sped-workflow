package edu.ccsu.sped.workflow;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.web.context.WebApplicationContext;

import edu.ccsu.sped.workflow.services.SpedUserDetailsService;


@Configuration
@EnableWebSecurity
@ComponentScan("edu.ccsu.sped.workflow.services")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebApplicationContext applicationContext;
    private SpedUserDetailsService userDetailsService;
    /*
    @Autowired
    private AuthenticationSuccessHandlerImpl successHandler;
    */
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void completeSetup() {
        userDetailsService = applicationContext.getBean(SpedUserDetailsService.class);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(encoder())
            .and()
            .authenticationProvider(authenticationProvider())
            .jdbcAuthentication()
            .dataSource(dataSource);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http.csrf().disable();
        http.headers().frameOptions().disable();
    	
        http.authorizeRequests()
        	.antMatchers("/").hasAnyAuthority("coordinator,instructor,reader,student")
        	.antMatchers("/workflowdetail").hasAnyAuthority("coordinator,instructor,reader,student")
        	.antMatchers("/workflowdetail/edit").hasAnyAuthority("coordinator,instructor,reader")
        	.antMatchers("/workflowdetail/save").hasAnyAuthority("coordinator,instructor,reader")
        	.antMatchers("/submitassignment").hasAuthority("student")
        	.antMatchers("/saveportfolio").hasAuthority("student")
        	.antMatchers("/user-management").hasAuthority("coordinator")
        	.antMatchers("/user-management/create").hasAuthority("coordinator")
        	.antMatchers("/user-management/edit").hasAuthority("coordinator")
        	.antMatchers("/user-management/save").hasAuthority("coordinator")
        	.antMatchers("/user-management/savenew").hasAuthority("coordinator")
        	.antMatchers("/workflow-management").hasAuthority("coordinator")
        	.antMatchers("/addWorkflow/").hasAuthority("coordinator")
        	.antMatchers("/view-all-workflows").hasAuthority("coordinator")
        	.antMatchers("/login")
            .permitAll()
            .and()
            .formLogin()
            .permitAll()
            //.successHandler(successHandler)
            .and()
            .csrf()
            .disable();
    }
   
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService);
    }
    

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
    
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}