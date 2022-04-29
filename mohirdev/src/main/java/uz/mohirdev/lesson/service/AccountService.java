package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.repository.AccountRepository;

@Service
public class AccountService {

    // dependens inject qilish
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //post  save
    public Account save(Account account){
        return accountRepository.save(account);
    }

    //delete
    public void delete(Long id){
        accountRepository.deleteById(id);
    }
}
