import { formatCountdown } from 'antd/lib/statistic/utils'
import React from 'react';
import { Card, Table, Button, Popconfirm } from 'antd'
import renderEmpty from 'antd/lib/config-provider/renderEmpty';



const dataSource = [{
    id: 1,
    PlateNumber: 'Ay757',
    Email: 'haoran.sun@studenti.unicam.it',
    Driver: 'Sun HaoRan',
    CarColor: 'Red',
    PhoneNumber: '+393778489449',
    EntryTime: '12:00 06/12/2020',
    DepartTime: '13:00 06/12/2020',
    InParking: 'No'

}, {
    PlateNumber: 'Ay757',
    Email: 'haoran.sun@studenti.unicam.it',
    Driver: 'Sun HaoRan',
    CarColor: 'Red',
    PhoneNumber: '+393778489449',
    EntryTime: '12:00 06/12/2020',
    DepartTime: '13:00 06/12/2020',
    InParking: 'No'

}]

function List(props) {
    const columns = [{
        title: 'Number',
        key: 'id',
        align: 'center',
        render: (txt, record, index) => index + 1
    }, {
        title: 'PlateNumber',
        dataIndex: 'PlateNumber'
    }, {
        title: 'Email',
        dataIndex: 'Email'
    }, {
        title: 'Driver',
        dataIndex: 'Driver'
    }, {
        title: 'CarColor',
        dataIndex: 'CarColor'
    }, {
        title: 'PhoneNumber',
        dataIndex: 'PhoneNumber'
    }, {
        title: 'EntryTime',
        dataIndex: 'EntryTime'
    }, {
        title: 'DepartTime',
        dataIndex: 'DepartTime'
    }, {
        title: 'InParking',
        dataIndex: 'InParking'
    }, {
        title: 'Operation',
        render: (txt, record, index) => {
            return (
                <div>
                    <Button style={{ margin: "0 1rem" }} type="primary" size="small">Edit</Button>
                    <Popconfirm
                        title="Do you want delete it?"
                        onCancel={() => console.log('Cancel Delete')}
                        onConfirm={() => console.log('Confirm Delete')}
                    // Call Api here for related operations
                    >
                        <Button style={{ margin: "0 1rem" }} type="danger" size="small">Delete</Button>
                    </Popconfirm>
                </div>
            )
        }
    }]
    return (
        <Card
            title="Parking List"
            extra={
                <Button 
                type="primary"
                size="small"
                onClick={() => props.history.push("/admin/products/Edit")}
                >
                    Add
                </Button>
            }
        >
            <Table columns={columns} bordered dataSource={dataSource} />
        </Card>
    )
}

export default List;