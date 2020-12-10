import React from 'react';
import {Button} from 'antd';
import 'antd/dist/antd.css';
import logo from './logo.svg';
import './App.css';
import {Switch, Route, Redirect} from 'react-router-dom'
<<<<<<< HEAD
import { adminRoute } from './routes/routesfile';
import Frame from './components/Frame/index.js'

function App() {
  return (
    <Frame>
      <Switch>
        {adminRoute.map(route =>{
=======
import { adminRoutes } from './routes/routesfile';
import Frame from './components/Frame/Index.js'
import { isLogined } from './utils/auth'

function App() {
  return  isLogined()? (
    <Frame>
      <Switch>
        {adminRoutes.map(route =>{
>>>>>>> us-2-frontend
          return(
            <Route
            key={route.path}
            path={route.path}
            exact={route.exact}
            render={routeProps =>{
              return <route.component{...routeProps}/>;
            }}
            />
          );
        })}
<<<<<<< HEAD
=======
        <Redirect to={adminRoutes[0].path} from="/admin" />
>>>>>>> us-2-frontend
        <Redirect to="/404"/>

      </Switch>
    </Frame>
<<<<<<< HEAD
  );
}
=======
    ): (
      <Redirect to="/login" />
    );
  }
>>>>>>> us-2-frontend

export default App;
