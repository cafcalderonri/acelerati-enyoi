package com.enyoi.cleanarchitecture.infrastructure.adapters.encrypter;

import com.enyoi.cleanarchitecture.domain.ports.EncrypterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncrypterAdapter implements EncrypterPort {

    private final BCryptPasswordEncoder encoder;

    @Override
    public String encryptPassword(String noEncryptedPassword) {
        return encoder.encode(noEncryptedPassword);
    }


}
