import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  message: string;

  products: Product[];
    constructor(private productServie: ProductService,
                private router: Router) {
      this.getProducts();
    }
  getProducts() {
    this.productServie.getData().subscribe(response => {
      console.log(response);
      this.products = response.beans;
    }, err => {
      console.log(err);
    });
  }
  deleteProduct(product: Product) {
    this.productServie.deleteData(product).subscribe(res => {
      console.log(res);
      if (res.message === 'deleted successfully') {
        this.products.splice(this.products.indexOf(product), 1);
        this.message = res.message;
      }
    });
    }

    deleteMessage() {
      this.message = null;
    }

    selectProduct(product) {
      this.productServie.selectedProductToUpdate = product;
      this.router.navigateByUrl('/edit-product');
    }
      ngOnInit() {
      }

}
