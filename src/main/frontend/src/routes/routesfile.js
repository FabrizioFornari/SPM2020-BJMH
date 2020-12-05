import List from "../page/admin/products/List";
// import Index from "../page/admin/dashboard/mainboard";
import Edit from "../page/admin/products/Edit";
import Login from "../page/Login";
import PageNotFound from "../page/PageNotFound";
import mainboard from "../page/admin/dashboard/mainboard";

export const mainRoutes = [
    {
        path: "/login",
        component: Login
    },
    {
        path: "/404",
        component: PageNotFound
    }];


export const adminRoute = [{
    path: "/admin/dashboard",
    component: mainboard
},
{
    path: "/admin/products",
    component: List,
    exact: true

},
{
    path: "/admin/products/edit/:id",
    component: Edit
}];
