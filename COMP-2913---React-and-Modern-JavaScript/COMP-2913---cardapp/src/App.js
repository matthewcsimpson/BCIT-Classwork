import "./App.css";
import { Router, Outlet, ReactLocation } from "react-location";
import CreateCard from "./components/CreateCard";
import CardShowcase from "./components/CardShowcase";
import { useState } from "react";
import React from "react";

const location = new ReactLocation();

export default function App() {
  const [formData, setFormData] = useState({
    userID: 0,
    fullName: "",
    aboutMe: "",
    githubURL: "",
    twitterURL: "",
    favouriteBooks: [""],
    HTML: false,
    CSS: false,
    JS: false,
    Git: false,
    React: false,
    NodeJS: false,
  });

  const routes = [
    {
      path: "/",
      element: <CreateCard formData={formData} setFormData={setFormData} />,
    },
    {
      path: "showcase",
      element: <CardShowcase formData={formData} />,
    },
  ];

  return (
    <Router routes={routes} location={location}>
      {/* <header>{JSON.stringify(formData)}</header> */}
      <div>
        <Outlet />
      </div>
    </Router>
  );
}
