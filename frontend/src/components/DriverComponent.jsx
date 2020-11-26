import React, { Component } from "react";
import DriverService from "../services/DriverService.jsx";
//import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class DriverComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            drivers: [],
            isLoading : true
        }
        //this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/drivers')
            .then(response => response.json())
            .then(data => this.setState({groups: data, isLoading: false}));
    /*
        DriverService.getDriver().then((response) => {
            try {
                console.log(response)
            } catch (e) {
                console.log(e)
            }
            this.setState({drivers: response.data})
        })
        */
    }

    render() {
        const {drivers, isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }

        const driverList = drivers.map(
                    driver =>
                        <tr key={driver.id}>
                            <td>{driver.id}</td>
                            <td>{driver.firstName}</td>
                            <td>{driver.lastName}</td>
                        </tr>
                )


        return(
            <div>
                <h1 className="text-center">Drivers</h1>
                <table className={"table table-striped"}>
                    <thead>
                    <tr>
                        <td>Driver id</td>
                        <td>Driver first name</td>
                        <td>Driver last name</td>
                    </tr>
                    </thead>
                    <tbody>
{driverList}

                    </tbody>
                </table>


            </div>
        )
    }
}

export default DriverComponent