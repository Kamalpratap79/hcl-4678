import React, { useEffect, useMemo, useState } from 'react';
import { useLocation } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Dashboard.css';

const API_URL = 'http://localhost:8080/v1/user/attendance/employee';

function formatDate(value) {
  if (!value) return '--';

  // Avoid timezone shifts for YYYY-MM-DD values.
  const date = /^\d{4}-\d{2}-\d{2}$/.test(value)
    ? new Date(`${value}T00:00:00`)
    : new Date(value);

  return Number.isNaN(date.getTime())
    ? value
    : date.toLocaleDateString('en-IN', {
        day: '2-digit',
        month: 'short',
        year: 'numeric',
      });
}

function formatTime(value) {
  if (!value) return '--';

  const date = new Date(value);

  return Number.isNaN(date.getTime())
    ? value
    : date.toLocaleTimeString('en-IN', {
        hour: '2-digit',
        minute: '2-digit',
        hour12: true,
      });
}

function Dashboard() {
  const [attendance, setAttendance] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [search, setSearch] = useState('');
  const [statusFilter, setStatusFilter] = useState('all');

  // Use the employee ID of the logged-in user here.
  const location = useLocation();
  const empid = location.state?.empid;

  useEffect(() => {
    async function fetchAttendance() {
      try {
        setLoading(true);
        setError('');

        if (!empid) {
                    throw new Error('Employee ID missing. Please log in again.');
        }

  const response = await fetch(`${API_URL}/${empid}`);

        if (!response.ok) {
          throw new Error(`Unable to load attendance (${response.status})`);
        }

        const data = await response.json();

        if (!Array.isArray(data)) {
          throw new Error('Expected an array of attendance records.');
        }

        setAttendance(data);
      } catch (err) {
        setError(
          `${err.message}. Check your Spring Boot attendance GET endpoint.`
        );
      } finally {
        setLoading(false);
      }
    }

    fetchAttendance();
  }, [empid]);

  const employeeAttendance = useMemo(
    () =>
      attendance.filter(
        (record) => Number(record.employee?.empid) === Number(empid)
      ),
    [attendance]
  );

  const today = new Date();
  const todayString = [
    today.getFullYear(),
    String(today.getMonth() + 1).padStart(2, '0'),
    String(today.getDate()).padStart(2, '0'),
  ].join('-');

  const todayRecord = employeeAttendance.find((record) => {
    const recordDate =
      record.attendancedate ||
      (record.inTime ? record.inTime.slice(0, 10) : '');

    return recordDate === todayString;
  });

  const presentDays = employeeAttendance.filter(
    (record) => Boolean(record.inTime)
  ).length;

  const completedDays = employeeAttendance.filter(
    (record) => Boolean(record.inTime && record.outTime)
  ).length;

  const filteredAttendance = useMemo(() => {
    return employeeAttendance
      .filter((record) => {
        const searchableText = [
          record.attendanceId,
          record.employee?.empid,
          record.attendancedate,
          record.inTime,
          record.outTime,
          record.comment,
        ]
          .join(' ')
          .toLowerCase();

        const matchesSearch = searchableText.includes(
          search.toLowerCase()
        );

        const matchesStatus =
          statusFilter === 'all' ||
          (statusFilter === 'completed' &&
            record.inTime &&
            record.outTime) ||
          (statusFilter === 'inprogress' &&
            record.inTime &&
            !record.outTime) ||
          (statusFilter === 'noentry' && !record.inTime);

        return matchesSearch && matchesStatus;
      })
      .sort((a, b) => {
        const dateA = a.attendancedate || a.inTime || '';
        const dateB = b.attendancedate || b.inTime || '';
        return dateB.localeCompare(dateA);
      });
  }, [employeeAttendance, search, statusFilter]);

  return (
    <div className="hrms-app">
      <header className="topbar">
        <div className="brand">
          <span className="brand-icon">▦</span>
          <span>HRMS</span>
        </div>

        <div className="topbar-right">
          <span className="online-dot" />
          <span>Employee Portal</span>
          <div className="avatar">E</div>
          <span>Employee #{empid}</span>
        </div>
      </header>

      <div className="dashboard-layout">
        <aside className="sidebar">
          <div className="sidebar-label">WORKSPACE</div>

          <div className="nav-item active">
            <span className="nav-icon">▦</span>
            Dashboard
          </div>

          <div className="nav-item">
            <span className="nav-icon">◷</span>
            Attendance
          </div>

          <div className="nav-item">
            <span className="nav-icon">♙</span>
            Employee Profile
          </div>

          <div className="sidebar-bottom">
            <div className="help-card">
              <div className="help-icon">?</div>
              <strong>Need help?</strong>
              <p>Contact your HR administrator for attendance issues.</p>
            </div>
          </div>
        </aside>

        <main className="main-content">
          <div className="welcome-row">
            <div>
              <div className="eyebrow">EMPLOYEE WORKSPACE</div>
              <h1>Welcome to your Dashboard!</h1>
              <p className="muted">
                Monitor your attendance and working hours.
              </p>
            </div>

            <div className="date-display">
              <strong>
                {today.toLocaleDateString('en-IN', {
                  weekday: 'short',
                  day: '2-digit',
                  month: 'short',
                  year: 'numeric',
                })}
              </strong>
              <span>Employee ID: {empid}</span>
            </div>
          </div>

          {error && (
            <div className="api-notice">
              {error}
            </div>
          )}

          <section className="stats-grid">
            <div className="stat-card blue">
              <div className="stat-top">
                <span>Total Records</span>
                <span className="stat-icon">▦</span>
              </div>
              <h2>{employeeAttendance.length}</h2>
              <p>Attendance entries</p>
            </div>

            <div className="stat-card green">
              <div className="stat-top">
                <span>Present Days</span>
                <span className="stat-icon">✓</span>
              </div>
              <h2>{presentDays}</h2>
              <p>Records with check-in</p>
            </div>

            <div className="stat-card purple">
              <div className="stat-top">
                <span>Completed Shifts</span>
                <span className="stat-icon">◷</span>
              </div>
              <h2>{completedDays}</h2>
              <p>Check-in and check-out recorded</p>
            </div>

            <div className="stat-card orange">
              <div className="stat-top">
                <span>Today's Status</span>
                <span className="stat-icon">↗</span>
              </div>
              <h2>
                {!todayRecord
                  ? 'No entry'
                  : todayRecord.outTime
                    ? 'Completed'
                    : todayRecord.inTime
                      ? 'Checked in'
                      : 'No entry'}
              </h2>
              <p>
                {todayRecord?.inTime
                  ? `In: ${formatTime(todayRecord.inTime)}`
                  : 'No check-in recorded today'}
              </p>
            </div>
          </section>

          <section className="action-banner">
            <div>
              <span className="eyebrow">ATTENDANCE OVERVIEW</span>
              <h2>Your working day at a glance.</h2>
              <p>
                Your attendance information is loaded from the
                Spring Boot backend.
              </p>
            </div>

            <div className="today-times">
              <div>
                <span>Check-in</span>
                <strong>
                  {formatTime(todayRecord?.inTime)}
                </strong>
              </div>
              <div>
                <span>Check-out</span>
                <strong>
                  {formatTime(todayRecord?.outTime)}
                </strong>
              </div>
            </div>
          </section>

          <section className="panel">
            <div className="panel-header">
              <div>
                <h2>Attendance History</h2>
                <p className="muted">
                  Review your recorded attendance.
                </p>
              </div>

              <span className="record-count">
                {filteredAttendance.length} records
              </span>
            </div>

            <div className="table-controls">
              <input
                type="search"
                placeholder="Search by date, ID or comment..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                aria-label="Search attendance"
              />

              <select
                value={statusFilter}
                onChange={(e) => setStatusFilter(e.target.value)}
                aria-label="Filter attendance"
              >
                <option value="all">All records</option>
                <option value="completed">Completed shifts</option>
                <option value="inprogress">In progress</option>
                <option value="noentry">No check-in</option>
              </select>
            </div>

            {loading ? (
              <div className="empty-state">
                Loading attendance records...
              </div>
            ) : (
              <div className="table-responsive">
                <table className="attendance-table">
                  <thead>
                    <tr>
                      <th>Attendance ID</th>
                      <th>Date</th>
                      <th>Employee ID</th>
                      <th>In Time</th>
                      <th>Out Time</th>
                      <th>Status</th>
                      <th>Comment</th>
                    </tr>
                  </thead>

                  <tbody>
                    {filteredAttendance.map((record, index) => {
                      const date =
                        record.attendancedate ||
                        record.inTime?.slice(0, 10);

                      const completed =
                        Boolean(record.inTime && record.outTime);

                      return (
                        <tr
                          key={record.attendanceId ?? `${date}-${index}`}
                        >
                          <td>
                            {record.attendanceId ?? '—'}
                          </td>
                          <td>{formatDate(date)}</td>
                          <td>
                            {record.employee?.empid ?? '—'}
                          </td>
                          <td>{formatTime(record.inTime)}</td>
                          <td>{formatTime(record.outTime)}</td>
                          <td>
                            <span
                              className={`status ${
                                completed
                                  ? 'status-green'
                                  : record.inTime
                                    ? 'status-orange'
                                    : 'status-red'
                              }`}
                            >
                              {completed
                                ? 'Completed'
                                : record.inTime
                                  ? 'In progress'
                                  : 'Absent'}
                            </span>
                          </td>
                          <td>{record.comment || '—'}</td>
                        </tr>
                      );
                    })}

                    {!filteredAttendance.length && (
                      <tr>
                        <td colSpan="7" className="empty-state">
                          {error
                            ? 'Attendance data could not be loaded.'
                            : 'No matching attendance records found.'}
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            )}
          </section>

          <footer className="dashboard-footer">
            <span>HRMS Employee Portal</span>
            <span>Attendance information from your backend</span>
          </footer>
        </main>
      </div>
    </div>
  );
}

export default Dashboard;
