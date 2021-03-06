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
        return NoOpPasswordEncoder.getInstance(); //Tắt mã hóa mật khẩu, mật khẩu sẽ được lưu trực tiếp vào DB
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

                //.antMatchers("/rest-api/**").hasAnyRole("HOST") //chỉ HOST mới call API
                .antMatchers("/rest-api/**").hasAnyRole("ADMIN") //Theo đề bài, chỉ ADMIN mới call API thôi, ahihi
                .antMatchers("/repository-api/**").hasAnyRole("ADMIN") //Theo đề bài, chỉ ADMIN mới call API thôi, ahihi

                //.antMatchers("/").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().denyAll()

                .and()
                .formLogin()
                //.loginPage("/account/login") //Bỏ dòng này sẽ dùng trang login mặc định
                .permitAll()

                .and()
                .logout()
                .permitAll()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/account/access-denied")

                //Thêm 2 dòng này nếu dùng API (Đăng nhập kiểu Basic-Auth trong Postman)
                .and()
                .httpBasic()

                //Thêm phần này để hủy csrf, lúc đó test trong Postman cho dễ, đỡ phải thêm thêm trường @csrf. AHIHI
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