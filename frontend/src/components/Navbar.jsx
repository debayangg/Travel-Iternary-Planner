import { useState } from 'react'
import { Menu, X } from 'lucide-react'

const styles = `
  .navbar {
    background-color: #333;
    color: white;
    padding-top: 1rem;
    padding-bottom: 1rem;
  }

  .navbar-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0 auto;
  }

  .navbar-logo {
    font-size: 1.5rem;
    font-weight: bold;
    margin-right: auto; 
    padding-left: 1rem;
  }

  .navbar-links {
    display: flex;
    gap: 1rem;
    margin-left: auto; 
    padding-right: 1rem;
  }

  .navbar-links a {
    color: white;
    text-decoration: none;
    transition: color 0.3s ease;
  }

  .navbar-links a:hover {
    color: #ddd;
  }

  .navbar-toggle {
    display: none;
    cursor: pointer;
  }

  @media (max-width: 768px) {
    .navbar-links {
      display: none;
      flex-direction: column;
      position: absolute;
      top: 60px;
      left: 0;
      right: 0;
      background-color: #333;
      padding: 1rem;
    }

    .navbar-links.active {
      display: flex;
    }

    .navbar-toggle {
      display: block;
      padding-right: 1rem;
    }
  }
`

export default function Navbar() {
  const [isOpen, setIsOpen] = useState(false)

  const toggleMenu = () => {
    setIsOpen(!isOpen)
  }

  return (
    <nav className="navbar">
      <div className="navbar-container">
        <div className="navbar-logo">Logo</div>
        <div className={`navbar-links ${isOpen ? 'active' : ''}`}>
          <a href="#home">Home</a>
          <a href="#about">About</a>
          <a href="#services">Services</a>
          <a href="#contact">Contact</a>
        </div>
        <div className="navbar-toggle" onClick={toggleMenu}>
          {isOpen ? <X size={24} /> : <Menu size={24} />}
        </div>
      </div>
      <style jsx>{styles}</style>
    </nav>
  )
}
