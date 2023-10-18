import React from 'react'
import { GridComponent, ColumnDirective, 
  ColumnsDirective, Resize, Sort, ContextMenu, Filter, Page,
   ExcelExport, PdfExport, Edit, Inject } from '@syncfusion/ej2-react-grids';

import { assignmentData, ContextMenuItems, assignmentsGrid } from '../data/dummy';
import {DashboardHeader} from '../components';

const Learner = () => {
  return (
    <div className='m-3 md:m-10 p-2 md:p-10 bg-gradient-to-r from-green-400 to-orange-100 rounded-3xl'>
      <DashboardHeader title='Assignments'/>
      <GridComponent className='rounded-sm' id='gridComp' dataSource={assignmentData}>
        <ColumnsDirective className='rounded-sm'>
          {assignmentsGrid.map((item, index) => ( 
          <ColumnDirective className='rounded-sm' key={index} {...item}/>
          ))}
        </ColumnsDirective>
      </GridComponent>
    </div>
      
  )
}

export default Learner