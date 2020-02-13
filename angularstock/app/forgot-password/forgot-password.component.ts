import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  constructor(public userService: UserService,
              private router: Router) { }

forgotPassword(form: NgForm) {
this.userService.forgotPassword(form.value).subscribe(response => {
console.log(response);
if (response.statusCode === 201) {
this.router.navigateByUrl('/login');
}
form.reset();
});
}

ngOnInit() {
}
}
