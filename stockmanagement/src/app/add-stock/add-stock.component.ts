import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.css']
})
export class AddStockComponent implements OnInit {
  success: string;
  failure: string;
  description: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }
  addStock(form: NgForm) {
    console.log(form);
    this.crudOperations.addStockData(form.value).subscribe(data => {
      console.log(data);
      if (data.status === 201) {
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 5000);
        form.reset();
      } else {
        this.failure = data.description;
        setTimeout(() => {
          this.failure = null;
        }, 5000);
      }
    });
  }
}