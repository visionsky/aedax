package com.winter.Controller;

import com.github.pagehelper.PageHelper;
import com.winter.model.Coin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {


    @GetMapping("/findAll")
    public List<Coin> findAll(){
        return  null;
    }



    @GetMapping("/selectByName/{name}")
    public List<Coin> selectByName(@PathVariable("name") String name){

        return  null;
    }


    public List<Coin> findByPage(Integer pageNum,Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);

        return null;
    }


    @PostMapping("/addCoin")
    public  void  addCoin(Coin coin){

    }


    @PostMapping("/deleteByCoinId/{coin_id}")
    public void  deleteByCoinId(@PathVariable("coin_id") String  coin_id){

    }


    @PostMapping("/updateCoin")
    public void  updateCoin(Coin coin){

    }




}
