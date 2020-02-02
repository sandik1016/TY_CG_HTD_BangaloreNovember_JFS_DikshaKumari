import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  selectedCompanyToUpdate;
  selectedStockToUpdate;
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  register(user): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, user);
   }
   getAllManagersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/view-all-users`);
  }

  deleteManagerData(user: any): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-user/${user.userId}`);
  }

  addCompanyData(company): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-company`, company);
  }
  addStockData(stock): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-stock`, stock);
  }
  getAllCompaniesData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allcompanies`);
  }
  getAllStocksData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allstock`);
  }
  deleteCompanyData(company: any): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-company/${company.companyId}`);
  }
  deleteStockData(stock: any): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-stock/${stock.stockId}`);
  }
  updateCompanyData(company: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-company/${company.companyId}`,company);
  }
  updateStockData(stock: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update-stock/${stock.stockId}`,stock);
  }
}

