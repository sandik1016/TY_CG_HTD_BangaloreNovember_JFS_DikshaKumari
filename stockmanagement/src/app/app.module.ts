import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CompanyComponent } from './company/company.component';
import { ManagerComponent } from './manager/manager.component';
import { AdminComponent } from './admin/admin.component';
import { InvestorComponent } from './investor/investor.component';
import { GetallCompaniesComponent } from './getall-companies/getall-companies.component';
import { AddCompanyComponent } from './add-company/add-company.component';
import { AddManagerComponent } from './add-manager/add-manager.component';
import { GetallManagersComponent } from './getall-managers/getall-managers.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { GetallStocksComponent } from './getall-stocks/getall-stocks.component';
import { StockComponent } from './stock/stock.component';
import { EditManagerComponent } from './edit-manager/edit-manager.component';
import { EditCompanyComponent } from './edit-company/edit-company.component';
import { EditStockComponent } from './edit-stock/edit-stock.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactUsComponent,
    PageNotFoundComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    CompanyComponent,
    ManagerComponent,
    AdminComponent,
    InvestorComponent,
    GetallCompaniesComponent,
    AddCompanyComponent,
    AddManagerComponent,
    GetallManagersComponent,
    ForgotPasswordComponent,
    AddStockComponent,
    GetallStocksComponent,
    StockComponent,
    EditManagerComponent,
    EditCompanyComponent,
    EditStockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
     
      {path: '', component: HomeComponent},
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent},
       //{path: 'logout', component: LogoutComponent},
       {path: 'contact-us', component: ContactUsComponent},
       {path: 'add-company', component: AddCompanyComponent},
       {path: 'add-stock', component: AddStockComponent},
       {path:'manager',component:ManagerComponent},
       {path: 'add-manager', component: AddManagerComponent},
       {path: 'admin', component: AdminComponent},
        {path: 'stock', component: StockComponent},
       {path: 'company', component: CompanyComponent},
       {path: 'investor', component: InvestorComponent},
       {path: 'getall-managers', component: GetallManagersComponent},
       {path: 'getall-companies', component: GetallCompaniesComponent},
       { path: 'forgot-password', component: ForgotPasswordComponent },
      {path: '**', component: PageNotFoundComponent}
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
