import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string;
  constructor(private auth: AuthenticationService,
              private router: Router) { }
  login(form: NgForm) {
this.auth.loginUser(form.value).subscribe(response => {
    console.log(response);
    if (response.statusCode === 201) {
     this.message = response.message;
     localStorage.setItem('userDetails', JSON.stringify(response));
     this.router.navigateByUrl('/');
     setTimeout(() => {
        this.message = null;
      }, 5000);

     form.reset();
    }
  }
  );
}

ngOnInit() {
}

}
