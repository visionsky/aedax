package com.winter.Controller;


import com.winter.service.entrust.EntrustService;
import com.winter.service.user.VerifyService;
import com.winter.utils.IPUtil;
import com.winter.utils.SCaptcha;
import com.winter.utils.StringUtils;
import com.winter.utils.picUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.winter.model.Entrust;
import com.winter.model.Revoke;
import com.winter.model.Transaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("/v1/api")
public class EntrustController {

    @Autowired
    private EntrustService entrustService;



    @PostMapping("/entrust/{source}")
    @RequestMapping("/entrust/{source}/{userId}/{outCoinId}/{inCoinId}/{entrustDirection}/{entrustNumber}/{coinPrice}/{type}")
    public String entrust(@PathVariable("source") String source,@PathVariable("userId") String userId,@PathVariable("outCoinId") String outCoinId,@PathVariable("inCoinId") String inCoinId,@PathVariable("entrustDirection") String entrustDirection,@PathVariable("entrustNumber") String entrustNumber,@PathVariable("coinPrice") String coinPrice,@PathVariable("type") String type) {

        String entrustId=StringUtils.UUID();
        Entrust record=new Entrust(entrustId,userId,outCoinId,inCoinId,entrustDirection,entrustNumber,coinPrice,type);
        //String ip = IPUtil.getIP(request);
        return entrustService.entrust(record);

        //int ret=verifyService.saveUUId(entrustId,source,ip);
       //return entrustId;

    }
    @GetMapping("/queryEntrustAll/{source}")
    @RequestMapping("/queryEntrustAll/{source}")
    public List<Entrust> queryEntrustAll(@PathVariable("source") String source) {

        Entrust record=new Entrust("","","","","","0","0","0");
       // record.setStatus("");
        return entrustService.queryEntrusts(record);

    }

    @GetMapping("/queryEntrust/{source}/{uuid}")
    @RequestMapping("/queryEntrust/{source}/{entrustId}/{userId}/{outCoinId}/{inCoinId}/{entrustDirection}/{entrustNumber}/{coinPrice}/{type}")
    public List<Entrust> queryEntrust(@PathVariable("source") String source,@PathVariable("entrustId") String entrustId,@PathVariable("userId") String userId,@PathVariable("outCoinId") String outCoinId,@PathVariable("inCoinId") String inCoinId,@PathVariable("entrustDirection") String entrustDirection,@PathVariable("entrustNumber") String entrustNumber,@PathVariable("coinPrice") String coinPrice,@PathVariable("type") String type) {


        Entrust record=new Entrust(entrustId,userId,outCoinId,inCoinId,entrustDirection,entrustNumber,coinPrice,type);
        return entrustService.queryEntrusts(record);

    }

    @PostMapping("/revoke/{source}")
    @RequestMapping("/revoke/{source}/{entrustId}/{revokeNumber}/{entrustDirection}")
    public String revoke(@PathVariable("source") String source,@PathVariable("entrustId") String entrustId,@PathVariable("revokeNumber") String revokeNumber,@PathVariable("entrustDirection") String entrustDirection) {

        String revokeId=StringUtils.UUID();
        Revoke record=new Revoke(revokeId,entrustId,revokeNumber);
        //String ip = IPUtil.getIP(request);
        //return  revokeId+entrustId+revokeNumber;
        return entrustService.revoke(record);

        //int ret=verifyService.saveUUId(entrustId,source,ip);
        //return entrustId;

    }
    @GetMapping("/queryRevokeAll/{source}")
    @RequestMapping("/queryRevokeAll/{source}")
    public List<Revoke> queryRevokeAll(@PathVariable("source") String source) {

        Revoke record=new Revoke("","","0");
        // record.setStatus("");
        return entrustService.queryRevokes(record);

    }

    @PostMapping("/Transaction/{source}")
    @RequestMapping("/Transaction/{source}/{buyerEntrustId}/{sellerEntrustId}/{transactionNumber}/{entrustDirection}")
    public String Transaction(@PathVariable("source") String source,@PathVariable("buyerEntrustId") String buyerEntrustId,@PathVariable("sellerEntrustId") String sellerEntrustId,@PathVariable("transactionNumber") String transactionNumber,@PathVariable("entrustDirection") String entrustDirection) {

        String transactionId=StringUtils.UUID();
        Transaction record=new Transaction(transactionId,buyerEntrustId,sellerEntrustId,transactionNumber);
        //String ip = IPUtil.getIP(request);
        return entrustService.confirm(record,entrustDirection);

        //int ret=verifyService.saveUUId(entrustId,source,ip);
        //return entrustId;

    }
    @GetMapping("/queryTransactionAll/{source}")
    @RequestMapping("/queryTransactionAll/{source}")
    public List<Transaction> queryTransactionAll(@PathVariable("source") String source) {

        Transaction record=new Transaction("","","","0");
        // record.setStatus("");
        return entrustService.queryTransactions(record);

    }
}
