package com.example.demo.auth.confirmations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationTokenEntity confirmationTokenEntity) {
        confirmationTokenRepository.save(confirmationTokenEntity);
    }

}
