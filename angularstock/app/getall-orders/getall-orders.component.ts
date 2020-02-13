import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-orders',
  templateUrl: './getall-orders.component.html',
  styleUrls: ['./getall-orders.component.css']
})
export class GetallOrdersComponent implements OnInit {


  success: string;

  orders: Order[];
  constructor(private userService: UserService, private router: Router) {
    this.getOrders();
  }

  getOrders() {
    this.userService.getAllOrdersData().subscribe(response => {
      console.log(response);
      this.orders = response.order;
    }, err => {
      console.log(err);
    });
  }
  deleteOrder(order: Order) {
    this.userService.deleteOrderData(order).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.orders.splice(this.orders.indexOf(order), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectOrder(order) {
    this.userService.selectedOrderToUpdate = order;
    this.router.navigateByUrl('/edit-order');
  }

  ngOnInit() {
  }

}
