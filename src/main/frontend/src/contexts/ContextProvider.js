import React, { createContext, useContext, useState} from 'react';

const StateContext = createContext();

const initialState = {
    userProfile: false
}

export const ContextProvider = ({ children}) => {
    const [activeMenu, setactiveMenu] = useState(true);
    const [isClicked, setIsClicked] = useState(initialState);
    const [screenSize, setScreenSize] = useState(undefined);

    const handleClick = (clicked) => {
        setIsClicked({ ...initialState, [clicked]: true});
    }
    
    
    return (
        <StateContext.Provider 
            value={{ activeMenu,
            setactiveMenu,
            isClicked, 
            setIsClicked,
            handleClick,
            screenSize,
            setScreenSize,
        }}
        >
            {children}
        </StateContext.Provider>    
    )
}

export const UseStateContext = () => useContext(StateContext);