import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  selectedHaulierToUpdate: Haulier;
  selectedProductToUpdate: Product;
  selectedContractToUpdate: Contract;
  selectedCustomerToUpdate: Customer;
  selectedOrderToUpdate: Order;

  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  register(manager): Observable<any> {
   return this.http.post<any>(`${this.apiUrl}/register`, manager);
  }

  login(manager): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, manager);
   }

  getAllUsersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allusers`);
  }

  deleteUserData(manager: Manager): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-user/${manager.email}`);
  }

   addHaulierData(haulier): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-haulier`, haulier);
  }

  addCustomerData(customer): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-customer`, customer);
  }

  addContractData(contract): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-contract`, contract);
  }

  addProductData(product): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-product`, product);
  }

  addOrderData(order): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-order`, order);
  }

  getAllHauliersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allhauliers`);
  }

  getAllProductsData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allproducts`);
  }

  getAllOrdersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allorders`);
  }

  getAllContractsData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allcontracts`);
  }

  getAllCustomersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allcustomers`);
  }

  deleteHaulierData(haulier: Haulier): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-haulier/${haulier.haulierId}`);
  }

  deleteProductData(product: Product): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-product/${product.productId}`);
  }

  deleteContractData(contract: Contract): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-contract/${contract.contractNo}`);
  }

  deleteCustomerData(customer: Customer): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-customer/${customer.customerId}`);
  }

  deleteOrderData(order: Order): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-order/${order.orderNo}`);
  }

  updateHaulierData(haulier: Haulier): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-haulier/${haulier.haulierId}`, haulier);
  }

  updateCustomerData(customer: Customer): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-customer/${customer.customerId}`, customer);
  }

  updateOrderData(order: Order): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-order/${order.orderNo}`, order);
  }

  updateContractData(contract: Contract): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-contract/${contract.contractNo}`, contract);
  }
  updateProductData(product: Product): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-product/${product.productId}`, product);
  }
}
