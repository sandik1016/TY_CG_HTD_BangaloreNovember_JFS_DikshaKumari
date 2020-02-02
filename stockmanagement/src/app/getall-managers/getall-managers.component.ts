import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-managers',
  templateUrl: './getall-managers.component.html',
  styleUrls: ['./getall-managers.component.css']
})
export class GetallManagersComponent implements OnInit {
  success: string;

  managers: any;
  constructor(private userService: UserService, private router: Router) {
    this.getUsers();
  }

  getUsers() {
    this.userService.getAllManagersData().subscribe(response => {
      console.log(response);
      this.managers = response.manager;
    }, err => {
      console.log(err);
    });
  }

  deleteUser(manager: any) {
    this.userService.deleteManagerData(manager).subscribe(response => {
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
