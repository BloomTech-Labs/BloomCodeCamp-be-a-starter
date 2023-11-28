import React from 'react'
import { DashboardHeader } from '../components'


const Submission = () => {
  
  
  return (
    <div className='m-3 justify-center md:m-10 p-2 md:p-10 bg-gradient-to-r from-green-400 to-orange-100 rounded-3xl'>
        <DashboardHeader title='Submit An Assignment'/>
      <form className='shadown-md bg-gradient-to-r from-green-400 to-orange-100 rounded px-8 pt-6 pb-8 mb-4'>
        <div className='mb-5'>
          <label htmlFor='' className='block text-xl mb-2'>
            GitHub Url
          </label>
          <input type="text" className="shadow appearance-none border rounded w-full py-2 px-3" placeholder="Github"/>
        </div>
        <div className='mb-5'>
          <label htmlFor='' className='block text-xl mb-2'>
            Branch
          </label>
          <input type="text" className="shadow appearance-none border rounded w-full py-2 px-3" placeholder="GitHub Branch"/>
        </div>
        <div className='flex justify-center'>
          
          <button className='m-4 border rounded-full p-3 bg-orange-50 hover:drop-shadow-md'> Submit</button>
          <button className='m-4 border rounded-full p-3 bg-orange-50 hover:drop-shadow-md'> Return</button>
        </div>
      </form>
    </div>
  )
}

export default Submission