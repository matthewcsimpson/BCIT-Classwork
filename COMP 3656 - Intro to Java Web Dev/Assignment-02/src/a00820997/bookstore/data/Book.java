package a00820997.bookstore.data;

public class Book {

	// book_id,isbn,authors,original_publication_year,original_title,average_rating,ratings_count,image_url

	public static class Builder {

		private int bookID;
		private String isbn;
		private String authors;
		private int originalPubYear;
		private String originalTitle;
		private float avgRating;
		private long ratingsCount;
		private String imageURL;

		public Builder(final int bookID, final String originalTitle) {
			this.bookID = bookID;
			this.originalTitle = originalTitle;

		}

		public Builder authors(final String var) {
			if (!var.isEmpty() && var != null) {
				authors = var;
			}
			return this;
		}

		public Builder avgRating(final float var) {
			avgRating = var;
			return this;
		}

		public Book build() {
			return new Book(this);
		}

		public Builder imageURL(final String var) {
			if (!var.isEmpty() && var != null) {
				imageURL = var;
			}
			return this;
		}

		public Builder isbn(final String var) {
			if (!var.isEmpty() && var != null) {
				isbn = var;
			}
			return this;
		}

		public Builder originalPubYear(final int var) {
			originalPubYear = var;
			return this;
		}

		public Builder ratingsCount(final long var) {

			ratingsCount = var;
			return this;
		}

	}
	private int bookID;
	private String isbn;
	private String authors;
	private int originalPubYear;
	private String originalTitle;
	private float avgRating;
	private long ratingsCount;

	private String imageURL;

	public Book(final Builder builder) {
		bookID = builder.bookID;
		isbn = builder.isbn;
		authors = builder.authors;
		originalPubYear = builder.originalPubYear;
		originalTitle = builder.originalTitle;
		avgRating = builder.avgRating;
		ratingsCount = builder.ratingsCount;
		imageURL = builder.imageURL;
	}

	public String getAuthors() {
		return authors;
	}

	// getters -------------------------------------------------

	public float getAvgRating() {
		return avgRating;
	}

	public int getBookID() {
		return bookID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getOriginalPubYear() {
		return originalPubYear;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public long getRatingsCount() {
		return ratingsCount;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	// setters -------------------------------------------------

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setOriginalPubYear(int originalPubYear) {
		this.originalPubYear = originalPubYear;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setRatingsCount(long ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", isbn=" + isbn + ", authors=" + authors + ", originalPubYear="
				+ originalPubYear + ", originalTitle=" + originalTitle + ", avgRating=" + avgRating + ", ratingsCount="
				+ ratingsCount + ", imageURL=" + imageURL + "]";
	}

}
