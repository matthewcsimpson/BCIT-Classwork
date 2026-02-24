import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUserCircle, faBriefcase } from "@fortawesome/free-solid-svg-icons";
import { faGitAlt, faTwitter } from "@fortawesome/free-brands-svg-icons";
import React from "react";

export default function Profile({ formData }) {
  let firstName = formData.fullName.split(" ")[0];
  let gitHubLink = "https://github.com/" + formData.githubURL;

  const twitterName = () => {
    let temp = formData.twitterURL;

    if (temp.charAt(0) === "@") {
      return "https://twitter.com/" + temp.substring(1);
    } else {
      return "https://twitter.com/" + temp;
    }
  };
  let twitterLink = twitterName();

  return (
    <div class="lx-card">
      <div class="lx-row">
        <div class="has-dflex-center bs-md pic">
          <img src="https://github.com/luxonauta.png" alt={formData.fullName} />
        </div>
        <div class="infos">
          <span>
            <FontAwesomeIcon icon={faUserCircle} />
            &nbsp;&nbsp;{formData.fullName}
          </span>
          <span>
            <FontAwesomeIcon icon={faBriefcase} />
            &nbsp;&nbsp;Full Stack Developer
          </span>
          <div class="lx-card">
            <div class="lx-row">
              <h1 class="title">Connect with {firstName}</h1>
              <div class="mini-cards">
                {formData.githubURL ? (
                  <a
                    class="has-dflex-center bs-md"
                    href={gitHubLink}
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    <FontAwesomeIcon icon={faGitAlt} size="4x" />
                  </a>
                ) : null}
                {formData.twitterURL ? (
                  <a
                    class="has-dflex-center bs-md"
                    href={twitterLink}
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    <FontAwesomeIcon icon={faTwitter} size="4x" />
                  </a>
                ) : null}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
