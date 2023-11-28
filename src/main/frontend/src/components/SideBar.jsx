import React from 'react'
import { Link, NavLink} from 'react-router-dom';
import { GiSchoolBag } from 'react-icons/gi';
import { GiCancel } from 'react-icons/gi';
import { TooltipComponent } from '@syncfusion/ej2-react-popups';
import { links } from '../data/dummy';

import { UseStateContext } from '../contexts/ContextProvider';




const SideBar = () => {
  const {activeMenu, setactiveMenu, screenSize} = UseStateContext();

  const handleClosedSideBar = () => {
     if(activeMenu && screenSize <= 900) {
      setactiveMenu(false);
      }
    }
  
  const activeLink = 'flex items-center gap-5 pl-4 pt-3 pb-1 rounded-md text-white text-md m-2';
  const normalLink = 'flex items-center gap-5 pl-4 pt-3 pb-3 rounded-lg text-white text-md text-gray-600 dark:text-gray-300 dark:hover:text-black hover:bg-lightgray m-2'; 
  
  return (
    <div className='bg-gradient-to-r from-green-400 to-orange-200 rounded-3xl ml-3 h-screen 
    md:overflow-hidden overflow-auto 
    md:hover:overflow-auto pb-10'>
      {activeMenu &&  (<>
      <div className=' flex justify-between items-center'>
        <Link to='/' onClick={() => {handleClosedSideBar}} className='items-center gap-3 ml-3 mt-4
         flex text-xl font-semibold tracking-tight dark:text-white text-gray-50'>
          <GiSchoolBag className='text-gray-50 text-3xl' /> <span>Learner Dashboard</span>
        </Link>
        <TooltipComponent content='Menu' position='BottomCenter'>
            <button type='button' onClick={() => setactiveMenu((prevActiveMenu) => !prevActiveMenu)}
            className='text-xl text-gray-50 rounded-full p-3 mt-4 block'>
              <GiCancel/>
            </button>
        </TooltipComponent>
        </div>
           <div className='mt-10'>
              {links.map((item) => (
                  <div key={item.title}>
                    <p className=' text-gray-100 m-3 mt-4 uppercase'>
                       {item.title}
                    </p>
                    {item.links.map((link) => (
                      <NavLink 
                      to={`/${link.name}`} 
                      key={link.name} 
                      onClick={() => {handleClosedSideBar}}
                      className='flex italic ml-6 xl-3 mt-3 '
                       >
                        <span className='capitalize hover:rounded-full text-gray-100 hover:p-1 hover:drop-shadow ml-2 mb-3 hover:text-xl rounded-full justify-center'>
                        {link.icon}
                        </span>
                        <span className='capitalize hover:rounded-full text-gray-100 hover:p-1 hover:drop-shadow ml-2 mb-3 hover:text-xl rounded-full justify-center'>
                        {link.name}
                        </span>
                      </NavLink>
                    ))}
                  </div>
              ))}
            </div> 
        </>)}
      </div>
  )
}

export default SideBar