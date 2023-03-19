export default function BookDetail({ book, setCurrent }) {
  let coauthorstring;
  let ratingString;

  if (book.coAuthor) {
    coauthorstring = "with " + book.coAuthor;
  }

  switch (book.rating) {
    case 1:
      ratingString = "⭐️";
      break;
    case 2:
      ratingString = "⭐️⭐️";
      break;
    case 3:
      ratingString = "⭐️⭐️⭐️";
      break;
    case 4:
      ratingString = "⭐️⭐️⭐️⭐️";
      break;
    case 5:
      ratingString = "⭐️⭐️⭐️⭐️⭐️";
      break;
    default:
      ratingString = "";
  }

  return (
    <div class="bigbig" style={{ display: "flex", cursor: "pointer" }}>
      <img
        alt={book.name}
        style={{
          height: "45px",
          borderRadius: "30px",
          marginBottom: "15px",
        }}
        src={book.coverImg}
        onClick={() => setCurrent()}
      />
      <p onClick={() => setCurrent()} style={{ marginLeft: "50px" }}>
        <strong>{book.name}</strong> by {book.author} {coauthorstring},{" "}
        <strong>Rating:</strong> {ratingString}
      </p>
    </div>
  );
}
