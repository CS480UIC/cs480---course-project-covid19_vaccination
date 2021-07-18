import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./components/Login/login";
import Header from "./components/Header/header";
import SignUp from "./components/Login/signup";
import Home from "./components/Home/home";
import Delete from "./components/Login/delete";
import { DeleteForeverOutlined } from "@material-ui/icons";

const App = () => {

  return (
        <>
          <Router>
            <div className="app">
            {/* <Header /> */}
              <Switch>
                <Route exact path="/login">
                  <Login />
                </Route>
                <Route exact path="/signUp">
                  <SignUp />
                </Route>
                <Route exact path="/home">
                  <Home />
                </Route>
                <Route exact path="/delete">
                  <Delete />
                </Route>
              </Switch>
            </div>
          </Router>
        </>
  );
};

export default App;