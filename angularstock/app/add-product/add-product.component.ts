import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  success: string;
  failure: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }

  addProduct(form: NgForm) {
    console.log(form);
    this.crudOperations.addProductData(form.value).subscribe(data => {
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
