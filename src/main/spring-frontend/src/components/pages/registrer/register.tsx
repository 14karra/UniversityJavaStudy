import React from 'react'
import {Helmet} from 'react-helmet';
import RegisterBox from "./registerBox";
import {DefaultNavbar} from "../../navbars/defaultNavbar";

export const Register: React.FunctionComponent = () => (
    <div id="loginPageContainer">
        <Helmet>
            <title>Register | Authorization Service</title>
        </Helmet>
        <DefaultNavbar/>
        <RegisterBox/>
    </div>
);