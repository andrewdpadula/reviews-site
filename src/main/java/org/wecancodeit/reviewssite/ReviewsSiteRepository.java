package org.wecancodeit.reviewssite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReviewsSiteRepository {
	private Map<Long, Review> reviewsRepo = new HashMap<>();

	public Map<Long, Review> getReviewsRepo() {
		return reviewsRepo;
	}

	public ReviewsSiteRepository() {
		Review reviewOne = new Review(12L, "First Title", "/img/gandhi.jpg", "review category", "review content");
		Review reviewTwo = new Review(34L, "Second Title", "image url", "review category", "review content");
		Review reviewThree = new Review(56L, "Third Title", "image url", "review category", "review content");
		this.addReview(reviewOne);
		this.addReview(reviewTwo);
		this.addReview(reviewThree);
	}

	public int getRepoSize() {
		return reviewsRepo.size();
	}

	public void addReview(Review review) {
		reviewsRepo.put(review.getId(), review);
	}

	public Collection<Review> findAll() {
		return reviewsRepo.values();
	}

	public Review findById(long i) {
		return reviewsRepo.get(i);
	}

}
