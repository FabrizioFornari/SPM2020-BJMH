import React from 'react';
import {Button} from 'antd';
import 'antd/dist/antd.css';
import logo from './logo.svg';
import './App.css';
import {Switch, Route, Redirect} from 'react-router-dom'
import { adminRoute } from './routes/routesfile';
import Frame from './components/Frame/index.js'

function App() {
  return (
    <Frame>
      <Switch>
        {adminRoute.map(route =>{
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
        <Redirect to="/404"/>

      </Switch>
    </Frame>
  );
}

export default App;
