package org.wecancodeit.reviewssite;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewsSiteController.class)
public class ReviewsSiteControllerTest {
	@Resource
	MockMvc mvc;
	@MockBean
	ReviewsSiteRepository reviewsRepo;
	@Mock
	Review review;

	@Test
	public void getReviewsShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is(equalTo("reviews"))));
	}

	@Test
	public void getReviewsShouldBeOk() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void getReviewsShouldReturnAllReviews() throws Exception{
		mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(reviewsRepo.findAll())));

	}
	
	@Test
	public void getReviewShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews/12")).andExpect(view().name(is(equalTo("review"))));	
	}
	
	@Test
	public void getReviewShouldBeOk() throws Exception{
		mvc.perform(get("/reviews/12")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void getReviewShouldReturnAReview() throws Exception{
		mvc.perform(get("/reviews/12")).andExpect(model().attribute("review", is(reviewsRepo.findById(12L))));
	}
}
