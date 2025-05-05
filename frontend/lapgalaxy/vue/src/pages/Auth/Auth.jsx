import React from 'react'
import { Outlet } from 'react-router'

const Auth = () => {
  return (
    <div>
      Auth page

      <Outlet />
    </div>
  )
}

export default Auth
