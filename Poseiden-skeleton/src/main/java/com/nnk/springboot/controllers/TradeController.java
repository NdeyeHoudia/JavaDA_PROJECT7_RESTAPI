package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    /**
     * this endpoint retrieves the list of trade
     * @param model
     * @param request
     * @return a trade object
     */
    @RequestMapping("/trade/list")
    public String home(Model model,  HttpServletRequest request)
    {
        model.addAttribute("remoteUser", request.getRemoteUser());
        model.addAttribute("trades", tradeRepository.findAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    /**
     *  this endpoint lets you add and register new curvePoint
     * @param trade
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "bidList/add";
        }
        tradeRepository.save(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        return "trade/add";
    }

    /**
     * this endpoint updates trade data using its identifier
     * @param id
     * @param model
     * @return a string
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        model.addAttribute("trades", trade);
        return "trade/update";
    }

    /**
     * this endpoint updates trade data using its identifier
     * @param id
     * @param trade
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "trade/update";
        }
        trade.setTradeId(id);
        tradeRepository.save(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        return "redirect:/trade/list";
    }

    /**
     * this function deletes an object using its identifier and displays the list after deletion
     * @param id
     * @param model
     * @return  a string
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        tradeRepository.delete(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        return "redirect:/trade/list";
    }
}
