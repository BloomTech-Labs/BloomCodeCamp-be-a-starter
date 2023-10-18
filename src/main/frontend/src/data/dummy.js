import React from 'react';
import {FiCreditCard } from 'react-icons/fi';
import { BsCurrencyDollar, BsShield, BsClipboardCheck } from 'react-icons/bs';
import { HiOutlineHomeModern } from 'react-icons/hi2';

export const links = [
  {
    title: 'Dashboard',
    links: [
      {
        name: 'Home',
        icon: <HiOutlineHomeModern/>,
      },
      {
        name: 'Submission',
        icon: <BsClipboardCheck />,
      },
    ],
  },

];

export const links2 = [
  { links2: [
    {
      name: 'Submit'
    },
    {
      name: 'Return'
    },
  ]
  }
];


export const userProfileData = [
  {
    icon: <BsCurrencyDollar />,
    title: 'My Profile',
    desc: 'Account Settings',
    iconColor: '#03C9D7',
    iconBg: '#E5FAFB',
  },
  {
    icon: <BsShield />,
    title: 'My Inbox',
    desc: 'Messages & Emails',
    iconColor: 'rgb(0, 194, 146)',
    iconBg: 'rgb(235, 250, 242)',
  },
  {
    icon: <FiCreditCard />,
    title: 'My Tasks',
    desc: 'To-do and Daily Tasks',
    iconColor: 'rgb(255, 244, 229)',
    iconBg: 'rgb(254, 201, 15)',
  },
];
///////////////////////////////////////////////////////////////////////////////////////
export const assignmentsGrid = [
  { field: 'Date',
    headerText: 'Date',
    width: '150',
    textAlign: 'Center',
  },
  {
    field: 'Assignment',
    headerText: 'Assignment',
    width: '150',
    editType: 'dropdownedit',
    textAlign: 'Center',
  },
  
  {
    field: 'Status',
    headerText: 'Status',
    format: 'C2',
    background: 'rounded',
    textAlign: 'Center',
    editType: 'numericedit',
    width: '150',
  },
  {
    field: 'Grade',
    headerText: 'Grade',
    width: '120',
    textAlign: 'Center',
  },

];


/////////////////////////////////////////////////////////////
export const assignmentData = [
  {
    Date: '10-05-2023',
    Assignment: 'Java Basics',
    Status: 'Submitted',
    StatusBg: '#FEC90F',
    Grade: 'A-'
  },
  {
    Date: '10-03-2023',
    Assignment: 'AI Discovery Journey',
    Status: 'In Review',
    Grade: 'A-'
  },
  {
    Date: '9-13-2023',
    Assignment: 'Just Keep Coding',
    Status: 'In Review',
    Grade: 'A-'
  },
  {
    Date: '9-12-2023',
    Assignment: 'Algo Practice',
    Status: 'Completed',
    Grade: 'A'
  },
  {
    Date: '9-05-2023',
    Assignment: 'The Core',
    Status: 'Completed',
    Grade: 'B-'
  },
  {
    Date: '8-27-2023',
    Assignment: 'Unit 1 Test',
    Status: 'Completed',
    Grade: 'A'
  },
  {
    Date: '8-23-2023',
    Assignment: 'Syntax and More',
    Status: 'Completed',
    Grade: 'C'
  },
  {
    Date: '8-14-2023',
    Assignment: 'Why We Code',
    Status: 'Completed',
    Grade: 'A'
  },
  {
    Date: '8-8-2023',
    Assignment: 'Syllabus',
    Status: 'Completed',
    Grade: 'A'
  },
];


