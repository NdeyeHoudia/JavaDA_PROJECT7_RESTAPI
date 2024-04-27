package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleNameService {

    @Autowired
    private RuleNameRepository ruleNameRepository;

    //save
    public RuleName saveRuleName(RuleName  ruleName){
        return  ruleNameRepository.save(ruleName);
    }

    //Find
    public List<RuleName> getRuleName(){
        return ruleNameRepository.findAll();
    }

    public Optional<RuleName> getRuleNameById(Integer id){
        return  ruleNameRepository.findById(id);
    }

    //Delete
    public void deleteRuleName(RuleName ruleName){
        ruleNameRepository.delete(ruleName);
    }

}
