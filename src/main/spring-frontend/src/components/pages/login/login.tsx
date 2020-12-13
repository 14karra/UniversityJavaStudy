import React from 'react'
import {Helmet} from 'react-helmet';
import {DefaultNavbar} from "../../navbars/defaultNavbar";
import {LoginBox} from "./loginBox";
import "../../../styles/login.css"

export const Login: React.FunctionComponent = () => (
    <div id="loginPageContainer">
        <Helmet>
            <title>Login | Authorization System</title>
        </Helmet>
        <DefaultNavbar/>
        <LoginBox />
    </div>
);