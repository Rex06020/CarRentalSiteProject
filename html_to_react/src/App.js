import logo from './logo.svg';
import './App.css';
import Footer from './Footer';
import axios from 'axios';
import { useState } from 'react';


function App() {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [mes, setMes] = useState('');
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/login', {
        username: username,
        password: password
      });

      if (response.data.success) {
        // 成功處理
        window.location.href = 'index';
      } else {
        setMes(response.data.message);
        alert(response.data.message); // 顯示彈出視窗
      }
    } catch (error) {
      console.error('Error:', error);
      setMes('伺服器錯誤');
      alert('伺服器錯誤'); // 顯示彈出視窗
    }
  };

  return (
    <div className="text-muted">
      <header className="bg-dark">
        <nav className="navbar navbar-dark navbar-expand-lg shadow-none">
          <div className="container">
            <a
              className="align-items-center d-inline-flex fw-bold h4 mb-0 navbar-brand text-primary text-uppercase"
              href="index.jsp">
              <svg version="1.0"
                xmlns="http://www.w3.org/2000/svg" xmlnsXlink="http://www.w3.org/1999/xlink"
                viewBox="0 0 100 100" width="2.5em" height="2.5em" className="me-1"
                fill="currentColor">
                <path
                  d="M38.333 80a11.571 11.571 0 0 1-7.646-2.883A11.724 11.724 0 0 1 26.834 70H10V46.667L43.333 40l20-20H90v26.667H43.995l-27.328 5.465v11.2h11.166a11.787 11.787 0 0 1 4.212-4.807 11.563 11.563 0 0 1 12.577 0 11.789 11.789 0 0 1 4.213 4.807h7.833V70h-6.837a11.719 11.719 0 0 1-3.853 7.117A11.571 11.571 0 0 1 38.333 80Zm0-16.667a5 5 0 1 0 5 5 5.006 5.006 0 0 0-5.001-5Zm27.761-36.666L52.762 40h30.571V26.667Z" />
                <path
                  d="M56.667 63.333h-7.833a11.6 11.6 0 0 0-21 0H16.667v-11.2l27.328-5.465h12.672Z"
                  opacity="0.2" />
                <path
                  d="M90 63.333H80v-10h-6.667v10h-10V70h10v10H80V70h10Z" />
                <path d="M52.762 40h30.571V26.667H66.094Z"
                  opacity="0.2" />
              </svg><span>Prime Drive</span></a>
            <button className="navbar-toggler rounded" type="button"
              data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown-2"
              aria-controls="navbarNavDropdown-2" aria-expanded="false"
              aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse " id="navbarNavDropdown-2">
              <ul className="me-auto navbar-nav">
                <li className="nav-item"><a className="nav-link p-lg-3"
                  href="index.jsp">Home</a></li>
                <li className="nav-item"><a className="nav-link p-lg-3" href="#">Offers</a>
                </li>
                <li className="nav-item"><a className="nav-link p-lg-3" href="#">Locations</a>
                </li>
                <li className="nav-item"><a className="nav-link p-lg-3" href="#">Our
                  Fleet</a></li>
                <li className="nav-item"><a className="nav-link p-lg-3" href="#">Support</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <main>
        <section
          className="bg-secondary pb-5 position-relative poster pt-5 text-white-50">
          <div className="container" />
          <div className="row justify-content-center">
            <div className="col-md-6 col-lg-4">
              <div className="mt-5 pt-5 row">
                <div className="login-form">
                {mes && <div className="alert alert-danger">{mes}</div>}
                <form onSubmit={handleSubmit}>
                    <h1 className="display-3 fw-bold mb-4 text-white">
                      <span className="text-primary">Log in</span>
                    </h1>

                    <div className="form-group">
                    <input type="text" className="form-control" name="id" placeholder="Username"
                        required="required"
                        value={username} onChange={(e) => setUsername(e.target.value)} />
                    </div>
                    <div className="form-group">
                    <input type="password" className="form-control" name="paswd" placeholder="password"
                        required="required"
                        value={password} onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <div className="card-group">
                    <button type="submit" name="login" value="login" className="btn btn-primary btn-block">Log in</button>
                    </div>
                    <div className="form-group text-center">
                      New friend?<a href="Signup.jsp">Sign up</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </section>
        <div>
          <Footer />
        </div>
      </main>
    </div>
  );

}

export default App;
