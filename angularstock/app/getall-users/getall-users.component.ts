import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-users',
  templateUrl: './getall-users.component.html',
  styleUrls: ['./getall-users.component.css']
})
export class GetallUsersComponent implements OnInit {

  success: string;

  managers: Manager[];
  constructor(private userService: UserService, private router: Router) {
    this.getUsers();
  }

  getUsers() {
    this.userService.getAllUsersData().subscribe(response => {
      console.log(response);
      this.managers = response.manager;
    }, err => {
      console.log(err);
    });
  }

  deleteUser(manager: Manager) {
    this.userService.deleteUserData(manager).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.managers.splice(this.managers.indexOf(manager), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  ngOnInit() {
  }

}
