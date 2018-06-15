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
		Review reviewOne = new Review(12L, "Eating vegetables", "/img/vegetables.jpg", "Food", "Vegetables are food for herbivorous animals such as hamsters, giraffes, and hippies. They have a window of about 48 hours in which they are ripe and relatively tasty; before this window they are bitter and hard, and after it they are squishy and rotten. Fortunately they are cheap and easy to cook. Eating them daily results in good health and longevity.", 3);
		Review reviewTwo = new Review(34L, "Raising a parakeet", "/img/parakeet.jpg", "Pets", "Parakeets are cool birds that produce uncool messes. Though they live in cages, their excrement will frequently make its way onto your walls and floor. Parakeets enjoy biting people who try to touch them, eating seeds, laying eggs, and making noise when you are trying to sleep.", 2);
		Review reviewThree = new Review(56L, "Visiting Nashville", "/img/nashville.jpg", "Travel", "Nashville is a beautiful city full of history and dorky tourists. It is famed for its hot chicken, country music, scenic views, and historic landmarks. Check out the fried balogna sandwiches at Robert's Western World. If you like Johnny Cash, you should visit the Johnny Cash Museum; otherwise, you shouldn't.", 4);
		Review reviewFour = new Review(78L, "Having a mustache", "/img/mustache.jpg", "Lifestyle", "A mustache, also called a flavor saver, is a must for any sophisticated gentleman. Despite its ability to turn even the most bland face into a work of art, the mustache has unfortunate connotations for some people. If you are a rugged individualist looking to stand out from the rabble, the mustache just might be right for you.", 5);
		this.addReview(reviewOne);
		this.addReview(reviewTwo);
		this.addReview(reviewThree);
		this.addReview(reviewFour);
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
