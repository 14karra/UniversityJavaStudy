import React from 'react'
import {Helmet} from 'react-helmet';
import {DashboardNavbar} from "../../navbars/dashboardNavbar";

class Dashboard extends React.Component {
    constructor(props: any) {
        super(props);
    }

    render() {
        return (
            <div>
                <Helmet>
                    <title>Dashboard | Authorization Service</title>
                </Helmet>
                <DashboardNavbar/>
                <h1 className={"row h-100 justify-content-center align-items-center"}>You're within the dashboard!</h1>
            </div>
        )
    }
}

export default Dashboard;