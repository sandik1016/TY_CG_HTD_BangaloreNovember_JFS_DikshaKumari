import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

              updateOrder(form: NgForm) {
                this.userService.updateOrderData(form.value).subscribe(response => {
                console.log(response);
                if (response.status === 201) {
                this.router.navigateByUrl('order/getall-orders');
                }
                form.reset();
                });
                }

  ngOnInit() {
  }

}
