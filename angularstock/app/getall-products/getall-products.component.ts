import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-products',
  templateUrl: './getall-products.component.html',
  styleUrls: ['./getall-products.component.css']
})
export class GetallProductsComponent implements OnInit {

  success: string;

  products: Product[];
  constructor(private userService: UserService, private router: Router) {
    this.getProducts();
  }

  getProducts() {
    this.userService.getAllProductsData().subscribe(response => {
      console.log(response);
      this.products = response.product;
    }, err => {
      console.log(err);
    });
  }
  deleteProduct(product: Product) {
    this.userService.deleteProductData(product).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.products.splice(this.products.indexOf(product), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectProduct(product) {
    this.userService.selectedProductToUpdate = product;
    this.router.navigateByUrl('/edit-product');
  }

  ngOnInit() {
  }

}
