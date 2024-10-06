// import logo from './logo.svg';
// import './App.css';
//
// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }
//
// export default App;

import React, { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    // Fetch data from the Spring Boot backend
    fetch("http://localhost:8080/api/hello")
        .then((response) => response.text())
        .then((data) => {
          setMessage(data); // Set the message to "Hello World"
        })
        .catch((error) => {
          console.error("Error fetching the data:", error);
        });
  }, []);

  return (
      <div className="App">
        <h1>{message}</h1>
      </div>
  );
}

export default App;