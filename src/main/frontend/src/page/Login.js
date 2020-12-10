import React from 'react';
import { Form, Icon, Input, Button, Checkbox, Card, Message, message } from 'antd';
import { setToken } from "../utils/auth";
import { loginApi } from '../servives/auth'
import './login.css'
import FormItem from 'antd/lib/form/FormItem';

function Login(props) {
  const { getFieldDecorator } = props.form;
  const handleSubmit = e => {
    e.preventDefault();
    props.form.validateFields((err, values) => {
      if (!err) {
        console.log("Received values of form:", values);
        setToken(values.username);
        props.history.push('/admin');
      }
      // if (!err) {
      //   console.log('Received values of form: ', values);
      //   loginApi({
      //     username: values.username,
      //     password: values.password
      //   })
      //     .then(res => {
      //       if (res.code == "success") {
      //         setToken(res.token);
      //         props.history.push("/admin");
      //       } else {
      //         message.info(res.message);
      //       }

      //       // console.log(res);
      //     })
      //     .catch(err => {
      //       // console.log(err);
      //       message.error("Account No Exist");
      //     })

      // }
    });

  }
  return (
    <Card title="Smart Parking Admin System" className="login-form">
      <Form onSubmit={(e) => handleSubmit(e)} >
        <Form.Item>
          {getFieldDecorator('username', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(
            <Input
              prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
              placeholder="Username"
            />,
          )}
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('password', {
            rules: [{ required: true, message: 'Please input your Password!' }],
          })(
            <Input
              prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
              type="password"
              placeholder="Password"
            />,
          )}
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit" className="login-form-button">
            Log in
          </Button>
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(<Checkbox>Remember me</Checkbox>)}
          <a className="login-form-forgot" href="">
            Forgot password
          </a>

        </Form.Item>
        <Form.Item>
          Don't have the account? <a href="">register now!</a>
        </Form.Item>
        <Form.Item>
          @SPM2020-BJMH
        </Form.Item>

      </Form>
    </Card>
  )
}

export default Form.create({ name: "loginForm" })(Login);