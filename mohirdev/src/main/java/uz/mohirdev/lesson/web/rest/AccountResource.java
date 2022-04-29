package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.entity.Account;
import uz.mohirdev.lesson.entity.Item;
import uz.mohirdev.lesson.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity create(@RequestBody Account account){
        Account result = accountService.save(account);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/accounts")
    public ResponseEntity update(@RequestBody Account account){
        if (account.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Account resoult = accountService.save(account);
        return ResponseEntity.ok(resoult);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.ok("Account o'chirildi");
    }
}
