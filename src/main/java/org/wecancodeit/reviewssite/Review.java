package org.wecancodeit.reviewssite;

public class Review {
	private long id;
	private String title;
	private String imageUrl;
	private String reviewCategory;
	private String content;
	private int score;

	public Review(long id, String title, String imageUrl, String reviewCategory, String content, int score) {
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.reviewCategory = reviewCategory;
		this.content = content;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public String getContent() {
		return content;
	}

}
