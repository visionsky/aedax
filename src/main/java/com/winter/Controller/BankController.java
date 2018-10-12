package com.winter.Controller;

import com.winter.model.Bank;
import com.winter.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<Bank> findAll(){



        return bankService.findAll();
    }


    /**
     * 添加银行
     * @param bank
     */
    @PostMapping("/addBank")
    public  void  addBank(Bank bank){

    };

    /**
     * 按照名称查询
     * @param name
     * @return
     */
    public List<Bank> selectBankByName(String name){
       return bankService.selectBankByName(name);

    };

    /**
     * 通过ID删除银行
     * @param bank_id
     */
   public void  deleteById(Integer bank_id) {

       bankService.deleteById(bank_id);
   };

    /**
     * 修改银行
     * @param bank
     */
  public  void  updateBankById(Bank bank){

      bankService.updateBankById(bank);

    };



}
