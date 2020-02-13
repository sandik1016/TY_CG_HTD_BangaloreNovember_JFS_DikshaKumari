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
  exception: any;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }

  addStock(form: NgForm) {
    console.log(form);
    this.crudOperations.addStockData(form.value).subscribe(data => {

      if (data.statusCode === 201) {
        console.log(data);
        console.log(form.value);
        this.success = data.description;

      } else if( data.statusCode === 401 ) {
        console.log(data);
        this.failure = data.description;
      } else {
        console.log(data);
        console.log(form.value);
        this.exception = data.description;
      }
      setTimeout(() => {
          this.success = null;
          this.failure = null;
          this.exception = null;
        }, 2000);
      form.reset();
      }
    );

}

}
