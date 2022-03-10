import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import "./style.css";

function NavBar() {

  return(
    <header>
      <nav className='container'>
        <div className='dsmovie-nav-content'>
          <h1>DSMovies</h1>
          <a href="https://github.com/IsmaelBernardes">
            <div className="dsmovie-contact-container">
              <GithubIcon/>
              <p className="dsmovie-contact-link">/ismaelBernardes</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  )
}

export default NavBar;