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
    if ( userDetails && userDetails.user[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isManager() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if ( userDetails && userDetails.user[0].role === 'manager') {
      return true;
    } else {
      return false;
    }
  }

  isInvestor() {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if ( userDetails && userDetails.user[0].role === 'investor') {
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
