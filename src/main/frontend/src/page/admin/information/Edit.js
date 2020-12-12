import React, { useState, useEffect } from 'react';
import { Form, Card, Input, Button, message } from 'antd';
import { createApi, getOneById, modifyOne } from '../../../servives/information'

function Edit(props) {
    console.log(props);
    //if props.,atch.patams.id exist, means modify, otherwise is add 

    const { getFieldDecorator } = props.form;
    const [currentData, setCurrentData] = useState({});

    useEffect(() => {
        if (props.match.params.id) {
            getOneById(props.match.params.id)
                .then(res => {
                    console.log(res)
                    setCurrentData(res)
                })
        }
    }, []);



    const handleSubmit = e => {
        console.log(e);
        e.preventDefault();

        props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                console.log(values);
                if (props.match.param.id) {
                    modifyOne(props.match.params.id, values)
                    .then(res => {
                        console.log(res);
                        props.history.push('/admin/information')
                    })
                    .catch(err => {
                        console.log(err);
                    });

                } else {
                    createApi(values)
                        .then(res => {
                            console.log(res);
                            props.history.push('/admin/information')
                        })
                        .catch(err => {
                            console.log(err);
                        });

                }


                // console.log(values);
                // console.log("Submit");
                //call the API
            } else {
                message.error("Please enter the right content");
            }
        });
    };

    return (
        <Card title="Detial Edit">
            <Form onSubmit={e => handleSubmit(e)}>
                <Form.Item label="name">
                    {getFieldDecorator("name", {
                        rules: [
                            {
                                required: true,
                                message: "Please enter the name of car"
                            }
                        ],
                        initialValue: currentData.name
                    })(<Input placeholder="enter the name" />)}

                </Form.Item>
                <Form.Item label="Email">
                    {getFieldDecorator("Email", {
                        rules: [
                            {
                                required: true,
                                message: "Please enter the Email of car"
                            }
                        ],
                        initialValue: currentData.Email
                    })(<Input placeholder="enter the Email" />)}

                </Form.Item>
                <Form.Item>
                    <Button htmlType="submit" type="primary">Save</Button>
                </Form.Item>
            </Form>
        </Card>
    )
}

export default Form.create({ name: "productEdit" })(Edit);
