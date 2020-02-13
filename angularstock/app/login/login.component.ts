import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';

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
      if ( data.status === 201) {
        console.log(data.message);
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user details stored in local storage');
        this.router.navigateByUrl('/');
      } else if ( data.status === 405 ) {
        this.failure = data.message;
        setInterval(() => {
          this.failure = null;
          }, 5000);
      } else  {
        this.exception = data.message;
        setInterval(() => {
          this.exception = null;
          }, 5000);
      }
    });

}
}
