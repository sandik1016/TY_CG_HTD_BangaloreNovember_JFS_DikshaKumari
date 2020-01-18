import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  selectedProductToUpdate: Product;
api = `http://localhost:8080`;
  constructor(private http: HttpClient) { }
  postData(product): Observable<any> {
    return this.http.post<any>(
      `${this.api}/register`,
    product);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/getAll`);
  }

  deleteData(product: Product): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/delete/${product.id}`
    );
  }

  updateData(product): Observable<any> {
    return this.http.put<any>(
      `${this.api}/change`,
      product
    );
  }
}
