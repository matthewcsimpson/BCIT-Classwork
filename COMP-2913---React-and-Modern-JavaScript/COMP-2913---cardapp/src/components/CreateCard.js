import { useNavigate } from "react-location";
import React from "react";

export default function CreateCard({ formData, setFormData }) {
  const navigate = useNavigate();

  const handleChange = (e) => {
    let key = e.target.value;
    let isChecked = e.target.checked;
    setFormData((formData) => {
      return { ...formData, [key]: isChecked };
    });
  };

  const handleTextChange = (e) => {
    let data = e.target.value;
    let name = e.target.name;
    setFormData((formData) => {
      return { ...formData, [name]: data };
    });
  };

  const handleClick = (e) => {
    e.preventDefault();
    let index = formData.userID;
    console.log("index before: " + index);
    index++;
    setFormData((formData) => {
      return { ...formData, userID: index };
    });
    console.log("index after: " + index);
    navigate({ to: `showcase/${index}`, replace: true });
  };

  return (
    <div className="split-screen">
      <div className="left">
        <section className="copy">
          <h1>DevCard</h1>
          <p>Your personal digital portfolio</p>
        </section>
      </div>

      <div className="right">
        <form>
          <section className="copy">
            <h2>Create your DevCard</h2>
          </section>
          <div className="input-container name">
            <input
              type="text"
              name="fullName"
              placeholder="Your Full Name"
              onChange={(e) => handleTextChange(e)}
            />
          </div>
          <div className="input-container name">
            <input
              type="text"
              name="aboutMe"
              placeholder="About Me"
              onChange={(e) => handleTextChange(e)}
            />
          </div>
          <h3>Technologies You Know</h3>
          <div className="checkboxes">
            <label className="myLabel">
              <input
                type="checkbox"
                value="HTML"
                onChange={(e) => handleChange(e)}
              />
              HTML
            </label>
            <label className="myLabel">
              <input
                type="checkbox"
                value="CSS"
                onChange={(e) => handleChange(e)}
              />
              CSS
            </label>
            <label className="myLabel">
              <input
                type="checkbox"
                value="JS"
                onChange={(e) => handleChange(e)}
              />
              JS
            </label>
            <label className="myLabel">
              <input
                type="checkbox"
                value="Git"
                onChange={(e) => handleChange(e)}
              />
              Git
            </label>
            <label className="myLabel">
              <input
                type="checkbox"
                value="React"
                onChange={(e) => handleChange(e)}
              />
              React
            </label>
            <label className="myLabel">
              <input
                type="checkbox"
                value="NodeJS"
                onChange={(e) => handleChange(e)}
              />
              Node.JS
            </label>
          </div>
          <div className="input-container name">
            <input
              type="text"
              name="githubURL"
              placeholder="Github username"
              onChange={(e) => handleTextChange(e)}
            />
          </div>
          <div className="input-container name">
            <input
              type="text"
              name="twitterURL"
              placeholder="@username"
              onChange={(e) => handleTextChange(e)}
            />
          </div>
          <div className="input-container name">
            <input
              type="text"
              name="favouriteBooks"
              placeholder="Favourite Books"
              onChange={(e) => handleTextChange(e)}
            />
          </div>
          <button onClick={handleClick} className="signup-btn" type="submit">
            Create Site
          </button>
        </form>
      </div>
    </div>
  );
}
