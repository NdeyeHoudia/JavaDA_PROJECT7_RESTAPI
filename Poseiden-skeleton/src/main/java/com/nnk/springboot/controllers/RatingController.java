package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
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
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingService ratingService;

    /**
     * this endpoint retrieves the list of rating
     * @param model
     * @param request
     * @return a rating object
     */
    @RequestMapping("/rating/list")
    public String home(Model model, HttpServletRequest request)
    {
        model.addAttribute("remoteUser", request.getRemoteUser());
        model.addAttribute("ratings", ratingService.getRatings());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    /**
     *  this endpoint lets you add and register new rating
     * @param rating
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {

        if(result.hasErrors()){
            return "rating/add";
        }
        ratingService.saveRating(rating);
        model.addAttribute("ratings", ratingService.getRatings());
        return "rating/add";
    }

    /**
     * this endpoint updates rating data using its identifier
     * @param id
     * @param model
     * @return a string
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Rating rating = ratingService.getRatingById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    /**
     * this endpoint updates rating data using its identifier
     * @param id
     * @param rating
     * @param result
     * @param model
     * @return a string
     */
    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "rating/update";
        }
        rating.setId(id);
        ratingService.saveRating(rating);
        model.addAttribute("ratings", ratingService.getRatings());
        return "redirect:/rating/list";
    }

    /**
     * this function deletes an object using its identifier and displays the list after deletion
     * @param id
     * @param model
     * @return  a string
     */
    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {

        Rating rating = ratingService.getRatingById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
        ratingService.deleteRating(rating);
        model.addAttribute("ratings", ratingService.getRatings());
        return "redirect:/rating/list";
    }
}
