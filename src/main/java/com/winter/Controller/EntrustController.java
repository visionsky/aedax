package com.winter.Controller;


import com.winter.service.entrust.EntrustService;
import com.winter.service.user.VerifyService;
import com.winter.utils.IPUtil;
import com.winter.utils.SCaptcha;
import com.winter.utils.StringUtils;
import com.winter.utils.picUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

@RequestMapping("/v1/api")
public class EntrustController {

    @Autowired
    private EntrustService entrustService;
    @Autowired
    private VerifyService verifyService;


    @PostMapping("/entrust/{source}")
    @RequestMapping("/entrust/{source}/{userId}/{outCoinId}/{inCoinId}/{entrustDirection}/{entrustNumber}/{coinPrice}/{type}")
    public String entrust(@PathVariable("source") String source,HttpServletRequest request) {

        String entrustId=StringUtils.UUID();

        String ip = IPUtil.getIP(request);
        int ret=verifyService.saveUUId(entrustId,source,ip);
       return entrustId;

    }

    @GetMapping("/queryUuid/{source}/{uuid}")
    //@RequestMapping("/queryUuid/{source}/{uuid}")
    public String queryUuid(@PathVariable("source") String source,@PathVariable("uuid") String uuid,HttpServletRequest request) {

        String ip = IPUtil.getIP(request);
        return verifyService.queryUuid(uuid,source,ip);

    }


}
