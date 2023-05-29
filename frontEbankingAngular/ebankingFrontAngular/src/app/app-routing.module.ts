import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {CustomerAccountsComponent} from "./customer-accounts/customer-accounts.component";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {ForbiddenComponent} from "./forbidden/forbidden.component";
import {MyaccountsComponent} from "./myaccounts/myaccounts.component";
import {TransferComponent} from "./transfer/transfer.component";
import {OperationsComponent} from "./operations/operations.component";


const routes: Routes = [
  { path :"", component : HomeComponent},
  { path :"home", component : HomeComponent},
  { path :"customers", component : CustomersComponent},
  { path :"accounts", component : AccountsComponent},
  { path :"new-customer", component : NewCustomerComponent},
  { path :"customer-accounts/:id", component : CustomerAccountsComponent},
  { path: 'login', component: LoginComponent },
  { path: 'myaccounts', component: MyaccountsComponent },
  { path: 'transfer', component: TransferComponent },
  { path: 'operations', component: OperationsComponent },
  { path: 'forbidden', component: ForbiddenComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
