import React, {useEffect} from 'react'
import { AiOutlineMenu } from 'react-icons/ai'
import { BsChatLeft } from 'react-icons/bs'
import { RiNotification3Line } from 'react-icons/ri'
import { MdKeyboardArrowDown } from 'react-icons/md'
import { TooltipComponent } from '@syncfusion/ej2-react-popups'
import { LiaUserCircle} from 'react-icons/lia'

import { Chat, Notifications, UserProfile} from '.';
import { UseStateContext} from '../contexts/ContextProvider'

const NavBar = () => {
  const { activeMenu, setactiveMenu, isClicked, setIsClicked, handleClick, screenSize, setScreenSize} = UseStateContext();

  useEffect(() => {
    const handleResize = () => setScreenSize(window.innerWidth);
    
    window.addEventListener('resize', handleResize)
    handleResize();

    return () => window.removeEventListener('resize', handleResize)
  }, []);

  useEffect(() => {
    if(screenSize <= 900) {
      setactiveMenu(false);
    } else {
      setactiveMenu(true);
    }
    }, [screenSize]);

  const NavButton = ({ title, customFunc, icon, color, dotColor}) => (
    <TooltipComponent content={title} position='BottomCenter'>
      <button type='button' onClick={customFunc} style={{color}}
      className='relative rounded-full p-3 hover:bg-light-gray'>
        <span style={{background: dotColor}} className='absolute inline-flex rounded-full h-2 w-2 right-2 top-2'/>
          {icon}
      </button>
    </TooltipComponent>
  )
  return (
    <div className='flex text-4xl justify-between p-2 md:mx-6 relative'>
      <NavButton title='Menu' customFunc={() => setactiveMenu((prevActiveMenu) =>
         !prevActiveMenu)} color='green' icon={<AiOutlineMenu/>}/>
      <div className='flex'>
        <NavButton title='Chats (2)' 
        dotColor='#ff0000'
        customFunc={() => handleClick('Chat')} 
        color='green' icon={<BsChatLeft/>}/>

        <NavButton title='Notifications' 
        customFunc={() => handleClick('Notifications')} 
        color='green' icon={<RiNotification3Line/>}/>

        <TooltipComponent content='Kevin A.' position='BottomCenter'>
          <div className='flex text-xl items-center gap-2 cursor-pointer p-1 hover:bg-light-gray rounded-lg' onClick={() => handleClick('UserProfile')}>
              <LiaUserCircle className='mt-1'/>
              <MdKeyboardArrowDown className='text-gray-400 text-14'/>
          </div>
        </TooltipComponent> 
      </div>
      </div>
  )
}

export default NavBar