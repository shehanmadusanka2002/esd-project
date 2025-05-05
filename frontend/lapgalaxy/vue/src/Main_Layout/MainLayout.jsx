import { BrowserRouter, Routes, Route } from "react-router";
import Navbar from './../components/Navbar/Navbar';
import Home from "../pages/Home/Home";
import Auth from "../pages/Auth/Auth";
import Login from "../pages/Auth/Login/Login";
import Register from "../pages/Auth/Register/Register";
import Error from "../pages/Error/Error";

const MainLayout = () => { 
  return (
    <BrowserRouter>
    {/*navbar*/}
    <Navbar />
    <Routes>
      <Route path="/" element={<Home />}/>
      <Route path="auth" element={<Auth />}>
          <Route path="login" element={<Login />}/>
          <Route path="register" element={<Register />}/>
      </Route>
      {/* page not found */}
      <Route path="*" element={<Error />}/>    
    </Routes>
    </BrowserRouter>

    
)}

export default MainLayout
