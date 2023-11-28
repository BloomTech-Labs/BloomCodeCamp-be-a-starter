import React from 'react'
import { DashboardHeader } from '../components'
import { DiJava} from 'react-icons/di'


const HomePage = () => {
  return (
    <div className='ml-3 h-full text-center md:m-10 p-2 md:p-10 bg-gradient-to-l from-green-400 to-orange-200 rounded-3xl'>
    <DashboardHeader title='Welcome to the Assignment Review App'/>
    <div>
      <img className='rounded-3xl' src={require ('/Users/dominic/Desktop/reviewer-page/src/pages/students2.jpg')}/>
    </div>
    <div className='p-4 mt-2 text-3xl text-gray-50'>
      <p>
        Use the SideBar to navigate around, Happy Coding!
      </p>
    </div>
    
</div>
  )
}

export default HomePage