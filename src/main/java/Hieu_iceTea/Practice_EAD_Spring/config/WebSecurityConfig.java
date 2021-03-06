package Hieu_iceTea.Practice_EAD_Spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //region - Authentication | JDBC-
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
        //.withDefaultSchema()
                /*.withUser(
                        User.withUsername("user")
                                .password("123456")
                                .roles("USER")
                )
                .withUser(
                        User.withUsername("admin")
                                .password("123456")
                                .roles("ADMIN")
                )
                .withUser(
                        User.withUsername("Hieu_iceTea")
                                .password("123456")
                                .roles("USER", "ADMIN")
                )
                .withUser(
                        User.withUsername("Hieu_IT")
                                .password("123456")
                                .roles("USER", "ADMIN")
                )*/
        ;

        //inMemoryAuthentication
        /*auth.inMemoryAuthentication()
                .withUser("customer").password("{noop}1996").roles("CUSTOMER")
                .and()
                .withUser("admin").password("{noop}1996").roles("ADMIN");*/
    }

    /*@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance(); //T???t m?? h??a m???t kh???u, m???t kh???u s??? ???????c l??u tr???c ti???p v??o DB
    }*/
    //endregion

    //region - Authorization | Configure -
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers("/admin/**").hasAnyRole("HOST", "ADMIN", "STAFF")
                .antMatchers("/account/profile/**").hasRole("CUSTOMER")
                .antMatchers("/account/my-order/**").hasRole("CUSTOMER")

                //.antMatchers("/rest-api/**").hasAnyRole("HOST") //ch??? HOST m???i call API
                .antMatchers("/rest-api/**").hasAnyRole("ADMIN") //Theo ????? b??i, ch??? ADMIN m???i call API th??i, ahihi
                .antMatchers("/repository-api/**").hasAnyRole("ADMIN") //Theo ????? b??i, ch??? ADMIN m???i call API th??i, ahihi

                //.antMatchers("/").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().denyAll()

                .and()
                .formLogin()
                //.loginPage("/account/login") //B??? d??ng n??y s??? d??ng trang login m???c ?????nh
                .permitAll()

                .and()
                .logout()
                .permitAll()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/account/access-denied")

                //Th??m 2 d??ng n??y n???u d??ng API (????ng nh???p ki???u Basic-Auth trong Postman)
                .and()
                .httpBasic()

                //Th??m ph???n n??y ????? h???y csrf, l??c ???? test trong Postman cho d???, ????? ph???i th??m th??m tr?????ng @csrf. AHIHI
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }
    //endregion

    //region - In-Memory Authentication -
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("Hieu_iceTea")
                        .password("123456")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
    //endregion
}