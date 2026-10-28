
import React from 'react';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Home.css';

function Home() {
  const navigate = useNavigate();

  const today = new Date();

  const formattedDate = today.toLocaleDateString('en-IN', {
    weekday: 'long',
    day: 'numeric',
    month: 'long',
    year: 'numeric',
  });

  const features = [
    {
      icon: '📊',
      title: 'Dashboard',
      description: 'View attendance records and your attendance summary.',
      button: 'Open Dashboard',
      path: '/dashboard',
      color: 'blue',
    },
    {
      icon: '🕒',
      title: 'Attendance',
      description: 'Review your check-in, check-out and attendance history.',
      button: 'View Attendance',
      path: '/dashboard',
      color: 'green',
    },
    {
      icon: '👤',
      title: 'Employee Profile',
      description: 'Access your employee workspace and account details.',
      button: 'View Profile',
      path: '/profile',
      color: 'purple',
    },
  ];

  function handleLogout() {
    navigate('/login');
  }

  return (
    <div className="home-page">
      <nav className="home-navbar">
        <div className="home-brand">
          <span className="home-brand-icon">▦</span>
          <span>HRMS</span>
          <span className="home-brand-label">EMPLOYEE PORTAL</span>
        </div>

        <div className="home-nav-right">
          <span className="home-online-dot"></span>
          <span className="home-online-text">System Online</span>
          <button
            className="home-logout-btn"
            onClick={handleLogout}
            type="button"
          >
            Logout ↗
          </button>
        </div>
      </nav>

      <main className="home-main">
        <section className="home-hero">
          <div className="home-hero-content">
            <span className="home-welcome-tag">
              ✨ YOUR WORKSPACE
            </span>

            <h1>
              Welcome back!
              <br />
              <span>Your workday starts here.</span>
            </h1>

            <p>
              Manage your attendance, explore your dashboard,
              and access your employee workspace from one place.
            </p>

            <button
              className="home-primary-btn"
              onClick={() => navigate('/dashboard')}
              type="button"
            >
              Go to Dashboard <span>→</span>
            </button>
          </div>

          <div className="home-hero-visual" aria-hidden="true">
            <div className="home-orbit home-orbit-one"></div>
            <div className="home-orbit home-orbit-two"></div>
            <div className="home-visual-card">
              <div className="home-visual-icon">✓</div>
              <span>EMPLOYEE WORKSPACE</span>
              <strong>Everything in one place.</strong>
              <div className="home-visual-line"></div>
              <div className="home-visual-line short"></div>
              <div className="home-visual-footer">
                <span className="home-visual-dot"></span>
                HRMS Portal
                <span>●</span>
              </div>
            </div>
          </div>
        </section>

        <section className="home-date-row">
          <div>
            <span className="home-section-eyebrow">YOUR WORKSPACE</span>
            <h2>Quick Access</h2>
            <p>Choose a section to get started.</p>
          </div>

          <div className="home-date-card">
            <span className="home-calendar-icon">▦</span>
            <div>
              <strong>{formattedDate}</strong>
              <span>Have a productive day!</span>
            </div>
          </div>
        </section>

        <section className="home-feature-grid">
          {features.map((feature) => (
            <article
              className="home-feature-card"
              key={feature.title}
            >
              <div className={`home-feature-icon ${feature.color}`}>
                {feature.icon}
              </div>

              <h3>{feature.title}</h3>

              <p>{feature.description}</p>

              <button
                type="button"
                className="home-feature-btn"
                onClick={() => navigate(feature.path)}
              >
                {feature.button}
                <span>→</span>
              </button>
            </article>
          ))}
        </section>

        <section className="home-info-banner">
          <div className="home-info-icon">ⓘ</div>
          <div>
            <h3>Welcome to your HRMS portal</h3>
            <p>
              Your employee workspace provides quick access to
              attendance information and employee services.
            </p>
          </div>
        </section>

        <footer className="home-footer">
          <span>HRMS · Employee Management System</span>
          <span>Built for a better workday.</span>
        </footer>
      </main>
    </div>
  );
}

export default Home;
