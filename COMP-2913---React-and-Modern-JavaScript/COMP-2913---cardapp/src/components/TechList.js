import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCss3,
  faHtml5,
  faJs,
  faGit,
  faNodeJs,
  faReact,
} from "@fortawesome/free-brands-svg-icons";
import { faTerminal } from "@fortawesome/free-solid-svg-icons";
import React from "react";

export default function TechList({ formData }) {
  return (
    <div class="lx-row lx-card">
      <h1 class="title">
        <FontAwesomeIcon icon={faTerminal} /> &nbsp;Technologies
      </h1>
      <div class="mini-cards">
        {formData.HTML ? (
          <span class="has-dflex-center bs-md" title="CSS">
            <FontAwesomeIcon icon={faHtml5} size="3x" />
          </span>
        ) : null}
        {formData.CSS ? (
          <span class="has-dflex-center bs-md" title="CSS">
            <FontAwesomeIcon icon={faCss3} size="3x" />
          </span>
        ) : null}
        {formData.JS ? (
          <span class="has-dflex-center bs-md" title="JS">
            <FontAwesomeIcon icon={faJs} size="3x" />
          </span>
        ) : null}
        {formData.Git ? (
          <span class="has-dflex-center bs-md" title="Git">
            <FontAwesomeIcon icon={faGit} size="3x" />
          </span>
        ) : null}
        {formData.NodeJS ? (
          <span class="has-dflex-center bs-md" title="Node JS">
            <FontAwesomeIcon icon={faNodeJs} size="3x" />
          </span>
        ) : null}
        {formData.React ? (
          <span class="has-dflex-center bs-md" title="React">
            <FontAwesomeIcon icon={faReact} size="3x" />
          </span>
        ) : null}
      </div>
    </div>
  );
}
