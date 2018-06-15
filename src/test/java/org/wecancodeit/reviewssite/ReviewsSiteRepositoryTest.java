package org.wecancodeit.reviewssite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class ReviewsSiteRepositoryTest {
	ReviewsSiteRepository testRepo = new ReviewsSiteRepository();
	Review testReview = new Review(123L, "test title", "test url", "test category", "test content");
	@Test
	public void shouldAddNewReviewToRepo() {
		int numberOfReviewsBeforeAdd = testRepo.getRepoSize();
		testRepo.addReview(testReview);
		int numberOfReviewsAfterAdd = testRepo.getRepoSize();
		assertThat(numberOfReviewsAfterAdd, is(equalTo(numberOfReviewsBeforeAdd + 1)));
	}
	
	@Test
	public void findAllShouldReturnAllValues() {
		Collection<Review> testCollection = testRepo.findAll();
		assertThat(testCollection.size(), is(equalTo(3)));
	}
	
	@Test
	public void findAllShouldReturnReviews() {
		Collection<Review> testCollection = testRepo.findAll();
		testRepo.addReview(testReview);
		for(Review review: testCollection) {
			assertTrue(review instanceof Review);
		}
	}

	@Test
	public void findOneShouldReturnOneReviewById() {
		testRepo.addReview(testReview);
		Review underTest = testRepo.findById(123L);
		assertThat(underTest.getTitle(), is(equalTo("test title")));
	}
}
