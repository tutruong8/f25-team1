package csc340team1.DreamBuild.review;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/builder/{builderId}/reviews")
    public String showBuilderReviews(@PathVariable Long builderId, Model model) {
        List<Review> reviews = reviewService.getReviewByBuilder(builderId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("builderId", builderId);
        return "builder/builderReviews";
    }

   /**
     * Single review details page
     */
    @GetMapping("/review/{reviewId}")
    public String getReviewDetails(Long reviewId, Model model){
    Optional<Review> review = reviewService.getReviewById(reviewId);
    model.addAttribute("review", review.orElse(null));
        return "review/review-details";
    }

    /**
   * Endpoint to get reviews through a builder's ID
   * @param builderId ID of the builder to get reviews for
   * @return List of reviews that belongs to the builder with the wanted ID
   */
    @GetMapping("/review/builder/{builderId}")
    public List<Review> getReviewByBuilderID(@PathVariable Long builderId) {
        return reviewService.getReviewByBuilder(builderId);
    }

    /**
   * Endpoint to get reviews through a computer's ID
   * @param computerId ID of the computer to get reviews for
   * @return List of pc parts with the wanted type
   */
    @GetMapping("/review/computer/{computerId}")
    public List<Review> getReviewByComputerID(@PathVariable Long computerId) {
        return reviewService.getReviewByComputer(computerId);
    }

    /**
   * Endpoint to create/add a review in the database
   * @param review Review to add
   * @return added Review
   */
    @PostMapping("/review")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    /**
   * Endpoint to update a review in the database
   * @param id ID of the review to update
   * @param review Review with updated information
   * @return updated Review
   */
    @PutMapping("/review/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    /**
   * Endpoint to delete a review in the database
   * @param id ID of the review to delete
   */
    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    /**
   * Endpoint to write review in JSON file
   * @param review Review to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/review/write")
    public Object writeJson(@RequestBody Review review) throws IOException {
        return reviewService.writeJson(review);
    }

    /**
   * Endpoint read review JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/review/read")
    public Object readJson() throws IOException {
        return reviewService.readJson();
    }
    
}
