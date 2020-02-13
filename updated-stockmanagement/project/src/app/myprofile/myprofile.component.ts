import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-myprofile',
  templateUrl: './myprofile.component.html',
  styleUrls: ['./myprofile.component.css']
})
export class MyprofileComponent implements OnInit {

  name = null;
  email = null;


  constructor(private user: UserService) {
        this.name = this.user.userName;
        this.email = this.user.userEmail;
  }

  ngOnInit() {
  }

}
