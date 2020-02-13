import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateCustomer(form: NgForm) {
this.userService.updateCustomerData(form.value).subscribe(response => {
console.log(response);
if (response.status === 201) {
this.router.navigateByUrl('customer/getall-customers');
}
form.reset();
});
}

ngOnInit() {
}


}
