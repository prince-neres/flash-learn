import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './styles/global.css'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <div className='h-screen w-screen bg-gray-700 flex justify-center items-center'>
      <h1 className='text-white text-8xl font-bold'>
        Flash Learn
      </h1>
    </div>
  </StrictMode>,
)
