import React, { useState } from 'react';

export default function Login() {
  const account = {
    id: 'abcd',
    password: '1234',
  };

  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (id === account.id && password === account.password) {
      alert('Login successful!');
      setMessage('Logged in successfully.');
    } else {
      alert('Login failed. Please check your ID and password.');
      setMessage('Login failed. Please check your ID and password.');
    }
    setId(''); // Clear input after submission
    setPassword(''); // Clear input after submission
  };

  return (
    <div>
      <h2>Login</h2>
      <p>{message}</p>
      <form onSubmit={handleSubmit}>
        <p>
          id:{' '}
          <input type='text' placeholder='ID' value={id} onChange={(e) => setId(e.target.value)} />
        </p>
        <p>
          pw:{' '}
          <input
            type='password'
            placeholder='Password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </p>
        <button type='submit'>Login</button>
      </form>
    </div>
  );
}
