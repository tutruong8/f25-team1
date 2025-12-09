package csc340team1.DreamBuild.review;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * Customer review page (list of reviews for a customer)
     */
    @GetMapping("/customer/{customerId}/reviews")
    public String showCustomerReviews(@PathVariable Long customerId, Model model) {
        List<Review> reviews = reviewService.getReviewByCustomerId(customerId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("customerId", customerId);
        return "customer/customerReview";
    }

    /**
     * Builder review page (list of reviews for builder)
     */
    @GetMapping("/builder/{builderId}/reviews")
    public String showBuilderReviews(@PathVariable Long builderId, Model model) {
        List<Review> reviews = reviewService.getReviewByBuilder(builderId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("builderId", builderId);
        return "builder/builderReviews";
    }

    /**
     * Computer review page (list of reviews for a computer)
     */
    @GetMapping("/computer/{computerId}/reviews")
    public String showComputerReviews(@PathVariable Long computerId, Model model) {
        List<Review> reviews = reviewService.getReviewByComputer(computerId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("computerId", computerId);
        return "review/computer-reviews"; 
    }

    /**
     * Single review details page
     */
    @GetMapping("/review/{reviewId}")
    public String getReviewDetails(Long reviewId, Model model) {
        Optional<Review> review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review.orElse(null));
        return "review/review-details";
    }

    /**
     * Endpoint to create/add a review in the database
     * 
     * @param review Review to add
     * @return added Review
     */
    @PostMapping("/review")
    public Object createReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/customer/" + review.getCustomer().getCustomerId() + "/reviews";
    }

    
   @PostMapping("/review/update/{id}")
   public String updateReview(@PathVariable Long id, @ModelAttribute Review review) {
reviewService.updateReview(id, review);       
       return "redirect:/customer/" + id + "reviews";
   }

   @PostMapping("/review/delete/{id}")
   public String deleteReview(@PathVariable Long id, @RequestParam Long customerId) {
       reviewService.deleteReview(customerId);
       return "redirect:/customer/" + customerId + "/reviews";
   }
   

    /**
     * Endpoint to write review in JSON file
     * 
     * @param review Review to write
     * @return success message (empty string if successful)
     */
    @PostMapping("/review/write")
    public Object writeJson(@RequestBody Review review) throws IOException {
        return reviewService.writeJson(review);
    }

    /**
     * Endpoint read review JSON file contents
     * 
     * @return contents in JSON
     */
    @PostMapping("/review/read")
    public Object readJson() throws IOException {
        return reviewService.readJson();
    }

}
