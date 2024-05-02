package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;
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
public class RuleNameController {

    @Autowired
    private RuleNameService ruleNameService;

    /**
     * this endpoint retrieves the list of ruleName
     * @param model
     * @param request
     * @return a ruleName object
     */
    @RequestMapping("/ruleName/list")
    public String home(Model model, HttpServletRequest request)
    {
        model.addAttribute("remoteUser", request.getRemoteUser());
        model.addAttribute("ruleNames", ruleNameService.getRuleName());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    /**
     *  this endpoint lets you add and register new ruleName
     * @param ruleName
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {

        if(result.hasErrors()){
           // return "ruleName/add";
            return "redirect:/ruleName/list";

        }
        ruleNameService.saveRuleName(ruleName);
        model.addAttribute("ruleNames", ruleNameService.getRuleName());
        return "ruleName/add";
    }

    /**
     * this endpoint updates ruleName data using its identifier
     * @param id
     * @param model
     * @return a string
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        RuleName  ruleName = ruleNameService.getRuleNameById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
        model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    /**
     * this endpoint updates ruleName data using its identifier
     * @param id
     * @param ruleName
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ruleName/update";
        }
        ruleName.setId(id);
        ruleNameService.saveRuleName(ruleName);
        model.addAttribute("ruleNames", ruleNameService.getRuleName());
        return "redirect:/ruleName/list";
    }

    /**
     * this function deletes an object using its identifier and displays the list after deletion
     * @param id
     * @param model
     * @return a string
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        RuleName ruleName = ruleNameService.getRuleNameById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
        ruleNameService.deleteRuleName(ruleName);
        model.addAttribute("ruleNames", ruleNameService.getRuleName());
        return "redirect:/ruleName/list";
    }
}
