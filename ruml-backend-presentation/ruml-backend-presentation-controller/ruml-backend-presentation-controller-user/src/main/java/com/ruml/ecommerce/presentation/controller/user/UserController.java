package com.ruml.ecommerce.presentation.controller.user;
import com.ruml.ecommerce.core.user.usecase.main.UserLoginUseCase;
import com.ruml.ecommerce.core.user.factory.request.UserLoginRequest;
import com.ruml.ecommerce.core.user.factory.response.UserLoginResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserLoginUseCase userLoginUseCase;
    public UserController(UserLoginUseCase userLoginUseCase) {
        this.userLoginUseCase = userLoginUseCase;
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        var response = userLoginUseCase.execute(request);
        ResponseCookie cookie = ResponseCookie.from("ruml_auth_token", "dummy_jwt_token") // TODO: Implement real JWT
                .httpOnly(true).secure(true).path("/").sameSite("Strict").build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(response);
    }
}
