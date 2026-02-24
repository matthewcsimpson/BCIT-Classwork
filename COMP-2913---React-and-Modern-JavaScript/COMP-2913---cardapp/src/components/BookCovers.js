import { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBook } from "@fortawesome/free-solid-svg-icons";
import React from "react";

export function BookCover({ title }) {
  console.log("BOOK TITLE: " + title);
  const [img, setImg] = useState("");
  const textString = encodeURI(title);
  const API_URL = `https://www.googleapis.com/books/v1/volumes?q=${textString}`;

  fetch(API_URL)
    .then((data) => data.json())
    .then((jsonData) =>
      setImg(jsonData.items[0].volumeInfo.imageLinks.thumbnail)
    )
    .catch((err) => console.log(err));

  return <img className="book-image" src={img} alt={title}></img>;
}

export function ListBooks({ formData }) {
  let booksData = formData.favouriteBooks.split(", ");
  console.log(booksData);
  return (
    <>
      <h1 class="title">
        <FontAwesomeIcon icon={faBook} />
        &nbsp;My favorite books
      </h1>
      {booksData.map((book) => {
        return <BookCover title={book} />;
      })}
    </>
  );
}

/* 
<ListBooks formData={formData} />
The Fellowship of the Ring, The Two Towers, The Return of the King */
