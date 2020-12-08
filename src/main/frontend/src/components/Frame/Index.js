import React from 'react'
import { withRouter } from "react-router-dom";
import {
  Layout,
  Menu,
  Breadcrumb,
  Dropdown,
  Avatar,
  message,
  Badge,
  Button,
  Icon,
} from 'antd';
import { AreaChartOutlined } from '@ant-design/icons';
//import { connect } from "react-redux";
//import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons';
import logo from './parkinglogo.png';
import { adminRoutes } from "../../routes/routesfile";
import './frame.css'
import { clearToken } from '../../utils/auth'
// import { adminRoutes } from "../../routes/routesfile.js"


const routes = adminRoutes.filter(route => route.isShow)



const { SubMenu } = Menu;
const { Header, Content, Sider } = Layout;

function Index(props) {

  const popMenu = (<Menu onClick={(p)=>{
    if(p.key=='logout'){
      clearToken();
      props.history.push()
    }else{
      message.info(p.key);
    }
  }}>
    <Menu.Item key="notice">Notice</Menu.Item>
    <Menu.Item key="setting">Setting</Menu.Item>
    <Menu.Item key="logout">Logout</Menu.Item>
  </Menu>)

  return (
    <Layout>
      <Header className="header">
        <div className="logo" >
          <img src={logo} alt="logo" />
        </div>

        <Dropdown overlay={popMenu}>
          <div>
            <Avatar>U</Avatar>
            <span>Super admin</span>
            <Icon type="dwon" />
          </div>
        </Dropdown>


        {/* <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
            <Menu.Item key="1">nav 1</Menu.Item>
            <Menu.Item key="2">nav 2</Menu.Item>
            <Menu.Item key="3">nav 3</Menu.Item>
          </Menu> */}
      </Header>
      <Layout>
        <Sider width={200} className="site-layout-background">
          <Menu
            mode="inline"
            defaultSelectedKeys={['1']}
            defaultOpenKeys={['sub1']}
            style={{ height: '100%', borderRight: 0 }}
          >




            {routes.map(route => {
              return (
                <Menu.Item
                  key={route.path} onClick={p => props.history.push(p.key)}>

                  {/* <Icon type={route.icon}/> */}
                  {/* <AreaChartOutlined /> */}

                  {route.title}
                </Menu.Item>

              );
            })}
            {/* <SubMenu key="sub1" icon={<UserOutlined />} title="subnav 1">
                <Menu.Item key="1">option1</Menu.Item>
                <Menu.Item key="2">option2</Menu.Item>
                <Menu.Item key="3">option3</Menu.Item>
                <Menu.Item key="4">option4</Menu.Item>
              </SubMenu>
              <SubMenu key="sub2" icon={<LaptopOutlined />} title="subnav 2">
                <Menu.Item key="5">option5</Menu.Item>
                <Menu.Item key="6">option6</Menu.Item>
                <Menu.Item key="7">option7</Menu.Item>
                <Menu.Item key="8">option8</Menu.Item>
              </SubMenu>
              <SubMenu key="sub3" icon={<NotificationOutlined />} title="subnav 3">
                <Menu.Item key="9">option9</Menu.Item>
                <Menu.Item key="10">option10</Menu.Item>
                <Menu.Item key="11">option11</Menu.Item>
                <Menu.Item key="12">option12</Menu.Item>
              </SubMenu> */}
          </Menu>
        </Sider>
        <Layout style={{ padding: "16px" }}>
          <Breadcrumb style={{ margin: "16px 0" }}>
            <Breadcrumb.Item>Home</Breadcrumb.Item>
            <Breadcrumb.Item>List</Breadcrumb.Item>
            <Breadcrumb.Item>App</Breadcrumb.Item>
          </Breadcrumb>
          <Content
            style={{
              background: "#fff",
              margin: 0,
              minHeight: 280
            }}
          >
            {props.children}
          </Content>
        </Layout>
      </Layout>
    </Layout>
  )
}

export default withRouter(Index)
