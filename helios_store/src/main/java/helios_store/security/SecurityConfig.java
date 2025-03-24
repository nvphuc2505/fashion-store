package helios_store.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {

        httpSecurity
                .authorizeHttpRequests(
                        author -> {
                            author.requestMatchers("/api/private/**").hasRole("ADMIN");
                            author.requestMatchers("/api/public/**").hasRole("USER");
                            author.requestMatchers("/home", "/login").permitAll();
                            author.anyRequest().permitAll();
                        }
                )
                .formLogin(
                        form -> {
                            form
                                .loginPage("/login")                                                // Đường dẫn đến trang đăng nhập tùy chỉnh
                                .defaultSuccessUrl("/home", true)        // Chuyển hướng sau khi đăng nhập thành công
                                .failureUrl("/login?error=true")                // Chuyển hướng khi đăng nhập thất bại
                                .permitAll();
                        }
                );

        return httpSecurity.build();
    }

}
