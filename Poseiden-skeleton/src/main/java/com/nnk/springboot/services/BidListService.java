package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidListService {

    @Autowired
    private BidListRepository bidListRepository;

    // Save
    public BidList saveBidList(BidList  bidList){
        return  bidListRepository.save(bidList);
    }

    //Find
    public List<BidList> getBidLists(){
        return bidListRepository.findAll();
    }

    public Optional<BidList> getBidListById(Integer id){
        return  bidListRepository.findById(id);
    }

    //Delete
    public void deleteBid(BidList bidList){
         bidListRepository.delete(bidList);
    }
}
