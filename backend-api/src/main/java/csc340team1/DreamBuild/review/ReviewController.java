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

import csc340team1.DreamBuild.builder.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ReviewController {
    @Autowired
    private BuilderService builderService;
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
     * Reply to certain review
     */
    @GetMapping("/builder/{builderId}/reviews/{reviewId}/reply")
    public String showBuilderReviewReplyForm(@PathVariable Long builderId, @PathVariable Long reviewId, Model model) {
        Builder builder = builderService.getBuilderById(builderId);
        Review review = reviewService.getReviewById(reviewId).orElse(null);

        model.addAttribute("builder", builder);
        model.addAttribute("review", review);
        model.addAttribute("builderId", builderId);
        return "builder/builderReply";
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

   @PostMapping("/builder/{builderId}/reviews/{reviewId}/reply")
    public String submitReply(@PathVariable Long builderId, @PathVariable Long reviewId, @RequestParam String reply) {
        reviewService.addReply(reviewId, reply);
        return "redirect:/builder/" + builderId + "/reviews";
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
