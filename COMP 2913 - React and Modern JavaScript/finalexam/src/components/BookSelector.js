import "../styles.css";
import BookDetail from "./BookDetail";

export default function BookSelector({ books, setCurrent }) {
  return (
    <div>
      <h3>Select an Book</h3>

      {books.map((book) => (
        <BookDetail book={book} setCurrent={() => setCurrent(book.id)} />
      ))}
    </div>
  );
}
