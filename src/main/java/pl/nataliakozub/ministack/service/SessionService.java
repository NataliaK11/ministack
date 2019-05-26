package pl.nataliakozub.ministack.service;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
@Data
@Service
@Scope(scopeName = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {

    private int userId;
    private String nickname;
    private boolean isLogin;
}
