import "./App.css";
import { useState } from "react";
import books from "./data";

import BookViewer from "./components/BookViewer";
import BookSelector from "./components/BookSelector";

function App() {
  let [currentBook, setCurrentBook] = useState(0);
  return (
    <div className="App">
      <BookViewer current={currentBook} books={books} />
      <BookSelector
        books={books}
        setCurrent={(id) => setCurrentBook(id, console.log(id))}
      />
    </div>
  );
}

export default App;
