package Lab9_SpringFramework.config;

import Lab9_SpringFramework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Lab9_SpringFramework.entity.Role.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    private static final String rememberMeKey = "ourSecuredEncryptionKey";

    private static final String loginPathSpec = "/login";

    private static final String registerPathSpec = "/register";

    private static final String dashboardPathSpec = "/dashboard";

    private static final String logoutPathSpec = "/logout";

    private static final Integer tokenValidityDays = 21;

    private static final String rememberMeParameter = "remember-me";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");
    }

    private static List<String> publicPaths = new ArrayList<String>(Arrays.asList(
            "/",
            "index",
            "/static/css/*",
            "/static/js/*",
            "/api/user/**",
            loginPathSpec,
            "/login/login-error",
            registerPathSpec,
            logoutPathSpec
    ));

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers(publicPaths.toArray(new String[0]))
                        .permitAll()
                    .antMatchers(dashboardPathSpec)
                        .hasAnyAuthority(VISITOR.name(), ADMIN.name())
                        .anyRequest()
                        .authenticated()
                        .and()
                    .formLogin()
                        .loginPage(loginPathSpec)
                        .permitAll()
                        .defaultSuccessUrl( dashboardPathSpec, true)
                        .passwordParameter("password")
                        .usernameParameter("username")
                        .failureUrl("/login/login-error")
                        .and()
                    .rememberMe()
                        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(tokenValidityDays))
                        .key(rememberMeKey)
                        .rememberMeParameter(rememberMeParameter)
                        .and()
                    .logout()
                        .logoutUrl(logoutPathSpec)
                        .logoutRequestMatcher(new AntPathRequestMatcher(logoutPathSpec, HttpMethod.GET.name()))
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", rememberMeParameter)
                        .logoutSuccessUrl(loginPathSpec);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
