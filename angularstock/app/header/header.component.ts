import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  [x: string]: any;

  constructor() { }

  ngOnInit() {
  }

  isAdmin() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if ( userDetails && userDetails.manager[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isClient() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if ( userDetails && userDetails.manager[0].role === 'client') {
      return true;
    } else {
      return false;
    }
  }

  isScheduler() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if ( userDetails && userDetails.manager[0].role === 'scheduler') {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.removeItem('userDetails');
  
  }

}
