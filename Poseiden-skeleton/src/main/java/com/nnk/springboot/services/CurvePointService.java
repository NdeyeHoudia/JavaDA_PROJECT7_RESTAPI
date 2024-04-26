package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurvePointService {

    @Autowired
    private CurvePointRepository curvePointRepository;

    // Save
    public CurvePoint saveCurvePoint(CurvePoint  curvePoint){
        return  curvePointRepository.save(curvePoint);
    }

    //Find
    public List<CurvePoint> getCurvePoint(){
        return curvePointRepository.findAll();
    }

    public Optional<CurvePoint> getCurvePointById(Integer id){
        return  curvePointRepository.findById(id);
    }

    //Delete
    public void deleteCurvePoint(CurvePoint curvePoint){
        curvePointRepository.delete(curvePoint);
    }
}
