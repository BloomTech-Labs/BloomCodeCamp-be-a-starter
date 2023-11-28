import React from 'react'

const DashboardHeader = ({ title}) => {
  return (
    <div className='mb-10'>
          <p className='text-3xl  font-extrabold tracking-tight text-gray-100'> {title}
          </p>
      </div>
  )
}

export default DashboardHeader