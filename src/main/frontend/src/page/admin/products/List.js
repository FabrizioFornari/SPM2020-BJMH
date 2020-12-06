import { formatCountdown } from 'antd/lib/statistic/utils'
import React from 'react';
import { Card, Table, Button } from 'antd'

function List() {
    const columns =[{
        title:'Number',
        key:'id',
        align:'center'
    },{
        title:'PlateNumber',
        dataIndex:'PlateNumber'
    },{
        title:'Email',
        dataIndex:'Email'
    },{
        title:'Driver',
        dataIndex:'Driver'
    },{
        title:'CarColor',
        dataIndex:'CarColor'
    },{
        title:'PhoneNumber',
        dataIndex:'PhoneNumber'
    },{
        title:'EntryTime',
        dataIndex:'EntryTime'
    },{
        title:'DepartTime',
        dataIndex:'DepartTime'
    },{
        title:'InParking',
        dataIndex:'InParking'
    }]
    return (
        <Card 
        title="Parking List"
            extra={
                <Button type="primary" size="small">
                    Add
                </Button>
            }
        >
            <Table columns={columns} bordered/>
            </Card>
            )
        }

            export default List;
