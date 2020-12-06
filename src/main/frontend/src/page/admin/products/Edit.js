import React from 'react';
import {Form, Card, Input, Button, message} from 'antd';

function Edit(props) {
    const { getFieldDecorator } = props.form;
    const handleSubmit = e =>{
        console.log(e);
        e.preventDefault();

        props.form.validateFieldsAndScroll((err, values) =>{
            if (!err){
                console.log(values);
                console.log("Submit");
                //call the API
            }else{
                message.error("Please enter the right content");
            }
        });
    };

    return (
       <Card title="Detial Edit">
           <Form onSubmit={e => handleSubmit(e)}>
               <Form.Item label="name">
                   {getFieldDecorator("name",{
                           rules:[
                               {
                                   required:true,
                                   message:"Please enter the name of car"
                               }
                           ]
                       })(<Input placeholder="enter the name"/>)}
                   
               </Form.Item>
               <Form.Item label="Email">
                   {getFieldDecorator("Email",{
                           rules:[
                               {
                                   required:true,
                                   message:"Please enter the Email of car"
                               }
                           ]
                       })(<Input placeholder="enter the Email"/>)}
                   
               </Form.Item>
               <Form.Item>
                   <Button htmlType="submit" type="primary">Save</Button>
               </Form.Item>
           </Form>
       </Card>
    )
}

export default Form.create({ name: "productEdit" })(Edit);
