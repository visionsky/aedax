package com.winter.service.entrust;

import com.winter.model.Entrust;
import com.winter.model.Revoke;
import com.winter.model.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public interface EntrustService {


    //long getUserCount();

    @Transactional
    String entrust(Entrust record);
    List<Entrust> queryEntrusts(Entrust record);
    @Transactional
    String revoke(Revoke record);
    List<Revoke> queryRevokes(Revoke record);
    @Transactional
    String confirm(Transaction record);
    List<Transaction> queryTransactions(Transaction record);


 //   List<User> findAllUser(int pageNum, int pageSize);
}
