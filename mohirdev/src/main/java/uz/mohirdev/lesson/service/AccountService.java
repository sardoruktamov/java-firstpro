package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.repository.AccountRepository;

@Service
public class AccountService {

    // dependens inject qilish
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
