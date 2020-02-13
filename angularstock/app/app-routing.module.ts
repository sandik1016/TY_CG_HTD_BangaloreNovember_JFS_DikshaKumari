import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { ClientComponent } from './client/client.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { ProductComponent } from './product/product.component';
import { ContractComponent } from './contract/contract.component';
import { OrderComponent } from './order/order.component';
import { CustomerComponent } from './customer/customer.component';
import { HaulierComponent } from './haulier/haulier.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AddProductComponent } from './add-product/add-product.component';
import { GetProductComponent } from './get-product/get-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { GetallProductsComponent } from './getall-products/getall-products.component';
import { AddHaulierComponent } from './add-haulier/add-haulier.component';
import { SearchHauliersComponent } from './search-hauliers/search-hauliers.component';
import { GetHauliersComponent } from './get-hauliers/get-hauliers.component';
import { EditHaulierComponent } from './edit-haulier/edit-haulier.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { SearchContractsComponent } from './search-contracts/search-contracts.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { GetallContractsComponent } from './getall-contracts/getall-contracts.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { SearchOrderComponent } from './search-order/search-order.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { GetallOrdersComponent } from './getall-orders/getall-orders.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { GetCustomerComponent } from './get-customer/get-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { GetallCustomersComponent } from './getall-customers/getall-customers.component';
import { AddUserComponent } from './add-user/add-user.component';
import { GetallUsersComponent } from './getall-users/getall-users.component';
import { AuthenticationGuard } from 'src/AuthenticationGuard';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'admin', component: AdminComponent,
  canActivate: [AuthenticationGuard],
  data: {expectedRoles: ['admin']}},
    {path: 'add-user', component: AddUserComponent},
    {path: 'getall-users', component: GetallUsersComponent},
  {path: 'client', component: ClientComponent, canActivate: [AuthenticationGuard],
  data: {expectedRoles: ['admin', 'client', 'scheduler']}},
  {path: 'scheduler', component: SchedulerComponent, canActivate: [AuthenticationGuard],
  data: {expectedRoles: ['admin', 'scheduler']}},
  {path: 'product', component: ProductComponent, children: [
    {path: 'add-product', component: AddProductComponent},
    {path: 'get-product', component: GetProductComponent},
    {path: 'getall-products', component: GetallProductsComponent}
  ]},
  {path: 'edit-product', component: EditProductComponent},
  {path: 'contract', component: ContractComponent, children: [
    {path: 'add-contract', component: AddContractComponent},
    {path: 'get-contract', component: SearchContractsComponent},
    {path: 'getall-contracts', component: GetallContractsComponent}
  ]},
  {path: 'edit-contract', component: EditContractComponent},
  {path: 'order', component: OrderComponent, children: [
    {path: 'add-order', component: AddOrderComponent},
    {path: 'get-order', component: SearchOrderComponent},
    {path: 'getall-orders', component: GetallOrdersComponent}
  ]},
  {path: 'edit-order', component: EditOrderComponent},
  {path: 'customer', component: CustomerComponent, children: [
    {path: 'add-customer', component: AddCustomerComponent},
    {path: 'get-customer', component: GetCustomerComponent},
    {path: 'getall-customers', component: GetallCustomersComponent}
  ]},
  {path: 'edit-customer', component: EditCustomerComponent},
  {path: 'haulier', component: HaulierComponent,  children: [
    {path: 'add-haulier', component: AddHaulierComponent},
    {path: 'get-haulier', component: SearchHauliersComponent},
   {path: 'getall-hauliers', component: GetHauliersComponent}
  ]},
  {path: 'edit-haulier', component: EditHaulierComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'logout', component: LogoutComponent},
  {path: '**', component: PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
