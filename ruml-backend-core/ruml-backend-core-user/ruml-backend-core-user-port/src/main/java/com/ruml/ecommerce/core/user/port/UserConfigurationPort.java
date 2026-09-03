package com.ruml.ecommerce.core.user.port;
import com.ruml.ecommerce.core.user.dao.UserDao;
import com.ruml.ecommerce.core.user.function.PasswordMatcher;
import com.ruml.ecommerce.core.user.usecase.main.UserLoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.validation.Validator;
@Configuration
public class UserConfigurationPort {
    @Bean
    public UserLoginUseCase userLoginUseCase(Validator validator, UserDao userDao, PasswordMatcher passwordMatcher) {
        return new UserLoginUseCase(validator, userDao, passwordMatcher);
    }
}
