import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  success: string;
  failure: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }
  addCustomer(form: NgForm) {
    console.log(form);
    this.crudOperations.addCustomerData(form.value).subscribe(data => {
      console.log(data);
      if (data.status === 201) {
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 5000);
        form.reset();
      } else {
        this.failure = data.message;
        setTimeout(() => {
          this.failure = null;
        }, 5000);
      }
    });

}

}
