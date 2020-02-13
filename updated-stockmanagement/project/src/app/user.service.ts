import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userId;
  userName;
  userEmail;
  selectedCompanyToUpdate;
  selectedStockToUpdate;
  selectedManagerToUpdate;
  selectedSharesToUpdate;
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
   getAllManagersData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/view-all-users`);
  }

  sellShare(reqObj): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/sell-share`, reqObj);
  }

  deleteManagerData(user: any): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete-user/${user.userId}`);
  }
  login(user: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, user);
   }

  addCompanyData(company): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-company`, company);
  }
  addManagerData(user): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, user);
  }
  addUserData(user): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, user);
  }
  addStockData(stock): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/add-stock`, stock);
  }
  getAllCompaniesData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allcompanies`);
  }
  getAllSharesData(shareDetails: any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allshares/${shareDetails}`);
  }
  buyShare(reqObj): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/buy-share`, reqObj);
  }
  getAllStocksData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/get-allstocks`);
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
  updateManagerData(manager: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/change-password`,manager);
  }
  forgotPassword(user: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/forgot-password`,user);
  }
}

