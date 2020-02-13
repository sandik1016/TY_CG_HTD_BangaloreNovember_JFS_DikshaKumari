import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  failure: string;
  exception: string;
  constructor(private authService: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(form: NgForm) {
    this.authService.login(form.value).subscribe( data => {
      console.log(data);

      if ( data.statusCode === 201) {
        this.authService.userId = data.user[0].userId;
        this.authService.userName = data.user[0].name;
        this.authService.userEmail = data.user[0].email;
        console.log(data.description);
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user details stored in local storage');
        this.router.navigateByUrl('/');
      } else if ( data.statusCode === 405 ) {
        this.failure = data.description;
        setInterval(() => {
          this.failure = null;
          }, 5000);
      } else  {
        this.exception = data.description;
        setInterval(() => {
          this.exception = null;
          }, 5000);
      }
    });

}
}

