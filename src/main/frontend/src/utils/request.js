import axios from 'axios';
import { getToken } from "./auth";

const instance = axios.create({
    baseURL:'http://localhost:3000',
    timeout:5000
})


// Add a request interceptor
//  全局请求拦截，发送请求之前执行
instance.interceptors.request.use(
    function(config) {
      // Do something before request is sent
      config.headers["authorization"] = "Bearer " + getToken();
      return config;
    },
    function(error) {
      // Do something with request error
      return Promise.reject(error);
    }
  );
  
  // Add a response interceptor
  //  请求返回之后执行
  instance.interceptors.response.use(
    function(response) {
      // Any status code that lie within the range of 2xx cause this function to trigger
      // Do something with response data
      return response.data;
    },
    function(error) {
      // Any status codes that falls outside the range of 2xx cause this function to trigger
      // Do something with response error
      return Promise.reject(error);
    }
  );
  

/**
 * get request
 * @param {*} url  request url 
 * @param {*} params  url paramster
 */
export function get(url, params){
    return axios.get(url, {
        params
    })
}

/**
 * post request
 * @param {*} url request url
 * @param {*} data request data
 */
export function post(url, data){
    return axios.post(url, data)
}

/**
 * put request
 * @param {*} url request url 
 * @param {*} data  data
 */
export function put(url, data){
    return axios.put(url, data)
}

/**
 * del request
 * @param {} url request url 
 */
export function del(url){
    return axios.delete(url)
}