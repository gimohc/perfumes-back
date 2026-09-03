package com.ruml.ecommerce.core.user.usecase.main;
import com.ruml.ecommerce.core.shared.usecase.FunctionalUseCase;
import com.ruml.ecommerce.core.user.dao.UserDao;
import com.ruml.ecommerce.core.user.factory.request.UserLoginRequest;
import com.ruml.ecommerce.core.user.factory.response.UserLoginResponse;
import com.ruml.ecommerce.core.user.function.PasswordMatcher;
import jakarta.validation.Validator;
public class UserLoginUseCase extends FunctionalUseCase<UserLoginRequest, UserLoginResponse> {
    private final UserDao userDao;
    private final PasswordMatcher passwordMatcher;
    public UserLoginUseCase(Validator validator, UserDao userDao, PasswordMatcher passwordMatcher) {
        super(validator);
        this.userDao = userDao;
        this.passwordMatcher = passwordMatcher;
    }
    @Override
    protected UserLoginResponse doExecute(UserLoginRequest request) {
        var user = userDao.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordMatcher.matches(request.password(), user.passwordHash())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new UserLoginResponse(true, user.role());
    }
}
