import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Route, Switch} from 'react-router-dom';
import Helmet from "react-helmet";
import {Login} from "./components/pages/login/login";
import Dashboard from "./components/pages/dashboard/dashboard";
import {Register} from "./components/pages/registrer/register";
import {NotFound} from "./components/pages/notFound/notFound";


class App extends Component {
  render() {
    return (
        <Router>
          <Helmet>
            <meta charSet="utf-8"/>
            <title>Home | Authorization System</title>
            <meta httpEquiv="content-type" content="text/html; charset=utf-8"/>
            <meta name="keywords" content="Authorization System"/>
            <meta name="description" content="Authorization System"/>
            <meta name="author" content="Djambong Tenkeu Hank-Debain"/>
          </Helmet>
          <Switch>
            <Redirect exact path="/" to="/login"/>
            <Route exact path="/login" component={Login}/>
            <Route path="/login/**" component={Login}/>
            <Route exact path="/register" component={Register}/>
            <Route exact path="/dashboard" component={Dashboard}/>
            <Route path="/dashboard/**" component={Dashboard}/>
            <Route exact path="/404" component={NotFound}/>
            <Redirect to="/404"/>
          </Switch>
        </Router>
    );
  }
}

export default App;
