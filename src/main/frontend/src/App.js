import React from 'react';
import {Button} from 'antd';
import 'antd/dist/antd.css';
import logo from './logo.svg';
import './App.css';
import {Switch, Route, Redirect} from 'react-router-dom'
import { adminRoutes } from './routes/routesfile';
import Frame from './components/Frame/Index.js'
import { isLogined } from './utils/auth'

function App() {
  return  isLogined()? (
    <Frame>
      <Switch>
        {adminRoutes.map(route =>{
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
        <Redirect to={adminRoutes[0].path} from="/admin" />
        <Redirect to="/404"/>

      </Switch>
    </Frame>
    ): (
      <Redirect to="/login" />
    );
  }

export default App;
