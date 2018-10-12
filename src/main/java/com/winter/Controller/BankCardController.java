package com.winter.Controller;

import com.winter.model.BankCard;
import com.winter.service.bank.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankCard")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @PostMapping("/selectByUserId/{user_id}")
    public List<BankCard> selectByUserId(@PathVariable("user_id") String user_id){

        return bankCardService.selectByUserId(user_id);
    }


    @PostMapping("/addBankCard")
    public  void addBankCard( @RequestBody BankCard bankCard){

        bankCardService.addBankCard(bankCard);
    }



    @PostMapping("/deleteByBankCardId/{bank_id}")
    public  void  deleteByBankCardId(@PathVariable("bank_id") String bank_id){

        bankCardService.deleteByBankCardId(bank_id);
    }


    @PostMapping("/deleteByUserId/{user_id}")
    public void  deleteByUserId(@PathVariable("user_id") String user_id){

        bankCardService.deleteByUserId(user_id);
    }
}
