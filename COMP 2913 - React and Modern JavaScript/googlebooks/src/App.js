import { useState } from "react";

import "./App.css";
function App() {
  const [text, setText] = useState("");
  const [imgURL, setImgURL] = useState("");
  const url = `https://www.googleapis.com/books/v1/volumes?q=${encodeURI(
    text
  )}`;
  const handleClick = (e) => {
    e.preventDefault();
    fetch(url)
      .then((data) => data.json())
      .then((jsonData) =>
        setImgURL(jsonData.items[0].volumeInfo.imageLinks.thumbnail)
      )
      .catch((err) => console.log(err));
  };
  return (
    <div className="App">
      <body>
        <h3>Searching: {text}</h3>
        <form>
          <input
            type="text"
            name="book name"
            onChange={(e) => setText(e.target.value)}
          ></input>
          <button onClick={handleClick}>search</button>
        </form>
        {imgURL ? <img alt="book" src={imgURL} /> : null}
      </body>
    </div>
  );
}

export default App;

// https://www.googleapis.com/books/v1/volumes?q=outliers
