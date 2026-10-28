import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [loginForm, setLoginForm] = useState({
    empid: '',
    password: ''
  });

  const navigate = useNavigate();

  function changeHandler(event) {
    setLoginForm((prevData) => {
      return {
        ...prevData,
        [event.target.name]:
          event.target.type === 'checkbox'
            ? event.target.checked
            : event.target.value,
      };
    });
  }

  async function submitHandler(e) {
    e.preventDefault();

    try {
      const params = new URLSearchParams({
        empid: loginForm.empid,
        password: loginForm.password,
      });

      const server = await fetch(
        'http://localhost:8080/v1/user/login',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          },
          body: params.toString(),
        }
      );

      const responseText = await server.text();
      console.log(responseText);

      if (!server.ok) {
        alert(`Error ${server.status}: ${responseText}`);
        return;
      }

      if (
        responseText.trim().toLowerCase() ===
        'employee is logged in'
      ) {
       navigate('/dashboard', {
       state: {
        empid: loginForm.empid
      }
   });
    } else {
       alert('Invalid employee ID or password');
  }
    } catch (error) {
      console.error('Login error:', error);
      alert('Unable to connect to the server.');
    }
  }

  return (
    <div className="container mt-5">
      <form onSubmit={submitHandler}>
        <div className="form-group mb-3">
          <label htmlFor="empid">Employee ID</label>
          <input
            type="number"
            className="form-control"
            id="empid"
            name="empid"
            value={loginForm.empid}
            onChange={changeHandler}
            placeholder="Enter employee ID"
            required
          />
        </div>

        <div className="form-group mb-3">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            className="form-control"
            id="password"
            name="password"
            value={loginForm.password}
            onChange={changeHandler}
            placeholder="Enter password"
            required
          />
        </div>

        <div className="form-group form-check mb-3">
          <input
            type="checkbox"
            className="form-check-input"
            id="exampleCheck1"
          />
          <label
            className="form-check-label"
            htmlFor="exampleCheck1"
          >
            Check me out
          </label>
        </div>

        <button type="submit" className="btn btn-primary">
          Login
        </button>
      </form>
    </div>
  );
}

export default Login;
