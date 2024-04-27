package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public Trade saveTrade(Trade  trade){
        return  tradeRepository.save(trade);
    }

    //Find
    public List<Trade> getTrade(){
        return tradeRepository.findAll();
    }

    public Optional<Trade> getTradeById(Integer id){
        return  tradeRepository.findById(id);
    }

    //Delete
    public void deleteTrade(Trade trade){
        tradeRepository.delete(trade);
    }
}
