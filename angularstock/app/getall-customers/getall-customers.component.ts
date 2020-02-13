import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-customers',
  templateUrl: './getall-customers.component.html',
  styleUrls: ['./getall-customers.component.css']
})
export class GetallCustomersComponent implements OnInit {

  success: string;

  customers: Customer[];
  constructor(private userService: UserService, private router: Router) {
    this.getCustomers();
  }

  getCustomers() {
    this.userService.getAllCustomersData().subscribe(response => {
      console.log(response);
      this.customers = response.customer;
    }, err => {
      console.log(err);
    });
  }
  deleteCustomer(customer: Customer) {
    this.userService.deleteCustomerData(customer).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.customers.splice(this.customers.indexOf(customer), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectCustomer(customer) {
    this.userService.selectedCustomerToUpdate = customer;
    this.router.navigateByUrl('/edit-customer');
  }

  ngOnInit() {
  }

}
