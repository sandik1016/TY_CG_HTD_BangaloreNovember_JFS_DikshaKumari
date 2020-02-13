import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-company',
  templateUrl: './edit-company.component.html',
  styleUrls: ['./edit-company.component.css']
})
export class EditCompanyComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateCompany(form: NgForm) {
  console.log(form.value);
  this.userService.updateCompanyData(form.value).subscribe(response => {
console.log(response);
if (response.statusCode === 201) {
this.router.navigateByUrl('/getall-companies');
}
form.reset();
});
}

ngOnInit() {
}


}
