package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class CurveController {
    @Autowired
    private CurvePointRepository curvePointRepository;

    /**
     * this endpoint retrieves the list of curvePoint
     * @param model
     * @param request
     * @return a curvePoint object
     */
    @RequestMapping("/curvePoint/list")
    public String home(Model model, HttpServletRequest request)
    {
        model.addAttribute("remoteUser", request.getRemoteUser());
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    /**
     *  this endpoint lets you add and register new curvePoint
     * @param curvePoint
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
            if(result.hasErrors()){
                return "curvePoint/add";
            }
            curvePointRepository.save(curvePoint);
            model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "curvePoint/add";
    }

    /**
     * this endpoint updates curvePoint data using its identifier
     * @param id
     * @param model
     * @return a string
     */
    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
        model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    /**
     * this endpoint updates curvePoint data using its identifier
     * @param id
     * @param curvePoint
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/curvePoint/update/{id}")
    public String updateCurveid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "curve/update";
        }
        curvePoint.setId(id);
        curvePointRepository.save(curvePoint);
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "redirect:/curvePoint/list";
    }

    /**
     * this function deletes an object using its identifier and displays the list after deletion
     * @param id
     * @param model
     * @return  a string
     */
    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {

        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
        curvePointRepository.delete(curvePoint);
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "redirect:/curvePoint/list";
    }
}
