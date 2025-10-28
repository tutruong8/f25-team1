package csc340team1.DreamBuild.review;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import csc340team1.DreamBuild.pc_part.PCPart;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepo.findById(id);
    }

     public List<Review> getReviewByBuilder(Long builderId) {
        return reviewRepo.findByBuilderId(builderId);
    }

    public List<Review> getReviewByComputer(Long computerId) {
        return reviewRepo.findByComputerId(computerId);
    }

    public Review createReview(Review review) {
        return reviewRepo.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepo.findById(id).map(review -> {
            review.setRating(updatedReview.getRating());
            review.setComment(updatedReview.getComment());
            review.setBuilder(updatedReview.getBuilder());
            review.setComputer(updatedReview.getComputer());
            return reviewRepo.save(review);
        }).orElseThrow(() -> new NoSuchElementException("Review not found with id " + id));
    }

    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    /**
   * Method to write PC part to JSON file
   * @param review Review to write
   */
    public String writeJson(Review review) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("review.json"), review);
        return "Review has been written to JSON file";
    }

    /**
   * Method to read Review from JSON file
   * @param review Review to read
   * @return contents in JSON
   */
    public Review readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("review.json"), Review.class);
    }
}
