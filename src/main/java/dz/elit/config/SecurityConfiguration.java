package dz.elit.config;

import dz.elit.service.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration car la class enableWebsecurity contient l'annotation
@EnableWebSecurity

// l'ancienne facon de faire extends WebSecurityConfigurerAdapter
public class SecurityConfiguration {

    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;
    @Autowired
    private ApplicationRequestFilter applicationRequestFilter;

    // configuration de bc
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // configure AuthenticationManager so that it knows from where to load
//        // user for matching credentials
//        // Use BCryptPasswordEncoder
//        auth.userDetailsService(applicationUserDetailsService).passwordEncoder(passwordEncoder());
//    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(applicationUserDetailsService);
        auth.userDetailsService(applicationUserDetailsService).passwordEncoder(passwordEncoder());

    }

    // l'ancienne facon de faire
    // @Override
    // protected void configure(HttpSecurity http)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // on vas autorise que cette andpoint

        http.csrf().disable()
                .authorizeHttpRequests().
                antMatchers("/**/authenticate",
                        "/**/utilisateurs/create",
                        "/**/entreprises/**",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/swagger-ui/index.html",
                        "/v3/api-docs/**")
                .permitAll().
                anyRequest().authenticated().// tous les autres url doit avoir un token valide
                and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // sans etat
        // par defaut une api restfull on garde pas le status client
        ;
        http.addFilterBefore(applicationRequestFilter, UsernamePasswordAuthenticationFilter.class);
        //car c'est une application local
        //  super.configure(http);
        return http.build();
    }
// l'ancienne facon de faire
//@Bean
////@Override
//public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//}
// la nouvelle facon de faire
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

//@Bean
//    public WebSecurityCustomizer webSecurityCustomizer(WebSecurity web){
//       return (web) ->web.ignoring().antMatchers("/image/**","/js/**");
//
//    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//
        //  return NoOpPasswordEncoder.getInstance(); PasswordEncoder
    }
}
