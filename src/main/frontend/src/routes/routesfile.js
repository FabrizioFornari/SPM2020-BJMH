import List from "../page/admin/information/List";
import Edit from "../page/admin/information/Edit";
import Login from "../page/Login";
import PageNotFound from "../page/PageNotFound";
import mainboard from "../page/admin/dashboard/mainboard";

//import Index from "../pages/admin/dashboard/mainboard";

export const mainRoutes = [
    {
        path: "/login",
        component: Login
    },
    {
        path: "/404",
        component: PageNotFound
    }];


export const adminRoutes = [
    {
        path: "/admin/dashboard",
        component: mainboard,
        isShow: true,
        title: "Dashboard"
},
{
    path: "/admin/products",
    component: List,
    isShow:true,
    title:'Management',
    exact: true

},
{
    path: "/admin/products/edit/:id?",
    isShow:false,
    component: Edit
}];
