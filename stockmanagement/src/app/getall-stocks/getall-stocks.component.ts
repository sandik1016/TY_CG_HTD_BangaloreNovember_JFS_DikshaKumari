import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-stocks',
  templateUrl: './getall-stocks.component.html',
  styleUrls: ['./getall-stocks.component.css']
})
export class GetallStocksComponent implements OnInit {
  success: string;
  stocks: any;
  constructor(private userService: UserService, private router: Router) {
    this.getStocks();
  }

  getStocks() {
    this.userService.getAllStocksData().subscribe(response => {
      console.log(response);
      this.stocks = response.stock;
    }, err => {
      console.log(err);
    });
  }
  deleteStock(stock: any) {
    this.userService.deleteStockData(stock).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.stocks.splice(this.stocks.indexOf(stock), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectStock(stock) {
    this.userService.selectedStockToUpdate = stock;
    this.router.navigateByUrl('/edit-stock');
  }

  ngOnInit() {
  }

}

