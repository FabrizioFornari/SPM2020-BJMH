import logo from './logo.svg';
import './App.css';
import React, {useState, useEffect} from 'react';
import UserBuilder from './components/UserBuilder/UserBuilder'
import axios from 'axios'; 

import Layout from './components/Layout/Layout'

const server = "http://localhost:8080/api";

/*
const ServerApi = () => {
  const [serverApi, setServerApi] =useState([]);

  const fetchServerApi = () => {
    axios.get(server).then(res =>{
      console.log(res)
      setServerApi(res.data)
    });
  };
*/

/*
  useEffect(() => {
    fetchServerApi();
  }, []);

  return serverApi.map((serverApi) => {
    return(
      <div><h1>{serverApi}</h1></div>
    )
  })
}
*/


function App() {
  return (
   <div className = "App">
     <Layout>
       <UserBuilder />
     </Layout>
   </div>
  );
}

export default App;
