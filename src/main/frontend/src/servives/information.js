import { get, post, put, del } from "../utils/request";

/**
 * get list
 * @param {*} page
 */
export function listApi(page = 1) {
  return get("/api/v1/admin/products", { page, per: 2 });
}

/**
 * create the  data
 * @param {*} data
 */
export function createApi(data) {
  return post("/api/v1/admin/products", data);
}

/**
 * get the data dependent id
 * @param {*} id
 */
export function getOneById(id) {
  return get(`/api/v1/admin/products/${id}`);
}

/**
 * modify history
 * @param {*} id
 * @param {*} data
 */
export function modifyOne(id, data) {
  return put(`/api/v1/admin/products/${id}`, data);
}

/**
 * delete the record
 * @param {*} id
 * @param {*} data
 */
export function delOne(id, data) {
  return del(`/api/v1/admin/products/${id}`);
}