import { useState } from 'react'
import './App.css'
import Signup from './components/Signup'
import Login from './components/Login'
import Home from './components/Home'
import { BrowserRouter,Routes, Route } from 'react-router-dom';
import View from './components/view'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <BrowserRouter>
        <Routes>
        <Route path="/" element={<Home/>}></Route>
          <Route path="/signup" element={<Signup/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/view" element={<View/>}></Route>
        </Routes>
      </BrowserRouter>

    </div>
  )
}

export default App
