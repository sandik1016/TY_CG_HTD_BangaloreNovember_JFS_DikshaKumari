import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

    updateProduct(form: NgForm) {
      this.userService.updateProductData(form.value).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
      this.router.navigateByUrl('product/getall-products');
      }
      form.reset();
      });
      }

ngOnInit() {
}


}
