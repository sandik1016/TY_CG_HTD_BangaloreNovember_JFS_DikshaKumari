import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ClientComponent } from './client/client.component';
import { AdminComponent } from './admin/admin.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { ProductComponent } from './product/product.component';
import { CustomerComponent } from './customer/customer.component';
import { ContractComponent } from './contract/contract.component';
import { OrderComponent } from './order/order.component';
import { HaulierComponent } from './haulier/haulier.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { AddProductComponent } from './add-product/add-product.component';
import { GetProductComponent } from './get-product/get-product.component';
import { GetallProductsComponent } from './getall-products/getall-products.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { RouterModule } from '@angular/router';
import { AddHaulierComponent } from './add-haulier/add-haulier.component';
import { GetHauliersComponent } from './get-hauliers/get-hauliers.component';
import { SearchHauliersComponent } from './search-hauliers/search-hauliers.component';
import { EditHaulierComponent } from './edit-haulier/edit-haulier.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { GetallContractsComponent } from './getall-contracts/getall-contracts.component';
import { SearchContractsComponent } from './search-contracts/search-contracts.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { GetallOrdersComponent } from './getall-orders/getall-orders.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { SearchOrderComponent } from './search-order/search-order.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { GetallCustomersComponent } from './getall-customers/getall-customers.component';
import { GetCustomerComponent } from './get-customer/get-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { AddUserComponent } from './add-user/add-user.component';
import { GetallUsersComponent } from './getall-users/getall-users.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ClientComponent,
    AdminComponent,
    SchedulerComponent,
    ProductComponent,
    CustomerComponent,
    ContractComponent,
    OrderComponent,
    HaulierComponent,
    PagenotfoundComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    AddProductComponent,
    GetProductComponent,
    GetallProductsComponent,
    EditProductComponent,
    AddHaulierComponent,
    GetHauliersComponent,
    SearchHauliersComponent,
    EditHaulierComponent,
    AddContractComponent,
    GetallContractsComponent,
    SearchContractsComponent,
    EditContractComponent,
    AddOrderComponent,
    GetallOrdersComponent,
    EditOrderComponent,
    SearchOrderComponent,
    AddCustomerComponent,
    GetallCustomersComponent,
    GetCustomerComponent,
    EditCustomerComponent,
    AddUserComponent,
    GetallUsersComponent

  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
