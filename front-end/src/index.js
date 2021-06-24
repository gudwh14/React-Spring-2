import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'Style/Manager/layout.css';
import 'Style/Manager/basic.css';
import 'Style/Manager/login.css';
import 'Style/Manager/signup.css';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter, Switch, Route} from "react-router-dom";
import managerRoute from 'Routes/ManagerRoute';

ReactDOM.render(
  <React.StrictMode>
      <BrowserRouter>
          <Switch>
              {
                  managerRoute.map((routes)=> {
                      return (
                          <Route path={routes.path} exact={routes.exact} component={routes.component}/>
                      )
                  })
              }
          </Switch>
      </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
