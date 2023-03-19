import "../showcase.css";
import Profile from "./Profile";
import TechList from "./TechList";
import { ListBooks } from "./BookCovers";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faHandPointRight,
  faInfoCircle,
} from "@fortawesome/free-solid-svg-icons";
import React from "react";

export default function CardShowCase({ formData }) {
  return (
    <div className="pageBody">
      <main class="has-dflex-center">
        <section>
          <div class="lx-container-85">
            <div class="lx-row align-stretch">
              <div class="lx-column is-3">
                <div class="lx-row">
                  <Profile formData={formData} />
                </div>
              </div>
              <div class="lx-column">
                <div class="lx-row">
                  <div class="lx-row lx-card">
                    <h1 class="title">
                      <FontAwesomeIcon icon={faInfoCircle} />
                      &nbsp;Welcome to {formData.fullName.split(" ")[0]}'s
                      corner of the Internet
                    </h1>
                  </div>
                  <div class="lx-row lx-card">
                    <h1 class="title">
                      <FontAwesomeIcon icon={faHandPointRight} />
                      &nbsp;About me
                    </h1>
                    <div class="text">{formData.aboutMe}</div>
                  </div>

                  <TechList formData={formData} />
                  <div class="lx-row lx-card">
                    <ListBooks formData={formData} />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
    </div>
  );
}
